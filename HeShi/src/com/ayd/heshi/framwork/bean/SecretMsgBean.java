package com.ayd.heshi.framwork.bean;

/**
 * 我的私信类
 * @author Administrator
 *
 */
public class SecretMsgBean {
	private String imageAvator;// 图片地址
	private String nickName;// 昵称
	private String content;// 主体内容
	
	public SecretMsgBean() {
		super();
	}
	public SecretMsgBean(String imageAvator, String nickName, String content) {
		super();
		this.imageAvator = imageAvator;
		this.nickName = nickName;
		this.content = content;
	}
	public String getImageAvator() {
		return imageAvator;
	}
	public void setImageAvator(String imageAvator) {
		this.imageAvator = imageAvator;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "SecretMsgBean [imageAvator=" + imageAvator + ", nickName="
				+ nickName + ", content=" + content + "]";
	}
}
