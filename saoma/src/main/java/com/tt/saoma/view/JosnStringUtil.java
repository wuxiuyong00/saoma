package com.tt.saoma.view;


public class JosnStringUtil {
	
	public String josnString(Result result){
		
		String str = "{\"status\":\""+result.getStatus()+"\",\"errCode\":\""
		+result.getErrCode()+"\",\"errMsg\":\""+result.getErrMsg()+"\",\"data\":"+result.getData()+"}";
		System.out.println("****************************");
		System.out.println("输出返回客户Json数据：");
		System.out.println(str);
		System.out.println("****************************");
		return str;
	}
	
	public String josnStringTwo(Result result){
		String str = "{\"status\":\""+result.getStatus()+"\",\"errCode\":\""
		+result.getErrCode()+"\",\"errMsg\":\""+result.getErrMsg()+"\",\"data\":\""+result.getData()+"\"}";
		System.out.println("****************************");
		System.out.println("输出返回客户Json数据：");
		System.out.println(str);
		System.out.println("****************************");
		return str;
	}
}
