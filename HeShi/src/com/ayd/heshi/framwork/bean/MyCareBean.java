package com.ayd.heshi.framwork.bean;

/**
 * �ҵĹ�ע��
 * @author Administrator
 *
 */
public class MyCareBean {
	private String nickName;// �û����ǳ�
	private String title;// ̧ͷ
	private String content;// ��������
	
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
