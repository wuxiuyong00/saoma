package com.tt.saoma.domain;

import java.sql.Date;

public class ScanUserInfo {
	private String userId;
	private String company;
	private String userName;
	private String secret;
	private Date creatTime;
	private String creater;
	private Date UpdateTime;
	private String updater;
	private String isValid;
	private String name;
	private String phone;
	private String fristLogin;//0:不是第一次登录、1:是第一次登录
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getFristLogin() {
		return fristLogin;
	}
	public void setFristLogin(String fristLogin) {
		this.fristLogin = fristLogin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
