package com.tt.saoma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.saoma.dao.ILogDao;
import com.tt.saoma.domain.ScanLogInfo;
import com.tt.saoma.service.ILogService;

@Service("logService")
public class LogServiceImpl implements ILogService{
	
	@Resource  
    private ILogDao logDao; 

	@Override
	public ScanLogInfo getLogByDeviceId(String deviceId) {
		return logDao.getLogByDeviceId(deviceId);
	}

	@Override
	public int getTenLogCountByDUId(String deviceId, String userId) {
		return logDao.getTenLogCountByDUId(deviceId, userId);
	}

	@Override
	public int updateLastLogByUDId(String deviceId, String userId, String message, String unusual) {
		return logDao.updateLastLogByUDId(deviceId, userId, message, unusual);
	}

	@Override
	public List<ScanLogInfo> getLogByUserId(String userId) {
		return logDao.getLogByUserId(userId);
	}

	@Override
	public int saveLog(String deviceId, String userId, String deviceGroupId, String descrip) {
		return logDao.saveLog(deviceId, userId, deviceGroupId, descrip);
	}

}
