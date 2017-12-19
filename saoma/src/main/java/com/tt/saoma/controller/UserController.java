package com.tt.saoma.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.saoma.constant.ConstantValue;
import com.tt.saoma.domain.ScanUserInfo;
import com.tt.saoma.service.IUserService;
import com.tt.saoma.view.JosnStringUtil;
import com.tt.saoma.view.Result;
import com.tt.saoma.view.ResultConstants;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	IUserService userService;
	
	Result result = new Result();
	
	JosnStringUtil josnStringUtil = new JosnStringUtil();

	/**
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * 
	 * @Title: toIndex   
	 * @Description: 根据id获取用户   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: Result      
	 * @throws
	 */
	@RequestMapping(value="/showUserById",method=RequestMethod.POST)
	@ResponseBody
	public Result toIndex(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String userId = request.getParameter("id");
		ScanUserInfo user = this.userService.getUserById(userId);
		if(user != null) {
			result.setErrCode("20001");
			result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
			result.setErrMsg("查询成功！");
			result.setData(user);
		}else {
			result.setErrCode("40001");
			result.setStatus(ResultConstants.RESULT_CODE_FAILED);
			result.setErrMsg("用户不存在！");
			result.setData(null);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @Title: getUserByName   
	 * @Description: 根据用户名获取用户 
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: Result      
	 * @throws
	 */
	@RequestMapping(value="/checkUserLogin",method=RequestMethod.POST)
	@ResponseBody
	public Result getUserByName(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ScanUserInfo user = userService.getUserByName(username);
		
		if(user != null) {
			if(user.getSecret().equals(password)) {
				if(user.getSecret().equals(ConstantValue.DEFALUT_PASSWORD)) {
					user.setFristLogin("1");
				}else {
					user.setFristLogin("0");
				}
				result.setErrCode("20001");
				result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
				result.setErrMsg("用户名密码验证通过！");
				result.setData(user);
			}else {
				result.setErrCode("20001");
				result.setStatus(ResultConstants.RESULT_CODE_FAILED);
				result.setErrMsg("用户密码错误！");
				result.setData(null);
			}
		}else {
			result.setErrCode("40001");
			result.setStatus(ResultConstants.RESULT_CODE_FAILED);
			result.setErrMsg("用户不存在！");
			result.setData(null);
		}
		return result;
	}
	
	/**
	 * 
	 * @Title: updateUserPwd   
	 * @Description: 更新用户密码   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: Result      
	 * @throws
	 */
	@RequestMapping(value="/updateUserPwd",method=RequestMethod.POST)
	@ResponseBody
	public Result updateUserPwd(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int i = userService.updateUserPwd(username, password);
		
		if(i > 0) {
			result.setErrCode("20001");
			result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
			result.setErrMsg("更新成功！");
			result.setData(null);
		}else {
			result.setErrCode("50001");
			result.setStatus(ResultConstants.RESULT_CODE_FAILED);
			result.setErrMsg("更新失败！");
			result.setData(null);
		}
		return result;
	}

}
