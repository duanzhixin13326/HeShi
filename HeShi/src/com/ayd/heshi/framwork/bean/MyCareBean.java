package com.ayd.heshi.framwork.bean;

/**
 * 我的关注类
 * @author Administrator
 *
 */
public class MyCareBean {
	private String nickName;// 用户名昵称
	private String title;// 抬头
	private String content;// 主体内容
	
	public MyCareBean() {
		super();
	}
	public MyCareBean(String nickName, String title, String content) {
		super();
		this.nickName = nickName;
		this.title = title;
		this.content = content;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MyCareBean [nickName=" + nickName + ", title=" + title
				+ ", content=" + content + "]";
	}
	
	
}
