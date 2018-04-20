package com.github.bh.hjob.core.thrift;

import com.github.bh.hjob.core.model.*;
import com.github.bh.hjob.core.constants.JobOperateType;
import com.github.bh.hjob.core.constants.JobResCode;
import com.github.bh.hjob.core.persist.base.model.ScheduleJob;
import com.github.bh.hjob.core.service.QuartzService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobenhai
 */
@Service
public class JobThriftIface  {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobThriftIface.class);

	@Autowired
	private QuartzService quartzService;


	public ScheduleJobResponse createJob(ScheduleJobCreateRequest request)  {
		ScheduleJobResponse res = new ScheduleJobResponse();
		ScheduleJob job = new ScheduleJob();
		job.setJobName(request.getJobName());
		job.setJobNotifyKey(request.getJobNotifyKey());
		job.setCronexpression(request.getCronexpression());
		job.setJobGroup(request.getJobGroup());
		job.setDescription(request.getDescription());
		quartzService.createOrUpdateQuartz(job);
		res.setCode(JobResCode.SUCCESS.getValue());
		return res;
	}


	public ScheduleJobResponse deleteJob(ScheduleJobDeleteRequest request) {
		ScheduleJobResponse res = new ScheduleJobResponse();
		try {
			quartzService.deleteQuartz(request.getJobName(), request.getJobGroup());
			res.setCode(JobResCode.SUCCESS.getValue());
		} catch (Exception e) {
			res.setCode(JobResCode.FAIL.getValue());
		}
		return res;
	}

	public ScheduleJobResponse updateJob(ScheduleJobUpdateRequest request) {
		ScheduleJobResponse res = new ScheduleJobResponse();
		ScheduleJob job = new ScheduleJob();
		job.setJobName(request.getJobName());
		job.setJobGroup(request.getJobGroup());
		job.setCronexpression(request.getCronexpression());
		job.setDescription(request.getDescription());
		quartzService.createOrUpdateQuartz(job);
		res.setCode(JobResCode.SUCCESS.getValue());
		return res;
	}


	public ScheduleJobResponse operJob(ScheduleJobOperRequest request) {
		ScheduleJobResponse res = new ScheduleJobResponse();
		try {
			if (request.getOper() == JobOperateType.PAUSE.getValue()) {
				quartzService.pauseQuartz(request.getJobName(), request.getJobGroup());
				res.setCode(JobResCode.SUCCESS.getValue());
			} else if (request.getOper() == JobOperateType.RESUME.getValue()) {
				quartzService.resumeQuartz(request.getJobName(), request.getJobGroup());
				res.setCode(JobResCode.SUCCESS.getValue());
			} else {
				res.setCode(JobResCode.FAIL.getValue());
			}
		} catch (Exception e) {
			LOGGER.error("[operJob] error, jobName: {}, jobGroup: {}, emsg: {}, e: {}", request.getJobName(),
					request.getJobGroup(), e.getMessage(), e);
			res.setCode(JobResCode.FAIL.getValue());
		}
		return res;
	}

	public ScheduleJobQueryResponse queryJobs(ScheduleJobQueryRequest request)  {
		ScheduleJobQueryResponse res = new ScheduleJobQueryResponse();
		List<ScheduleJobWrapper> jobWrappers = new ArrayList<>();
		try {
			List<ScheduleJob> jobs;
			if (StringUtils.isNotBlank(request.getJobName()) || StringUtils.isNotBlank(request.getJobGroup())) {
				jobs = quartzService.getJobs(request.getJobName(), request.getJobGroup());
			} else {
				jobs = quartzService.getAllJobs();
			}
			if (CollectionUtils.isNotEmpty(jobs)) {
				for (ScheduleJob job : jobs) {
					ScheduleJobWrapper jobWrapper = new ScheduleJobWrapper();
					jobWrapper.setJobId(job.getJobId() == null ? 0L : job.getJobId());
					jobWrapper.setJobName(job.getJobName());
					jobWrapper.setJobGroup(job.getJobGroup());
					jobWrapper.setJobStatus(job.getJobStatus());
					jobWrapper.setJobDetailStatus(job.getJobDetailStatus());
					jobWrapper.setCronexpression(job.getCronexpression());
					jobWrapper.setMqKey(job.getJobNotifyKey());
					jobWrapper.setDescription(job.getDescription());
					if (job.getNextTime() != null) {
						jobWrapper.setNextTime(job.getNextTime().getTime());
					}
					if (job.getPreviousTime() != null) {
						jobWrapper.setPreviousTime(job.getPreviousTime().getTime());
					}
					jobWrappers.add(jobWrapper);
				}
			}
			res.setJoblist(jobWrappers);
		} catch (Exception e) {
			LOGGER.error("[queryJobs] error, jobId: {}, jobName: {}, jobGroup: {}, emsg: {}, e: {}", request.getJobId(),
					request.getJobName(), request.getJobGroup(), e.getMessage(), e);
			res.setJoblist(jobWrappers);
		}
		return res;
	}
}
