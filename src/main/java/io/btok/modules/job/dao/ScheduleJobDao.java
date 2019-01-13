package io.btok.modules.job.dao;

import io.btok.modules.job.entity.ScheduleJobEntity;
import io.btok.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 定时任务
 * 

 */
@Mapper
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
