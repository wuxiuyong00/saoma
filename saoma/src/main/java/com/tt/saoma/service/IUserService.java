package com.tt.saoma.service;

import com.tt.saoma.domain.ScanUserInfo;

public interface IUserService {
	
	//根据id查询用户
    public ScanUserInfo getUserById(String userId); 
    
    //根据用户名查询用户
    public ScanUserInfo getUserByName(String username);
    
    //更新用户密码
  	int updateUserPwd(String username,String password);

}
