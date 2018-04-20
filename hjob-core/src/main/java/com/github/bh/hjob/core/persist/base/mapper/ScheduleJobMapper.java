package com.github.bh.hjob.core.persist.base.mapper;

import com.github.bh.hjob.core.persist.base.model.ScheduleJob;
import com.github.bh.hjob.core.persist.base.model.ScheduleJobExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScheduleJobMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    int countByExample(ScheduleJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    int deleteByExample(ScheduleJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long jobId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    int insert(ScheduleJob record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    int insertSelective(ScheduleJob record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    List<ScheduleJob> selectByExample(ScheduleJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    ScheduleJob selectByPrimaryKey(Long jobId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ScheduleJob record, @Param("example") ScheduleJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ScheduleJob record, @Param("example") ScheduleJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ScheduleJob record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ScheduleJob record);
}