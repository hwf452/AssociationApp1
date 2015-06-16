package com.halong.associationapp.tab2;

import java.io.Serializable;

public class SortModel implements Serializable{

	private String name;   
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortLetters() {
		return sortLetters;
	}

	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}

	public String getUser_company() {
		return user_company;
	}

	public void setUser_company(String user_company) {
		this.user_company = user_company;
	}

	public String getUser_city() {
		return user_city;
	}

	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_weibo() {
		return user_weibo;
	}

	public void setUser_weibo(String user_weibo) {
		this.user_weibo = user_weibo;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_post() {
		return user_post;
	}

	public void setUser_post(String user_post) {
		this.user_post = user_post;
	}

	private String sortLetters;
	private String user_company;
	private String user_city;
	private String user_phone;
	private String user_email;
	private String user_weibo;
	private String user_address;
	
	private String user_post;
	@Override
	public String toString() {
		return name+" "+user_post+user_company+user_city+user_address;
	}
	
}
