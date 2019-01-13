package io.btok.modules.app.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户

 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private Long userId;
	//用户名
	private String username;
	//登录与安全邮箱
	private String email;
	//手机号
	private String mobile;
	//密码
	transient private String password;
	//姓名
	private String name;
	//支付密码
	private String payPwd;
	//联系电话
	private String telPhone;
	//联系地址
	private String address;
	//用户编号
	private String userNo;
	//性别 1女 2男
	private Integer sex;
	//身份证ID
	private String userCard;
	//用户头像
	private String userImg;
	//是否有效   1禁用，2可用
	private Integer isUnable;
	//是否实名认证  1未认证  2认证中 3已认证
	private Integer isNameAuth;
	//是否邮件认证  1未认证  2认证中 3已认证
	private Integer isEmailAuth;
	//是否google认证  1未认证  2认证中 3已认证
	private Integer isGoogleAuth;
	//是否手机认证  1未认证  2认证中 3已认证
	private Integer isPhoneAuth;
	//出生年月日
	private Date birthday;
	//最近登录时间
	private Date lastLoginTime;
	//用户类型  1会员，2商户
	private Integer userType;
	//备注与说明
	private String remark;
	//总积分
	private Integer points;
	//总汇款金额
	private Long amount;
	//总交易单量
	private Integer totalOrder;
	//总交易金额
	private Long totalMoney;
	//推荐人推荐码
	private String fromId;
	//国籍ID
	private Integer cid;
	//会员VIP等级ID
	private Integer levelId;
	//我的二维码
	private String mycode;
	//google密钥
	private String googleKey;
	//google验证码
	private String googleCode;
	//是否充币  0没充币，1已充币
	private Integer isCoin;
	//是否提币  0没提币，1已提币
	private Integer isGetcoin;
	//是否汇款  0没汇款，1已汇款
	private Integer isRecharge;
	//经度
	private Double longitude;
	//维度
	private Double latitude;
	//身份证正面
	private String cardPros;
	//身份证反面
	private String cardCons;
	//手持身份证照片
	private String handCard;
	//诚信积分
	private Integer creditPoint;
	//客户端名称
	private String clientName;
	//注册客户端类型  1网站，2 ios ,3 android 4 微信  
	private Integer clientType;
	//推荐码
	private String recommend;
	//创建时间
	private Date createTime;

	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPayPwd() {
		return payPwd;
	}
	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getUserCard() {
		return userCard;
	}
	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public Integer getIsUnable() {
		return isUnable;
	}
	public void setIsUnable(Integer isUnable) {
		this.isUnable = isUnable;
	}
	public Integer getIsNameAuth() {
		return isNameAuth;
	}
	public void setIsNameAuth(Integer isNameAuth) {
		this.isNameAuth = isNameAuth;
	}
	public Integer getIsEmailAuth() {
		return isEmailAuth;
	}
	public void setIsEmailAuth(Integer isEmailAuth) {
		this.isEmailAuth = isEmailAuth;
	}
	public Integer getIsGoogleAuth() {
		return isGoogleAuth;
	}
	public void setIsGoogleAuth(Integer isGoogleAuth) {
		this.isGoogleAuth = isGoogleAuth;
	}
	public Integer getIsPhoneAuth() {
		return isPhoneAuth;
	}
	public void setIsPhoneAuth(Integer isPhoneAuth) {
		this.isPhoneAuth = isPhoneAuth;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Integer getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(Integer totalOrder) {
		this.totalOrder = totalOrder;
	}
	public Long getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Long totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getLevelId() {
		return levelId;
	}
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
	public String getMycode() {
		return mycode;
	}
	public void setMycode(String mycode) {
		this.mycode = mycode;
	}
	public String getGoogleKey() {
		return googleKey;
	}
	public void setGoogleKey(String googleKey) {
		this.googleKey = googleKey;
	}
	public String getGoogleCode() {
		return googleCode;
	}
	public void setGoogleCode(String googleCode) {
		this.googleCode = googleCode;
	}
	public Integer getIsCoin() {
		return isCoin;
	}
	public void setIsCoin(Integer isCoin) {
		this.isCoin = isCoin;
	}
	public Integer getIsGetcoin() {
		return isGetcoin;
	}
	public void setIsGetcoin(Integer isGetcoin) {
		this.isGetcoin = isGetcoin;
	}
	public Integer getIsRecharge() {
		return isRecharge;
	}
	public void setIsRecharge(Integer isRecharge) {
		this.isRecharge = isRecharge;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getCardPros() {
		return cardPros;
	}
	public void setCardPros(String cardPros) {
		this.cardPros = cardPros;
	}
	public String getCardCons() {
		return cardCons;
	}
	public void setCardCons(String cardCons) {
		this.cardCons = cardCons;
	}
	public String getHandCard() {
		return handCard;
	}
	public void setHandCard(String handCard) {
		this.handCard = handCard;
	}
	public Integer getCreditPoint() {
		return creditPoint;
	}
	public void setCreditPoint(Integer creditPoint) {
		this.creditPoint = creditPoint;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Integer getClientType() {
		return clientType;
	}
	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	
	
	
}
