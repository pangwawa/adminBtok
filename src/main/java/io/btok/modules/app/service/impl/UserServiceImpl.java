package io.btok.modules.app.service.impl;


import io.btok.common.exception.RRException;
import io.btok.common.validator.Assert;
import io.btok.modules.app.dao.UserDao;
import io.btok.modules.app.entity.UserEntity;
import io.btok.modules.app.service.UserService;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserEntity queryObject(Long userId){
		return userDao.queryObject(userId);
	}
	
	@Override
	public List<UserEntity> queryList(Map<String, Object> map){
		return userDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDao.queryTotal(map);
	}

	@Override
	public void save(String username, String password,String cid,String fromId,String longitude,String latitude,
			String clientName,Integer clientType,int type){
		UserEntity user = new UserEntity();
		if(type ==1){
			user.setMobile(username);
			user.setIsPhoneAuth(3);
			user.setIsEmailAuth(1); 
 		}else{
			user.setEmail(username);
			user.setIsEmailAuth(3);
			user.setIsPhoneAuth(1);
		}
		user.setUsername(username);
		user.setPassword(DigestUtils.sha256Hex(password));
		user.setCid(Integer.valueOf(cid)); 
		user.setUserType(1);
		user.setIsUnable(2);
		user.setIsNameAuth(1); 
		user.setIsGoogleAuth(1);
		user.setFromId(fromId);
		user.setLevelId(1);
		user.setIsCoin(0);
		user.setIsGetcoin(0);
		user.setIsRecharge(0);
		user.setLastLoginTime(new Date());
		user.setLongitude(Double.valueOf(longitude));
		user.setLatitude(Double.valueOf(latitude));
		user.setCreditPoint(0);
		
		StringBuffer sb = new StringBuffer();
		sb.append("0"+user.getUserType());
		sb.append("0"+cid);
		int count = userDao.queryTotal();
		DecimalFormat df = new DecimalFormat("000000");
		sb.append(df.format(count));
		user.setUserNo(sb.toString());
		
		SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		Date d = new Date();
		user.setRecommend(df2.format(d.getTime())+user.getUserNo()); 
		user.setMycode(""); 
		user.setClientName(clientName);
		user.setClientType(Integer.valueOf(clientType));
		user.setCreateTime(new Date());
		userDao.save(user);
	}
	
	
	
	@Override
	public void save(UserEntity user){
		userDao.save(user);
	}
	
	
	@Override
	public void update(UserEntity user){
		userDao.update(user);
	}
	
	@Override
	public void delete(Long userId){
		userDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		userDao.deleteBatch(userIds);
	}

	@Override
	public UserEntity queryByMobile(String mobile) {
		return userDao.queryByMobile(mobile);
	}

	@Override
	public long login(String mobile, String password) {
		UserEntity user = queryByMobile(mobile);
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(password))){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}
}
