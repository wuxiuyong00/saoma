package com.tt.saoma.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tt.saoma.domain.ScanLogInfo;

public interface ILogService {
	
	//根据设备id查找最后一条日志
	ScanLogInfo getLogByDeviceId(String deviceId);
		
	//根据用户id和设备id查找最近10分钟扫码条数
	int getTenLogCountByDUId(String deviceId,String userId);
	
	//更新用户查看设备的最后一条日志
	int updateLastLogByUDId(String deviceId,String userId,String message,String unusual);
	
	//根据用户id查找日志
	List<ScanLogInfo> getLogByUserId(String userId);
	
	//存日志接口
	int saveLog(@Param("deviceId") String deviceId,@Param("userId") String userId,@Param("deviceGroupId") String deviceGroupId,@Param("descrip") String descrip);

}
