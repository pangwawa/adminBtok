package io.btok.modules.job.dao;

import io.btok.modules.job.entity.ScheduleJobLogEntity;
import io.btok.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志

 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
