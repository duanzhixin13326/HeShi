package com.ayd.heshi.framwork.bean;

/**
 * 灵感的专辑类
 * @author Administrator
 *
 */
public class StrategySpecialBean {
	private String imageAvator;
	private String specialTitle;
	private String specialContent;
	
	public StrategySpecialBean() {
		super();
	}
	public StrategySpecialBean(String imageAvator, String specialTitle,
			String specialContent) {
		super();
		this.imageAvator = imageAvator;
		this.specialTitle = specialTitle;
		this.specialContent = specialContent;
	}
	public String getImageAvator() {
		return imageAvator;
	}
	public void setImageAvator(String imageAvator) {
		this.imageAvator = imageAvator;
	}
	public String getSpecialTitle() {
		return specialTitle;
	}
	public void setSpecialTitle(String specialTitle) {
		this.specialTitle = specialTitle;
	}
	public String getSpecialContent() {
		return specialContent;
	}
	public void setSpecialContent(String specialContent) {
		this.specialContent = specialContent;
	}
	@Override
	public String toString() {
		return "StrategySpecialBean [imageAvator=" + imageAvator
				+ ", specialTitle=" + specialTitle + ", specialContent="
				+ specialContent + "]";
	}
	
}
