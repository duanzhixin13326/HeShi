package com.ayd.heshi.framwork.bean;

/**
 * ���Ե����»ش���
 * @author Administrator
 *
 */
public class StrategyNewAnswerBean {
	private String imageAvator;// ͼƬ�ĵ�ַ
	private String praiseTotal;// ���޵�����
	private String strategyTitle;// ���Ե�̧ͷ
	private String strategyContent;// ���Ե�����
	
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
