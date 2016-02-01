package com.ayd.heshi.framwork.bean;

/**
 * 攻略的最新回答类
 * @author Administrator
 *
 */
public class StrategyNewAnswerBean {
	private String imageAvator;// 图片的地址
	private String praiseTotal;// 点赞的总数
	private String strategyTitle;// 攻略的抬头
	private String strategyContent;// 攻略的内容
	
	public StrategyNewAnswerBean() {
		super();
	}
	public StrategyNewAnswerBean(String imageAvator, String praiseTotal,
			String strategyTitle, String strategyContent) {
		super();
		this.imageAvator = imageAvator;
		this.praiseTotal = praiseTotal;
		this.strategyTitle = strategyTitle;
		this.strategyContent = strategyContent;
	}
	public String getImageAvator() {
		return imageAvator;
	}
	public void setImageAvator(String imageAvator) {
		this.imageAvator = imageAvator;
	}
	public String getPraiseTotal() {
		return praiseTotal;
	}
	public void setPraiseTotal(String praiseTotal) {
		this.praiseTotal = praiseTotal;
	}
	public String getStrategyTitle() {
		return strategyTitle;
	}
	public void setStrategyTitle(String strategyTitle) {
		this.strategyTitle = strategyTitle;
	}
	public String getStrategyContent() {
		return strategyContent;
	}
	public void setStrategyContent(String strategyContent) {
		this.strategyContent = strategyContent;
	}
	@Override
	public String toString() {
		return "StrategyBean [imageAvator=" + imageAvator + ", praiseTotal="
				+ praiseTotal + ", strategyTitle=" + strategyTitle
				+ ", strategyContent=" + strategyContent + "]";
	}
}
