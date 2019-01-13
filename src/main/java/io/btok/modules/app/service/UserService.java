package io.btok.modules.app.service;


import io.btok.modules.app.entity.UserEntity;

import java.util.List;
import java.util.Map;


/**
 * 用户

 */
public interface UserService {

	UserEntity queryObject(Long userId);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(String username, String password,String cid,String fromId,String longitude,String latitude,
			String clientName,Integer clientType,int type);
	
	void update(UserEntity user);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param mobile    手机号
	 * @param password  密码
	 * @return          返回用户ID
	 */
	long login(String mobile, String password);
	
	void save(UserEntity user);
	
}
