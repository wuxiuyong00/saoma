package com.tt.saoma.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.saoma.constant.ConstantValue;
import com.tt.saoma.util.HttpRequest;
import com.tt.saoma.util.VeDate;
import com.tt.saoma.view.Result;
import com.tt.saoma.view.ResultConstants;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	Result result = new Result();
	
	/**
	 * 
	 * @Title: sendMessage   
	 * @Description: TODO(短信发送接口)   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: Result      
	 * @throws
	 */
	@RequestMapping(value = "/sendMessage",method=RequestMethod.POST)
	@ResponseBody
	public Result sendMessage(HttpServletRequest request,HttpServletResponse response) {
		String phone = request.getParameter("phone");
		String content = request.getParameter("content");
		
		String params = this.assemblParams(phone, content);
		HttpRequest httpRequest = new HttpRequest();
		
		String s = httpRequest.sendPost(ConstantValue.SMS_URL, params);
		System.out.println("======"+s);
		
		result.setErrCode("20001");
		result.setStatus(ResultConstants.RESULT_CODE_SUCCESS);
		result.setErrMsg("更新成功！");
		result.setData(s);
		
		return result;
		
	}
	
	/**
	 * 
	 * @Title: assemblParams   
	 * @Description: TODO(请求参数封装)   
	 * @param: @param phone
	 * @param: @param content
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public String assemblParams(String phone,String content) {
		String params = "";
		VeDate veDate = new VeDate();
		String sendTime = veDate.getNowDate("yyyyMMddHHmmss");
		
		params = "apName="+ConstantValue.AP_NAME+"&apPassword="+ConstantValue.AP_PASSWORD
				+"&ServiceId="+ConstantValue.SERVICE_ID+"&calledNumber="+phone
				+"&content="+content+"&sendTime="+sendTime;
		
		return params;
	}

}
