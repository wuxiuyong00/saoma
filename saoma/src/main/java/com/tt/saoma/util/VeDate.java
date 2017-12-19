package com.tt.saoma.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName:  VeDate   
 * @Description:TODO(日期格式化类)   
 * @author: xywu 
 * @date:   2017年12月12日 上午9:39:39   
 *
 */
public class VeDate {
	
	/**
	   * 获取现在时间
	   * 
	   * @return 返回时间类型 yyyy-MM-dd HH:mm:ss、yyyyMMddHHmmss
	   */
	public String getNowDate(String fromatString) {
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat(fromatString);
	   String dateString = formatter.format(currentTime);
	   return dateString;
	}

}
