package com.ayd.heshi.framwork.bean;

/**
 * 设计师类
 * @author Administrator
 *
 */
public class DesiginerBean {
	private String iamgeAvator;// 图片
	private String nickName;// 设计师的昵称
	private String introduce;// 设计师的介绍
	private String content;// 设计师介绍主体
	private String total;// 获赞的汇总

	public DesiginerBean() {
		super();
	}

	public DesiginerBean(String iamgeAvator, String nickName, String introduce,
			String content, String total) {
		super();
		this.iamgeAvator = iamgeAvator;
		this.nickName = nickName;
		this.introduce = introduce;
		this.content = content;
		this.total = total;
	}

	public String getIamgeAvator() {
		return iamgeAvator;
	}

	public void setIamgeAvator(String iamgeAvator) {
		this.iamgeAvator = iamgeAvator;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DesiginerBean [iamgeAvator=" + iamgeAvator + ", nickName="
				+ nickName + ", introduce=" + introduce + ", content="
				+ content + ", total=" + total + "]";
	}

}
