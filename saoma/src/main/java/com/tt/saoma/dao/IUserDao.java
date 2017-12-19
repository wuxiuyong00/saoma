package com.tt.saoma.dao;

import org.apache.ibatis.annotations.Param;

import com.tt.saoma.domain.ScanUserInfo;

public interface IUserDao {
	
	//根据id查询用户
	ScanUserInfo getUserById(@Param("id") String id);

	//根据用户名查询用户
	ScanUserInfo getUserByName(@Param("username") String username);
	
	//更新用户密码
	int updateUserPwd(@Param("username") String username,@Param("password") String password);
}
