package com.tt.saoma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.saoma.dao.IDeviceDao;
import com.tt.saoma.domain.ScanDeviceInfo;
import com.tt.saoma.domain.ScanDevicePartInfo;
import com.tt.saoma.service.IDeviceService;

@Service("deviceService")
public class DeviceServiceImpl implements IDeviceService{
	
	@Resource
	IDeviceDao deviceDao;

	@Override
	public ScanDeviceInfo getDeviceById(String deviceId) {
		return deviceDao.getDeviceById(deviceId);
	}

	@Override
	public List<String> getDevicePartNum(String deviceId) {
		return deviceDao.getDevicePartNum(deviceId);
	}

	@Override
	public ScanDevicePartInfo getDevicePartDescrip(String deviceId, String num) {
		return deviceDao.getDevicePartDescrip(deviceId, num);
	}

}
