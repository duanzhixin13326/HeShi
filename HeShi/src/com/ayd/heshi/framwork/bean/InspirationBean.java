package com.ayd.heshi.framwork.bean;

/**
 * 灵感类
 * @author Administrator
 *
 */
public class InspirationBean {
	private String imageAvator;// 图片地址
	private String messageTotal;// 消息总数
	private String myCareTotal;// 关注的总数
	private String message;// 消息
	private String tab;// 标签
	
	public InspirationBean() {
		super();
	}
	public InspirationBean(String imageAvator, String messageTotal,
			String myCareTotal, String message, String tab) {
		super();
		this.imageAvator = imageAvator;
		this.messageTotal = messageTotal;
		this.myCareTotal = myCareTotal;
		this.message = message;
		this.tab = tab;
	}
	public String getImageAvator() {
		return imageAvator;
	}
	public void setImageAvator(String imageAvator) {
		this.imageAvator = imageAvator;
	}
	public String getMessageTotal() {
		return messageTotal;
	}
	public void setMessageTotal(String messageTotal) {
		this.messageTotal = messageTotal;
	}
	public String getMyCareTotal() {
		return myCareTotal;
	}
	public void setMyCareTotal(String myCareTotal) {
		this.myCareTotal = myCareTotal;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	@Override
	public String toString() {
		return "InspirationBean [imageAvator=" + imageAvator
				+ ", messageTotal=" + messageTotal + ", myCareTotal="
				+ myCareTotal + ", message=" + message + ", tab=" + tab + "]";
	}
	
}
