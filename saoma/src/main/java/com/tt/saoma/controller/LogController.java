package com.tt.saoma.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.saoma.domain.ScanDeviceInfo;
import com.tt.saoma.domain.ScanLogInfo;
import com.tt.saoma.domain.ScanUserInfo;
import com.tt.saoma.service.IDeviceService;
import com.tt.saoma.service.ILogService;
import com.tt.saoma.service.IUserService;
import com.tt.saoma.view.JosnStringUtil;
import com.tt.saoma.view.Result;
import com.tt.saoma.view.ResultConstants;

@Controller
@RequestMapping("/log")
public class LogController {
	
	@Resource
	ILogService logService;
	
	@Resource
	IDeviceService deviceService;
	
	@Resource
	IUserService userService;
	
	Result result = new Result();
	
	JosnStringUtil josnStringUtil = new JosnStringUtil();
	
	/**
	 * 
	 * @Title: getLogByDeviceId   
	 * @Description: TODO(根据设备id获取最后一次的开启记录)   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: Result      
	 * @throws
	 */
	@RequestMapping(value="/getLogByDeviceId",method=RequestMethod.POST)
	@ResponseBody
	public Result getLogByDeviceId(HttpServletRequest request,HttpServletResponse response) {
		String deviceId = request.getParameter("deviceId");
		String userId = request.getParameter("userId");
		ScanLogInfo log = logService.getLogByDeviceId(deviceId);
		ScanLogInfo log1 = new ScanLogInfo();
		if(null == log) {
			ScanDeviceInfo device = deviceService.getDeviceById(deviceId);
			if(null == device) {
				result.setErrCode("40001");//查询不到设备
				result.setStatus(ResultConstants.RESULT_CODE_FAILED);
				result.setErrMsg("对不起,该设备号没有组件信息,请查证后再使用!");
				result.setData(null);
				
			}else {
				log1.setDeviceId(device.getDeviceId());
				log1.setDescrip(device.getDescrip());
				
				List<String> nums = deviceService.getDevicePartNum(device.getDeviceId());
				log1.setNum(nums);
				
				result.setErrCode("20002");//没有最后一次开启时间，查询设备信息
				result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
				result.setErrMsg("查询成功！");
				result.setData(log1);
			}
		}else {
			ScanUserInfo user = userService.getUserById(log.userId);
			log.setUser(user);
			
			List<String> nums = deviceService.getDevicePartNum(log.getDeviceId());
			log.setNum(nums);
			
			result.setErrCode("20001");//有最后一次开启时间日志
			result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
			result.setErrMsg("查询成功！");
			result.setData(log);
		}
		ScanDeviceInfo deviceInfo = deviceService.getDeviceById(deviceId);
		
		//如果查不到设备信息，不保存日志
		if(!StringUtils.isEmpty(deviceInfo)) {
			logService.saveLog(deviceId, userId, null,deviceInfo.getDescrip());
		}
		
		return result;
	}
	
	/**
	 * 
	 * @Title: getTenLogCountByDUId   
	 * @Description: TODO(根据用户id和设备id查找最近10分钟扫码条数)   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: Result      
	 * @throws
	 */
	@RequestMapping(value="/getTenLogCountByDUId",method=RequestMethod.POST)
	@ResponseBody
	public Result getTenLogCountByDUId(HttpServletRequest request,HttpServletResponse response) {
		String deviceId = request.getParameter("deviceId");
		String userId = request.getParameter("userId");
		
		int count = logService.getTenLogCountByDUId(deviceId, userId);
		
		result.setErrCode("20001");
		result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
		result.setErrMsg("查询成功！");
		result.setData(count);
		
		return result;
	}
	
	/**
	 * 
	 * @Title: updateLastLogByUDId   
	 * @Description: TODO(更新用户查看设备的最后一条日志)   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: Result      
	 * @throws
	 */
	@RequestMapping(value="/updateLastLogByUDId",method=RequestMethod.POST)
	@ResponseBody
	public Result updateLastLogByUDId(HttpServletRequest request,HttpServletResponse response) {
		String deviceId = request.getParameter("deviceId");
		String userId = request.getParameter("userId");
		String message = request.getParameter("message");
		String unusual = request.getParameter("unusual");
		
		int i = logService.updateLastLogByUDId(deviceId, userId, message, unusual);
		
		if(i>0) {
			result.setErrCode("20001");
			result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
			result.setErrMsg("更新成功！");
			result.setData(i);
		}else {
			result.setErrCode("40001");
			result.setStatus(ResultConstants.RESULT_CODE_FAILED);
			result.setErrMsg("更新失败！");
			result.setData(null);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @Title: getLogByUserId   
	 * @Description: TODO(根据用户id查找日志)   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: Result      
	 * @throws
	 */
	@RequestMapping(value="/getLogByUserId",method=RequestMethod.POST)
	@ResponseBody
	public Result getLogByUserId(HttpServletRequest request,HttpServletResponse response) {
		String userId = request.getParameter("userId");
		List<ScanLogInfo> logs = logService.getLogByUserId(userId);
		
		result.setErrCode("20001");
		result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
		result.setErrMsg("更新成功！");
		result.setData(logs);
		
		return result;
	}
	
	/**
	 * 
	 * @Title: saveLog   
	 * @Description: TODO(保存日志接口)   
	 * @param: @param request
	 * @param: @param response
	 * @param: @throws IOException      
	 * @return: void      
	 * @throws
	 */
	@RequestMapping("/saveLog")
	@ResponseBody
	public Result saveLog(HttpServletRequest request,HttpServletResponse response){
		String userId = request.getParameter("userId");
		String deviceId = request.getParameter("deviceId");
		String deviceGroupId = request.getParameter("devicePartId");
		
		System.out.println(StringUtils.isEmpty(deviceGroupId));
		
		if (StringUtils.isEmpty(userId)||StringUtils.isEmpty(deviceId)||StringUtils.isEmpty(deviceGroupId)) {
			result.setStatus(ResultConstants.RESULT_CODE_FAILED);
			result.setErrCode("40001");
			result.setErrMsg("参数不全!");
			result.setData("");
		}else {
			ScanDeviceInfo deviceInfo = deviceService.getDeviceById(deviceId);
			
			int i = logService.saveLog(deviceId, userId, deviceGroupId,null==deviceInfo?null:deviceInfo.getDescrip());
			
			if(i>0) {
				result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
				result.setErrCode("20001");
				result.setErrMsg("更新成功!");
				result.setData(i);
			}else {
				result.setStatus(ResultConstants.RESULT_CODE_FAILED);
				result.setErrCode("40001");
				result.setErrMsg("更新失败!");
				result.setData(i);
			}
			
		}
		
		return result;
	}

}
