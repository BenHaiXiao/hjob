
package com.github.bh.hjob.core;

import com.github.bh.hjob.mq.EventRedisProducer;
import com.github.bh.hjob.core.constants.Command;
import com.github.bh.hjob.utils.SpringHolder;
import com.github.bh.hjob.core.bo.ScheduleJob;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiaobenhai
 */
@DisallowConcurrentExecution
public class QuartzJobFactory implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzJobFactory.class);

    private EventRedisProducer eventRedisProducer;
    public QuartzJobFactory() {
        this.eventRedisProducer = SpringHolder.getContext().getBean(EventRedisProducer.class);
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = new ScheduleJob();
        try {
            scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
            LOGGER.info("ScheduledJob<execute> 定时任务Id = [{}] 定时任务名称 = [{}] start...", scheduleJob.getJobId(), scheduleJob.getJobName());
            eventRedisProducer.enqueue(scheduleJob.getJobNotifyKey(), Command.START.getValue());

        } catch (Exception e) {
            LOGGER.error("ScheduledJob<execute> 定时任务Id = [{}] 定时任务名称 = [{}] exception:{}", scheduleJob.getJobId(), scheduleJob.getJobName(), e.getMessage(), e);
        }
        LOGGER.info("ScheduledJob<execute> 定时任务Id = [{}] 定时任务名称 = [{}] end...", scheduleJob.getJobId(), scheduleJob.getJobName());
    }
}
