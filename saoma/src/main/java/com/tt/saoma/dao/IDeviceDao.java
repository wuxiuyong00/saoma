package com.tt.saoma.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tt.saoma.domain.ScanDeviceInfo;
import com.tt.saoma.domain.ScanDevicePartInfo;

public interface IDeviceDao {
	
	//根据设备id获取设备信息
	ScanDeviceInfo getDeviceById(@Param("deviceId") String deviceId);
	
	//获取设备组件序号
	List<String> getDevicePartNum(@Param("deviceId") String deviceId);
	
	//根据设备id和组件编号查询备注
	ScanDevicePartInfo getDevicePartDescrip(@Param("deviceId") String deviceId,@Param("num") String num);

}
