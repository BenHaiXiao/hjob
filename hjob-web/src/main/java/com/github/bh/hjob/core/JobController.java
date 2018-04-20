package com.github.bh.hjob.core;


import com.github.bh.hjob.core.domain.ServiceResult;
import com.github.bh.hjob.core.dtgrid.Pager;
import com.github.bh.hjob.core.model.*;
import com.github.bh.hjob.core.thrift.JobThriftIface;
import com.github.bh.hjob.core.thrift.ScheduleJobService;
import com.github.bh.hjob.json.GsonUtils;
import com.github.bh.hjob.core.constants.JobOperateType;
import com.github.bh.hjob.core.constants.JobResCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author xiaobenhai
 */
@Controller
@RequestMapping("/job")
public class JobController {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobController.class);

	@Autowired
	private JobThriftIface jobThriftClient;

	@Autowired
	private ScheduleJobService scheduleJobService;

	@RequestMapping("/mgr")
	public String mgr() {
		return "job/job-mgr";
	}
	@RequestMapping("/groups")
	@ResponseBody
	public ServiceResult<List<String>> queryGroups() {
		return ServiceResult.success(scheduleJobService.queryGroups());
	}



	@RequestMapping("/create")
	@ResponseBody
	public ResponseData createJob(String jobName,
								  String jobNotifyKey,
								  String cronexpression,
								  String jobGroup,
								  String description) {
		LOGGER.info("[createJob] start, jobName: {}, jobGroup: {}, cronexpression: {}, description: {}, user: {},",
				jobName, jobGroup, cronexpression, description);
		ScheduleJobResponse res = null;
		try {
			ScheduleJobCreateRequest req = new ScheduleJobCreateRequest();
			req.setJobName(jobName);
			req.setJobNotifyKey(jobNotifyKey);
			req.setCronexpression(cronexpression);
			req.setJobGroup(jobGroup);
			req.setDescription(description);
			res = jobThriftClient.createJob(req);
			LOGGER.info("[createJob] end, jobName: {}, jobGroup: {}, cronexpression: {}, description: {}, res: {}",
					jobName, jobGroup, cronexpression, description, res);
			if (res.getCode() == JobResCode.SUCCESS.getValue()) {
				return ResponseData.success(null);
			} else {
				return ResponseData.fail(null, "创建任务失败");
			}
		} catch (Exception e) {
			LOGGER.error("[createJob], jobName: {},jobNotifyKey:{}, jobGroup: {},cronexpression:{},res:{},emsg:{}", jobName, jobGroup, res, e.getMessage(), e);
			return ResponseData.fail(null, "创建任务异常");
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ResponseData deleteJob(String jobName,
								  String jobGroup,
								  HttpServletRequest request,
								  HttpServletResponse response) {
		LOGGER.info("[deleteJob] start, jobName: {}, jobGroup: {}", jobName, jobGroup);
		ScheduleJobResponse res = null;
		try {
			ScheduleJobDeleteRequest req = new ScheduleJobDeleteRequest();
			req.setJobName(jobName);
			req.setJobGroup(jobGroup);
			res = jobThriftClient.deleteJob(req);
			LOGGER.info("[deleteJob] end, jobName: {}, jobGroup: {},res:{}", jobName, jobGroup, res);
			if (res.getCode() == JobResCode.SUCCESS.getValue()) {
				return ResponseData.success(null);
			} else {
				return ResponseData.fail(null, "删除任务失败");
			}
		} catch (Exception e) {
			LOGGER.error("[deleteJob] error, jobName: {}, jobGroup: {}, res: {}, emsg: {}, e: {}",
					jobName, jobGroup, res, e.getMessage(), e);
			return ResponseData.fail(null, "删除任务异常");
		}
	}

	@RequestMapping("/update")
	@ResponseBody
	public ResponseData updateJob(String jobName,
								  String jobGroup,
								  String cronexpression,
								  String description,
								  HttpServletRequest request,
								  HttpServletResponse response) {
		LOGGER.info("[updateJob] start, jobName: {}, jobGroup: {}, cronexpression: {}, description: {}",
				jobName, jobGroup, cronexpression, description);
		ScheduleJobResponse res = null;
		try {
			ScheduleJobUpdateRequest req = new ScheduleJobUpdateRequest();
			req.setJobName(jobName);
			req.setJobGroup(jobGroup);
			req.setCronexpression(cronexpression);
			req.setDescription(description);
			res = jobThriftClient.updateJob(req);
			LOGGER.info("[updateJob] end, jobName: {}, jobGroup: {}, cronexpression: {}, description: {}, res: {}",
					jobName, jobGroup, cronexpression, description, res);
			if (res.getCode() == JobResCode.SUCCESS.getValue()) {
				return ResponseData.success(null);
			} else {
				return ResponseData.fail(null, "更新任务失败");
			}
		} catch (Exception e) {
			LOGGER.error("[updateJob] error, jobName: {}, jobGroup: {}, res: {}, emsg: {}, e: {}",
					jobName, jobGroup, res, e.getMessage(), e);
			return ResponseData.fail(null, "更新任务异常");
		}
	}

	@RequestMapping("/pause")
	@ResponseBody
	public ResponseData pauseJob(String jobName,
								 String jobGroup,
								 HttpServletRequest request,
								 HttpServletResponse response) {
		LOGGER.info("[pauseJob] start, jobName: {}, jobGroup: {}", jobName, jobGroup);
		ScheduleJobResponse res = null;
		try {
			ScheduleJobOperRequest req = new ScheduleJobOperRequest();
			req.setOper(JobOperateType.PAUSE.getValue());
			req.setJobName(jobName);
			req.setJobGroup(jobGroup);
			res = jobThriftClient.operJob(req);
			LOGGER.info("[pauseJob] end, jobName: {},jobGroup: {},res:{}", jobName, jobGroup, res);
			if (res.getCode() == JobResCode.SUCCESS.getValue()) {
				return ResponseData.success(null);
			} else {
				return ResponseData.fail(null, "暂停任务失败");
			}
		} catch (Exception e) {
			LOGGER.error("[pauseJob] error,jobName:{},jobGroup:{},res:{},emsg:{},e:{}", jobName, jobGroup, res, e.getMessage(), e);
			return ResponseData.fail(null, "暂停任务异常");
		}
	}

	@RequestMapping("/resume")
	@ResponseBody
	public ResponseData resumeJob(String jobName,
								  String jobGroup,
								  HttpServletRequest request,
								  HttpServletResponse response) {
		LOGGER.info("[resumeJob] start, jobName: {}, jobGroup: {}", jobName, jobGroup);
		ScheduleJobResponse res = null;
		try {
			ScheduleJobOperRequest req = new ScheduleJobOperRequest();
			req.setOper(JobOperateType.RESUME.getValue());
			req.setJobName(jobName);
			req.setJobGroup(jobGroup);
			res = jobThriftClient.operJob(req);
			LOGGER.info("[resumeJob] end, jobName: {}, jobGroup: {},res:{}", jobName, jobGroup, res);
			if (res.getCode() == JobResCode.SUCCESS.getValue()) {
				return ResponseData.success(null);
			} else {
				return ResponseData.fail(null, "恢复任务失败");
			}
		} catch (Exception e) {
			LOGGER.error("[resumeJob] error, jobName: {}, jobGroup: {},res:{}, emsg: {}, e: {}", jobName, jobGroup, res, e.getMessage(), e);
			return ResponseData.fail(null, "恢复任务异常");
		}
	}

	@RequestMapping("/query")
	@ResponseBody
	public String queryJobs(String gridPager, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("[queryJobs] pager: {}", gridPager);
		Pager pager = GsonUtils.fromJson(gridPager, Pager.class);
		pager = scheduleJobService.query(pager);
		return GsonUtils.toJson(pager);
	}

	@RequestMapping("/time")
	@ResponseBody
	public ServiceResult queryJobTime(String name, String group, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("[queryJobTime] name: {}, group: {}", name, group);
		return ServiceResult.success(scheduleJobService.queryJobTime(name, group));
	}

}
