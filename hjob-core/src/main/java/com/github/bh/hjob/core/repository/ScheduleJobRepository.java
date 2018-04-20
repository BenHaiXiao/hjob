package com.github.bh.hjob.core.repository;

import com.github.bh.hjob.core.persist.base.mapper.ScheduleJobMapper;
import com.github.bh.hjob.core.persist.base.model.ScheduleJob;
import com.github.bh.hjob.core.persist.base.model.ScheduleJobExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiaobenhai
 */
@Component
public class ScheduleJobRepository {

	@Autowired
	private ScheduleJobMapper scheduleJobMapper;

	public boolean insert(ScheduleJob scheduleJob) {
		return scheduleJobMapper.insert(scheduleJob) > 0;
	}

	public boolean update(ScheduleJob job) {
		ScheduleJobExample example = new ScheduleJobExample();
		ScheduleJobExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(job.getJobName())) {
			criteria.andJobNameEqualTo(job.getJobName());
		}
		if (StringUtils.isNotBlank(job.getJobGroup())) {
			criteria.andJobGroupEqualTo(job.getJobGroup());
		}
		if (StringUtils.isNotBlank(job.getJobNotifyKey())) {
			criteria.andJobNotifyKeyEqualTo(job.getJobNotifyKey());
		}
		return scheduleJobMapper.updateByExampleSelective(job, example) > 0;
	}

	public boolean delete(String name, String group) {
		ScheduleJobExample example = new ScheduleJobExample();
		ScheduleJobExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(name)) {
			criteria.andJobNameEqualTo(name);
		}
		if (StringUtils.isNotBlank(group)) {
			criteria.andJobGroupEqualTo(group);
		}
		return scheduleJobMapper.deleteByExample(example) > 0;
	}

	public List<ScheduleJob> getByNameAndGroup(String name, String group) {
		ScheduleJobExample example = new ScheduleJobExample();
		ScheduleJobExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(name)) {
			criteria.andJobNameEqualTo(name);
		}
		if (StringUtils.isNotBlank(group)) {
			criteria.andJobGroupEqualTo(group);
		}
		return scheduleJobMapper.selectByExample(example);
	}

	public boolean operate(String name, String group, String state, Integer status) {
		ScheduleJobExample example = new ScheduleJobExample();
		ScheduleJobExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(name)) {
			criteria.andJobNameEqualTo(name);
		}
		if (StringUtils.isNotBlank(group)) {
			criteria.andJobGroupEqualTo(group);
		}

		ScheduleJob job = new ScheduleJob();
		job.setJobDetailStatus(state);
		job.setJobStatus(status);
		return scheduleJobMapper.updateByExampleSelective(job, example) > 0;
	}

}
