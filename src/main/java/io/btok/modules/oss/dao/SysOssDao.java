package io.btok.modules.oss.dao;

import io.btok.modules.oss.entity.SysOssEntity;
import io.btok.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 *
 */
@Mapper
public interface SysOssDao extends BaseDao<SysOssEntity> {
	
}
