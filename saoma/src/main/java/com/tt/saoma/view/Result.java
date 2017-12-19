package com.tt.saoma.view;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {
	private String status;
	private String ErrMsg;
	private String ErrCode;
	private Object Data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrMsg() {
		return ErrMsg;
	}
	public void setErrMsg(String errMsg) {
		ErrMsg = errMsg;
	}
	public String getErrCode() {
		return ErrCode;
	}
	public void setErrCode(String errCode) {
		ErrCode = errCode;
	}
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}
	
}
