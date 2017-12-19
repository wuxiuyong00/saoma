package com.tt.saoma.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.saoma.domain.ScanDeviceInfo;
import com.tt.saoma.domain.ScanDevicePartInfo;
import com.tt.saoma.service.IDeviceService;
import com.tt.saoma.service.ILogService;
import com.tt.saoma.view.Result;
import com.tt.saoma.view.ResultConstants;

@Controller
@RequestMapping("/device")
public class DeviceController {
	
	@Resource
	ILogService logService;
	
	@Resource
	IDeviceService deviceService;
	
	Result result = new Result();
	
	/**
	 * 
	 * @Title: getDevicePartDescrip   
	 * @Description: TODO(根据设备id和密码组查询组件描述)   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/getDevicePartDescrip",method=RequestMethod.POST)
	@ResponseBody
	public Result getDevicePartDescrip(HttpServletRequest request,HttpServletResponse response) {
		String deviceId = request.getParameter("deviceId");
		String userId = request.getParameter("userId");
		String num = request.getParameter("num");
		
		ScanDevicePartInfo DevicePart = deviceService.getDevicePartDescrip(deviceId, num);
		
		result.setErrCode("20001");//有最后一次开启时间日志
		result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
		result.setErrMsg("查询成功！");
		result.setData(null==DevicePart?"无备注":DevicePart.getStaticDescrip());
		
		ScanDeviceInfo deviceInfo = deviceService.getDeviceById(deviceId);
		
		if(StringUtils.isEmpty(DevicePart)) {
			result.setErrCode("40001");//有最后一次开启时间日志
			result.setStatus(ResultConstants.RESULT_CODE_FAILED);
			result.setErrMsg("对不起,该设备号没有组件信息,请查证后再使用!");
			result.setData(null==DevicePart?"无备注":DevicePart.getStaticDescrip());
		}else {
			//查看密码存日志
			logService.saveLog(deviceId, userId,DevicePart.getDevicePartId(),null==deviceInfo?null:deviceInfo.getDescrip());
		}
		
		return result;
	}

}
