package com.ayd.heshi.framwork.bean;

/**
 * �����
 * @author Administrator
 *
 */
public class InspirationBean {
	private String imageAvator;// ͼƬ��ַ
	private String messageTotal;// ��Ϣ����
	private String myCareTotal;// ��ע������
	private String message;// ��Ϣ
	private String tab;// ��ǩ
	
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
