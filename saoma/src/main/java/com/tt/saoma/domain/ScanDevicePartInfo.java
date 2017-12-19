package com.tt.saoma.domain;

import java.util.Date;

public class ScanDevicePartInfo {
	
	private String devicePartId;
	private String devicePartName;
	private String staticDescrip;
	private String num;
	private Date createTime;
	private String creater;
	private Date updateTime;
	private String updater;
	private String isvalid;
	public String getDevicePartId() {
		return devicePartId;
	}
	public void setDevicePartId(String devicePartId) {
		this.devicePartId = devicePartId;
	}
	public String getDevicePartName() {
		return devicePartName;
	}
	public void setDevicePartName(String devicePartName) {
		this.devicePartName = devicePartName;
	}
	public String getStaticDescrip() {
		return staticDescrip;
	}
	public void setStaticDescrip(String staticDescrip) {
		this.staticDescrip = staticDescrip;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}
	
}
