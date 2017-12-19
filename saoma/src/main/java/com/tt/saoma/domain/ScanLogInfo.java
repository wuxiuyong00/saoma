package com.tt.saoma.domain;

import java.util.List;

public class ScanLogInfo {
	
	public String id;
	public String userId;
	public String deviceId;
	public String deviceGroupId;
	public String time;
	public String descrip;//设备描述
	public String message;//留言
	public String unusual;//异常标志0正常1异常
	public ScanUserInfo user;
	public List<String> num;//设备序列组数
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceGroupId() {
		return deviceGroupId;
	}
	public void setDeviceGroupId(String deviceGroupId) {
		this.deviceGroupId = deviceGroupId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUnusual() {
		return unusual;
	}
	public void setUnusual(String unusual) {
		this.unusual = unusual;
	}
	public ScanUserInfo getUser() {
		return user;
	}
	public void setUser(ScanUserInfo user) {
		this.user = user;
	}
	public List<String> getNum() {
		return num;
	}
	public void setNum(List<String> num) {
		this.num = num;
	}
	
	
}
