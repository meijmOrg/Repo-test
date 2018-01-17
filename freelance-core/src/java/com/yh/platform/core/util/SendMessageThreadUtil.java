package com.yh.platform.core.util;

import java.net.URLEncoder;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class SendMessageThreadUtil extends Thread{
	private static Logger logger = Logger.getLogger(SendMessageThreadUtil.class);
	private String mobile;// 手机号码
	private String content;// 短信内容
//	private String uid;// 当前登陆人id
//	private String uname;// 当前登陆人姓名
	
	
	public SendMessageThreadUtil(HashMap<String, String> map)
	{
		this.mobile=map.get("mobile");
		this.content=map.get("content");
//		this.uid=map.get("uid");
//		this.uname=map.get("uname");
	}
	
	public void run()
	{
		String retCode=sendMsg();
	}
	
	/**
	 * 发送短信消息
	 * @return
	 */
	private String sendMsg()
	{
		String retCode="";
		try
		{
			String contentEncoder = URLEncoder.encode(content, "gb2312");
			HttpClientUtil client = new HttpClientUtil();
			String url = ConfigUtil.getProperty("message.interface.httpUrl")
						+"&uid="+ConfigUtil.getProperty("message.interface.userId")
						+"&psw="+CryptoUtil.md5(ConfigUtil.getProperty("message.interface.password"))
						+"&mobiles="+mobile+"&msg="+contentEncoder;
			retCode = client.httpInvoke(url, "POST", null);
			if (StringUtils.isNotEmpty(retCode))
			{
				logger.info("短信返回参数：" + retCode);
			}else{
				retCode="e001";
			}
		} catch (Exception e)
		{
			retCode="e002";
			logger.info(e.getMessage());
		}
		return retCode;
	}
	
}
