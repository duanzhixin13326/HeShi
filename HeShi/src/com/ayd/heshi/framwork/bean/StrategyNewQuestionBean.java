package com.ayd.heshi.framwork.bean;

/**
 * ��е�����������
 * @author Administrator
 *
 */
public class StrategyNewQuestionBean {
	private String newQuestionTitle;// �������ʵ�����
	private String newQuestionNum;// �������ʵĻش�����
	private String newQuestionCares;// �������ʵĹ�ע����
	
	public StrategyNewQuestionBean() {
		super();
	}
	public StrategyNewQuestionBean(String newQuestionTitle,
			String newQuestionNum, String newQuestionCares) {
		super();
		this.newQuestionTitle = newQuestionTitle;
		this.newQuestionNum = newQuestionNum;
		this.newQuestionCares = newQuestionCares;
	}
	public String getNewQuestionTitle() {
		return newQuestionTitle;
	}
	public void setNewQuestionTitle(String newQuestionTitle) {
		this.newQuestionTitle = newQuestionTitle;
	}
	public String getNewQuestionNum() {
		return newQuestionNum;
	}
	public void setNewQuestionNum(String newQuestionNum) {
		this.newQuestionNum = newQuestionNum;
	}
	public String getNewQuestionCares() {
		return newQuestionCares;
	}
	public void setNewQuestionCares(String newQuestionCares) {
		this.newQuestionCares = newQuestionCares;
	}
	@Override
	public String toString() {
		return "StrategyNewQuestionBean [newQuestionTitle=" + newQuestionTitle
				+ ", newQuestionNum=" + newQuestionNum + ", newQuestionCares="
				+ newQuestionCares + "]";
	}
	
}
