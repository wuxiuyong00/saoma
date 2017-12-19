package com.tt.saoma.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tt.saoma.domain.ScanLogInfo;

public interface ILogDao {
	
	//根据设备id查找最后一条日志
	ScanLogInfo getLogByDeviceId(@Param("deviceId") String deviceId);
	
	//根据用户id和设备id查找最近10分钟扫码条数
	int getTenLogCountByDUId(@Param("deviceId") String deviceId,@Param("userId") String userId);
	
	//更新用户查看设备的最后一条日志
	int updateLastLogByUDId(@Param("deviceId") String deviceId,@Param("userId") String userId,@Param("message") String message,@Param("unusual") String unusual);
	
	//根据用户id查找日志
	List<ScanLogInfo> getLogByUserId(@Param("userId") String userId);
	
	//存日志
	int saveLog(@Param("deviceId") String deviceId,@Param("userId") String userId,@Param("deviceGroupId") String deviceGroupId,@Param("descrip") String descrip);

}
