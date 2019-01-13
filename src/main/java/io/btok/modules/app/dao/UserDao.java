package io.btok.modules.app.dao;

import io.btok.modules.app.entity.UserEntity;
import io.btok.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户

 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity queryByMobile(String mobile);
}
