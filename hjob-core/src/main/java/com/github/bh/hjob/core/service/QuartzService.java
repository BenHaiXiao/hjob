package com.github.bh.hjob.core.service;

import com.github.bh.hjob.core.persist.base.model.ScheduleJob;
import com.github.bh.hjob.core.constants.JobStatus;
import com.github.bh.hjob.core.QuartzJobFactory;
import com.github.bh.hjob.core.repository.ScheduleJobRepository;
import org.apache.commons.collections.CollectionUtils;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author xiaobenhai
 */
@Service
public class QuartzService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzService.class);

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Autowired
    private ScheduleJobRepository scheduleJobRepository;

    /**
     * 任务更新(已存在的则更新)
     */
    public void updateQuartz(String jobName, String jobGroup, String cron) throws Exception {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();

            LOGGER.info("updateQuartz, jobName:{},jobGroup:{},cron:{}", jobName, jobGroup, cron);
            // 获取触发器标识
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            // 获取触发器trigger
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // Trigger已存在，那么更新相应的定时设置
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);

            // 按新的cronExpression表达式重新构建trigger
            trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder)
                    .startAt(new Date()).build();

            // 按新的trigger重新设置job执行
            Date nextExecuteDate = scheduler.rescheduleJob(triggerKey, trigger);
            LOGGER.info("updateQuartz, jobName:{},jobGroup:{},cron:{},next excute date:{} success...", jobName, jobGroup, cron, nextExecuteDate);

        } catch (Exception e) {
            LOGGER.error("updateQuartz jobName:{},jobGroup:{},cron:{},exception:{}", jobName, jobGroup, cron, e.getMessage(), e);
            throw e;
        }

    }

    /**
     * 任务创建与更新(未存在的就创建，已存在的则更新)
     */
    public Date createOrUpdateQuartz(ScheduleJob job) {
        Date nextExecuteDate = null;
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            if (null != job) {
                LOGGER.info("method<createOrUpdateQuartz> dest job:{}", job);
                // 获取触发器标识
                TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
                // 获取触发器trigger
                CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                if (null == trigger) {// 不存在任务
                    LOGGER.info("method<createOrUpdateQuartz> create job:{} start...", job);
                    // 创建任务
                    JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                            .withIdentity(job.getJobName(), job.getJobGroup()).build();
                    jobDetail.getJobDataMap().put("scheduleJob", toSerialJob(job));
                    // 表达式调度构建器
                    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronexpression());
                    // 按新的cronExpression表达式构建一个新的trigger
                    trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup())
                            .withSchedule(scheduleBuilder).build();
                    nextExecuteDate = scheduler.scheduleJob(jobDetail, trigger);
                    job.setJobStatus(JobStatus.JOB_STATUS_ENABLE.getValue());
					Trigger.TriggerState triggerState = scheduler.getTriggerState(triggerKey);
                    job.setJobDetailStatus(triggerState.name());
                    job.setNextTime(nextExecuteDate);

                    // 存进数据库
                    if (scheduleJobRepository.insert(job)) {
                    	LOGGER.info("method<createOrUpdateQuartz> insert job: {} successfully!", job);
					} else {
						LOGGER.info("method<createOrUpdateQuartz> insert job: {} unsuccessfully!", job);
					}

                    LOGGER.info("method<createOrUpdateQuartz> create job:{} end...", job);
                } else {// 存在任务
                    LOGGER.info("method<createOrUpdateQuartz> update job:{} start...", job);
                    // Trigger已存在，那么更新相应的定时设置
                    // 表达式调度构建器
                    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronexpression());
                    // 按新的cronExpression表达式重新构建trigger
                    trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                    // 按新的trigger重新设置job执行
                    nextExecuteDate = scheduler.rescheduleJob(triggerKey, trigger);
                    job.setJobStatus(JobStatus.JOB_STATUS_ENABLE.getValue());
					Trigger.TriggerState triggerState = scheduler.getTriggerState(triggerKey);
					job.setJobDetailStatus(triggerState.name());
                    job.setNextTime(nextExecuteDate);

                    // 更新数据库
					if (scheduleJobRepository.update(job)) {
						LOGGER.info("method<createOrUpdateQuartz> update job: {} successfully!", job);
					} else {
						LOGGER.info("method<createOrUpdateQuartz> update job: {} unsuccessfully!", job);
					}
                    LOGGER.info("method<createOrUpdateQuartz> update job:{} end...", job);
                }

            }
        } catch (Exception e) {
            LOGGER.error("method<createOrUpdateQuartz> job:{} exception:{}", job, e.getMessage(), e);
            job.setJobStatus(JobStatus.JOB_STATUS_DISABLE.getValue());
        }
        return nextExecuteDate;

    }

    /**
     * 暂停任务
     */
    public void pauseQuartz(String jobName, String jobGroup) throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            scheduler.pauseJob(jobKey);
			Trigger.TriggerState triggerState = scheduler.getTriggerState(triggerKey);
			scheduleJobRepository.operate(jobName, jobGroup, triggerState.name(), getJobStatus(triggerState.name()).getValue());

            LOGGER.info("pauseQuartz, jobName:{},jobGroup:{} success...", jobName, jobGroup);
        } catch (Exception e) {
            LOGGER.error("pauseQuartz jobName:{},jobGroup:{},exception:{}", jobName, jobGroup, e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 恢复任务
     */
    public void resumeQuartz(String jobName, String jobGroup) throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
		TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            scheduler.resumeJob(jobKey);
			Trigger.TriggerState triggerState = scheduler.getTriggerState(triggerKey);
			scheduleJobRepository.operate(jobName, jobGroup, triggerState.name(), getJobStatus(triggerState.name()).getValue());

            LOGGER.info("resumeQuartz, jobName:{},jobGroup:{} success...", jobName, jobGroup);
        } catch (Exception e) {
            LOGGER.error("resumeQuartz jobName:{},jobGroup:{},exception:{}", jobName, jobGroup, e.getMessage(), e);
            throw e;
        }

    }

    /**
     * 删除任务
     */
    public void deleteQuartz(String jobName, String jobGroup) throws Exception {

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.deleteJob(jobKey);
			LOGGER.info("deleteQuartz, jobName:{},jobGroup:{} success...", jobName, jobGroup);

			scheduleJobRepository.delete(jobName, jobGroup);
			LOGGER.info("delete ScheduleJob, jobName: {}, jobGroup: {}", jobName, jobGroup);
        } catch (Exception e) {
            LOGGER.error("deleteQuartz jobName:{},jobGroup:{},exception:{}", jobName, jobGroup, e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 获取单个任务
     */
    public List<ScheduleJob> getJobs(String jobName, String jobGroup) throws Exception {
        try {
			List<ScheduleJob> dbJobs = scheduleJobRepository.getByNameAndGroup(jobName, jobGroup);
			if (CollectionUtils.isEmpty(dbJobs)) {
				return new ArrayList<>();
			}
			for (ScheduleJob dbJob : dbJobs) {
				Scheduler scheduler = schedulerFactoryBean.getScheduler();
				TriggerKey triggerKey = TriggerKey.triggerKey(dbJob.getJobName(), dbJob.getJobGroup());
				CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
				if (null != trigger) {
					dbJob.setNextTime(trigger.getNextFireTime());	// 下次触发时间
					dbJob.setPreviousTime(trigger.getPreviousFireTime());	// 上次触发时间
					Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
					LOGGER.info("getJob 定时任务名称 = [{}] 定时任务组 = [{}] state:{}", jobName, jobGroup, triggerState.name());
					dbJob.setJobDetailStatus(triggerState.name());
					dbJob.setJobStatus(getJobStatus(triggerState.name()).getValue());
					String cronExpression = trigger.getCronExpression();
					dbJob.setCronexpression(cronExpression);
				}
			}
			return dbJobs;
        } catch (Exception e) {
            LOGGER.error("getJob jobName:{},jobGroup:{},exception:{}", jobName, jobGroup, e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 获取所有任务
     */
    public List<ScheduleJob> getAllJobs() throws Exception {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
            List<ScheduleJob> jobList = new ArrayList<>();
            for (JobKey jobKey : jobKeys) {
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                for (Trigger trigger : triggers) {
                    ScheduleJob job = new ScheduleJob();
                    job.setJobName(jobKey.getName());
                    job.setJobGroup(jobKey.getGroup());

                    job.setNextTime(trigger.getNextFireTime()); // 下次触发时间
                    // trigger.getFinalFireTime();//最后一次执行时间
                    job.setPreviousTime(trigger.getPreviousFireTime());// 上次触发时间
                    // 触发器当前状态
                    Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                    LOGGER.info("getAllJobs 定时任务名称 = {} 定时任务组 = {} state={}", jobKey.getName(), jobKey.getGroup(), triggerState.name());
                    job.setJobDetailStatus(triggerState.name());
                    job.setJobStatus(getJobStatus(triggerState.name()).getValue());
                    if (trigger instanceof CronTrigger) {
                        CronTrigger cronTrigger = (CronTrigger) trigger;
                        String cronExpression = cronTrigger.getCronExpression();
                        job.setCronexpression(cronExpression);
                    }

					List<ScheduleJob> dbJobs = scheduleJobRepository.getByNameAndGroup(jobKey.getName(), jobKey.getGroup());
					if (CollectionUtils.isNotEmpty(dbJobs)) {
						ScheduleJob dbJob = dbJobs.get(0);
						job.setJobNotifyKey(dbJob.getJobNotifyKey());
						job.setDescription(dbJob.getDescription());
					}
                    jobList.add(job);
                }
            }
            return jobList;
        } catch (Exception e) {
            LOGGER.error("getAllJobs exception:{}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 所有正在运行的job
     */
    public List<ScheduleJob> getRunningJob() throws Exception {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
            List<ScheduleJob> jobList = new ArrayList<ScheduleJob>(executingJobs.size());
            for (JobExecutionContext executingJob : executingJobs) {
                ScheduleJob job = new ScheduleJob();
                JobDetail jobDetail = executingJob.getJobDetail();
                JobKey jobKey = jobDetail.getKey();
                Trigger trigger = executingJob.getTrigger();
                job.setJobName(jobKey.getName());
                job.setJobGroup(jobKey.getGroup());
                // 触发器当前状态
                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                LOGGER.info("getRunningJob 定时任务名称 = {} 定时任务组 = {} state={}", jobKey.getName(), jobKey.getGroup(), triggerState.name());
                job.setJobDetailStatus(triggerState.name());
                if ("NONE".equalsIgnoreCase(triggerState.name()) || "ERROR".equalsIgnoreCase(triggerState.name())
                    || "PAUSED".equalsIgnoreCase(triggerState.name())) {
                    job.setJobStatus(JobStatus.JOB_STATUS_DISABLE.getValue());
                } else {
                    job.setJobStatus(JobStatus.JOB_STATUS_ENABLE.getValue());
                }
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    job.setCronexpression(cronExpression);
                }
                jobList.add(job);
            }
            return jobList;
        } catch (Exception e) {
            LOGGER.error("getRunningJob exception:{}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 暂停调度中所有的job任务
     */
    public void pauseAll() throws Exception {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            scheduler.pauseAll();
            LOGGER.info("pauseAll  susscess...");
        } catch (Exception e) {
            LOGGER.error("pauseAll exception:{}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 恢复调度中所有的job的任务
     */
    public void resumeAll() throws Exception {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            scheduler.resumeAll();
            LOGGER.info("resumeAll  susscess...");
        } catch (Exception e) {
            LOGGER.error("resumeAll exception:{}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 停止调度Job任务
     */
    public boolean unscheduleJob(String jobName, String jobGroup) throws Exception {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            if (null == triggerKey) {
                return false;
            }
            boolean isSuccess = scheduler.unscheduleJob(triggerKey);
            return isSuccess;
        } catch (Exception e) {
            LOGGER.error("unscheduleJob exception:{}", e.getMessage(), e);
            throw e;
        }
    }

	private JobStatus getJobStatus(String triggerState) {
		if ("NONE".equalsIgnoreCase(triggerState) || "ERROR".equalsIgnoreCase(triggerState)
				|| "PAUSED".equalsIgnoreCase(triggerState)) {
			return JobStatus.JOB_STATUS_DISABLE;
		} else {
			return JobStatus.JOB_STATUS_ENABLE;
		}
	}

    private com.github.bh.hjob.core.bo.ScheduleJob toSerialJob(ScheduleJob job) {
        com.github.bh.hjob.core.bo.ScheduleJob serialJob = new com.github.bh.hjob.core.bo.ScheduleJob();
        serialJob.setJobId(job.getJobId() == null ? 0L : job.getJobId());
        serialJob.setJobName(job.getJobName());
        serialJob.setJobGroup(job.getJobGroup());
        serialJob.setJobNotifyKey(job.getJobNotifyKey());
        serialJob.setJobDetailStatus(job.getJobDetailStatus());
        serialJob.setJobStatus(job.getJobStatus() == null ? JobStatus.JOB_STATUS_ENABLE.getValue() : job.getJobStatus());
        serialJob.setCronexpression(job.getCronexpression());
        serialJob.setPreviousTime(job.getPreviousTime());
        serialJob.setNextTime(job.getNextTime());
        serialJob.setDescription(job.getDescription());
        return serialJob;
    }

}
