package com.tt.saoma.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tt.saoma.dao.IUserDao;
import com.tt.saoma.domain.ScanUserInfo;
import com.tt.saoma.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Resource  
    private IUserDao userDao;  

	@Override
	public ScanUserInfo getUserById(String userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public ScanUserInfo getUserByName(String username) {
		return userDao.getUserByName(username);
	}

	@Override
	public int updateUserPwd(String username, String password) {
		return userDao.updateUserPwd(username, password);
	}

}
