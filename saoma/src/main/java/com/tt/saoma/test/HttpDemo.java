package com.tt.saoma.test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class HttpDemo {

	private String userName = "hfsghy";  //用户名
	private String userpass = "hfsghy112";  //密码
	private String sendUrl = "http://101.132.242.121:82/wgws/OrderServlet";  //发送接口,请根据实际接口进行更改
	private CloseableHttpClient httpClient = null;
	
	public HttpDemo(){
		initHttpClient();
	}
	
	public static void main(String[] args) {
		HttpDemo hd = new HttpDemo();
		hd.sendSmsByHttpClient("13004066565", "【中网信】您本次验证码为123456。请妥善保管！");  //短信内容请根据申请通过的合法模板进行更改
	}
	
	private void initHttpClient(){
		httpClient = HttpClients.createMinimal();
	}
	
	/**
	 * 
	 * @param recvMsisdn 接收者手机号码
	 * @param smsText  短信内容
	 */
	private void sendSmsByHttpClient(String recvMsisdn, String smsText){
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("apName", userName));  
			params.add(new BasicNameValuePair("apPassword", userpass));  
			params.add(new BasicNameValuePair("srcId", ""));  
			params.add(new BasicNameValuePair("calledNumber", recvMsisdn));
			params.add(new BasicNameValuePair("content", smsText));
			
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
			HttpPost postMethod = new HttpPost(sendUrl);
			postMethod.setEntity(entity); //将参数填入POST Entity中  
			HttpResponse response = httpClient.execute(postMethod); //执行POST方法  
			int statuscode = response.getStatusLine().getStatusCode();
			String restr = EntityUtils.toString(response.getEntity(), "UTF-8").trim();
			if(statuscode == 200){
				SAXReader sr = new SAXReader();
		    	Document doc = sr.read(new StringReader(restr));
		    	List<Node> errlist = doc.getRootElement().selectNodes("//error");
		    	for(Node n : errlist){
		    		Element en = (Element) n;
		    		if("0".equals(en.getText())){
	    				System.out.println("发送结果："+docToString(doc));
		    		}else{
	    				System.out.println("发送失败！"+docToString(doc));
		    		}
		    	}
			}else{
				throw new Exception("返回HTTP状态码错误！httpStatus="+statuscode+"; restr="+restr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	private String docToString(Document doc){
		StringWriter sw;
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			sw = new StringWriter();
			XMLWriter writer = new XMLWriter(sw,format);
			writer.write(doc.getRootElement());
			writer.flush();
			return sw.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
