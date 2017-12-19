package com.tt.saoma.service;

import java.util.List;

import com.tt.saoma.domain.ScanDeviceInfo;
import com.tt.saoma.domain.ScanDevicePartInfo;

public interface IDeviceService {
	
	//根据设备id获取设备信息
	ScanDeviceInfo getDeviceById(String deviceId);

	//获取设备组件序号
	List<String> getDevicePartNum(String deviceId);
	
	//根据设备id和组件编号查询备注
	ScanDevicePartInfo getDevicePartDescrip(String deviceId,String num);
}
