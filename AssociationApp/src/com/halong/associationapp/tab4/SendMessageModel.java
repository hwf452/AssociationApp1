package com.halong.associationapp.tab4;

import java.io.Serializable;

public class SendMessageModel implements Serializable{
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getHeadPicId() {
		return headPicId;
	}
	public void setHeadPicId(int headPicId) {
		this.headPicId = headPicId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private int headPicId;
	private String content;

}
