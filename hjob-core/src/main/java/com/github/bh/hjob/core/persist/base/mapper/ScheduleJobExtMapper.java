package com.github.bh.hjob.core.persist.base.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Shildon on 2018/1/11.
 */
public interface ScheduleJobExtMapper {

	@Select("SELECT job_group FROM schedule_job GROUP BY job_group")
	List<String> queryGroups();

}
