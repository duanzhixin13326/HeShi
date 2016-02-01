package com.ayd.heshi.framwork.bean;

/**
 * 用户类
 * 
 * @author Administrator
 * 
 */
public class UserInfo {
	private String userId;// 账户的id
	private String userName;// 账户的用户名
	private String userPsw;// 账户的密码
	private String avatar;// 头像地址
	private String nickName;// 昵称
	private String sex;// 性别
	private String email;// 邮箱
	private String qq;// QQ
	private String weixin;// 微信
	private String weibo;// 微博

	public UserInfo() {
		super();
	}

	public UserInfo(String userId, String userName, String userPsw,
			String avatar, String nickName, String sex, String email,
			String qq, String weixin, String weibo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPsw = userPsw;
		this.avatar = avatar;
		this.nickName = nickName;
		this.sex = sex;
		this.email = email;
		this.qq = qq;
		this.weixin = weixin;
		this.weibo = weibo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPsw() {
		return userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName
				+ ", userPsw=" + userPsw + ", avatar=" + avatar + ", nickName="
				+ nickName + ", sex=" + sex + ", email=" + email + ", qq=" + qq
				+ ", weixin=" + weixin + ", weibo=" + weibo + "]";
	}

}
