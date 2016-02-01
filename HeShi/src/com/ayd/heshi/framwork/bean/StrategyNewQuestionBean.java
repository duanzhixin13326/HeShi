package com.ayd.heshi.framwork.bean;

/**
 * 灵感的最新提问类
 * @author Administrator
 *
 */
public class StrategyNewQuestionBean {
	private String newQuestionTitle;// 最新提问的内容
	private String newQuestionNum;// 最新提问的回答总数
	private String newQuestionCares;// 最新提问的关注总数
	
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
