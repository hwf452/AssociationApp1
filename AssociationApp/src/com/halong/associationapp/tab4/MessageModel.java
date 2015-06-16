package com.halong.associationapp.tab4;

import java.io.Serializable;

public class MessageModel implements Serializable{
	private String mTitle;
	private String mContent;
	private int drawableId;
	

	public int getDrawableId() {
		return drawableId;
	}

	public void setDrawableId(int drawableId) {
		this.drawableId = drawableId;
	}

	private String time;
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	
	public String getmTitle() {
		return mTitle;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public String getmContent() {
		return mContent;
	}

}
