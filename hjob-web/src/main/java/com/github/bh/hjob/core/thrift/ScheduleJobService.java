package com.github.bh.hjob.core.thrift;

import com.github.bh.hjob.core.dtgrid.Pager;
import com.github.bh.hjob.core.model.JobTimeVo;
import com.github.bh.hjob.core.model.ScheduleJobQueryRequest;
import com.github.bh.hjob.core.model.ScheduleJobVo;
import com.github.bh.hjob.core.model.ScheduleJobWrapper;
import com.github.bh.hjob.utils.BeanUtils;
import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.google.common.collect.Lists;
import com.github.bh.hjob.core.persist.base.mapper.ScheduleJobExtMapper;
import com.github.bh.hjob.core.persist.base.model.ScheduleJob;
import com.github.bh.hjob.core.repository.ScheduleJobRepository;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author xiaobenhai
 */
@Service
public class ScheduleJobService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleJobService.class);

	@Autowired
	private ScheduleJobRepository scheduleJobRepository;

	@Autowired
	private ScheduleJobExtMapper scheduleJobExtMapper;

	@Autowired
	private JobThriftIface jobThriftClient;

	public List<String> queryGroups() {
		return scheduleJobExtMapper.queryGroups();
	}

	public Pager query(Pager pager) {
		String name = Pager.convertParmToStr(pager, "jobName");
		String group = Pager.convertParmToStr(pager, "jobGroup");
		try {
			List<ScheduleJob> scheduleJobs = scheduleJobRepository.getByNameAndGroup(name, group);
			List<ScheduleJobVo> vos = toVos(scheduleJobs);
			pager.setIsSuccess(true);
			pager.setPageCount(1);
			pager.setRecordCount(vos.size());
			pager.setExhibitDatas(BeanUtils.batchConvertBean(vos));
		} catch (Exception e) {
			pager.setIsSuccess(false);
			LOGGER.error("[query] error, pager: {}", pager, e);
		}
		return pager;
	}

	public JobTimeVo queryJobTime(String name, String group) {
		JobTimeVo jobTimeVo = new JobTimeVo();
		try {
			List<ScheduleJobWrapper> wrappers = retryQueryFromThrift(name, group);
			if (CollectionUtils.isEmpty(wrappers)) {
				return jobTimeVo;
			}
			ScheduleJobWrapper wrapper = wrappers.get(0);
			jobTimeVo.setNextTime(new DateTime(wrapper.getNextTime()).toString("yyyy-MM-dd HH:mm:ss"));
			jobTimeVo.setPreviousTime(new DateTime(wrapper.getPreviousTime()).toString("yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			LOGGER.error("[queryJobTime] error, name: {}, group: {}", name, group, e);
		}
		return jobTimeVo;
	}

	private List<ScheduleJobWrapper> retryQueryFromThrift(final String name, final String group)
			throws ExecutionException, RetryException {
		Retryer<List<ScheduleJobWrapper>> retryer = RetryerBuilder.<List<ScheduleJobWrapper>>newBuilder()
				.withStopStrategy(StopStrategies.stopAfterAttempt(5))
				.retryIfException()
				.build();
		return retryer.call(new Callable<List<ScheduleJobWrapper>>() {
			@Override
			public List<ScheduleJobWrapper> call() throws Exception {
				ScheduleJobQueryRequest req = new ScheduleJobQueryRequest();
				req.setJobName(name);
				req.setJobGroup(group);
				return jobThriftClient.queryJobs(req).getJoblist();
			}
		});
	}

	private List<ScheduleJobVo> toVos(List<ScheduleJob> scheduleJobs) throws InvocationTargetException, IllegalAccessException {
		List<ScheduleJobVo> vos = Lists.newArrayList();
		if (CollectionUtils.isEmpty(scheduleJobs)) {
			return vos;
		}
		for (ScheduleJob scheduleJob : scheduleJobs) {
			ScheduleJobVo vo = new ScheduleJobVo();
			vo.setJobId(scheduleJob.getJobId());
			vo.setJobName(scheduleJob.getJobName());
			vo.setJobGroup(scheduleJob.getJobGroup());
			vo.setJobDetailStatus(scheduleJob.getJobDetailStatus());
			vo.setJobStatus(scheduleJob.getJobStatus());
			vo.setCronexpression(scheduleJob.getCronexpression());
			vo.setDescription(scheduleJob.getDescription());
			vo.setMqKey(scheduleJob.getJobNotifyKey());

			vos.add(vo);
		}
		return vos;
	}

}
