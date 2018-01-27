package com.yh.platform.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 远程接口工具类
 */
public class HttpClientUtil
{
	protected static Log logger = LogFactory.getLog(HttpClientUtil.class);

	myX509TrustManager xtm = new myX509TrustManager();
	myHostnameVerifier hnv = new myHostnameVerifier();

	public HttpClientUtil()
	{
		SSLContext sslContext = null;
		try
		{
			sslContext = SSLContext.getInstance("TLS");
			X509TrustManager[] xtmArray = new X509TrustManager[]
			{ xtm };
			sslContext.init(null, xtmArray, new java.security.SecureRandom());
		} catch (GeneralSecurityException gse)
		{
		}
		if (sslContext != null)
		{
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		}
		HttpsURLConnection.setDefaultHostnameVerifier(hnv);
	}

	public String inputStreamToString(InputStream is, String charSet) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(is, charSet));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null)
		{
			buffer.append(line);
			buffer.append("\r\n");
		}
		in.close();
		return buffer.toString();
	}

	public String getResult(String url, String param)
	{
		return getResult(url, param, false);
	}

	public String getResult(String url, Boolean postType)
	{
		return getResult(url, "", postType);
	}

	public String getResult(String url, String param, Boolean postType)
	{
		String content = "";
		HttpURLConnection connection = null;
		try
		{
			URL restURL = null;
			try
			{
				restURL = new URL(url);
			} catch (Exception me)
			{
				logger.error("获取URL出错!", me);
				me.printStackTrace();
			}
			connection = (HttpURLConnection) restURL.openConnection();
			connection.setConnectTimeout(1000 * 100);
			connection.setReadTimeout(1000 * 150);

			connection.setDoOutput(true);
			if (postType)
			{
				connection.setRequestMethod("POST");
			}
			connection.setRequestProperty("Content-Type", "application/json");
			if ((param != null) && (param.length() > 1))
			{
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);
				OutputStreamWriter outer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
				outer.write(param);
				outer.flush();
				outer.close();
			}
			InputStream ips = connection.getInputStream();
			content = inputStreamToString(ips, "UTF-8");
			ips.close();

			connection.disconnect();
		} catch (Exception e)
		{
			logger.error("获取链接出错!", e);
			e.printStackTrace();
		} finally
		{
			if (connection != null)
			{
				connection.disconnect();
			}
		}
		return content;
	}

	public String httpInvoke(String url, String methodm, String data) throws IOException
	{
		StringBuilder response = new StringBuilder();
		URL httpurl = new URL(url);
		HttpURLConnection hc = (HttpURLConnection) httpurl.openConnection();
		String Method = methodm.toUpperCase();
		hc.setRequestMethod(Method);
		hc.setDoInput(true);
		if ("POST".equals(Method))
		{
			hc.setDoOutput(true);
			if (data != null)
			{
				hc.setRequestProperty("Content-Length", String.valueOf(data.length()));
			}
		}
		hc.setRequestProperty("Content-Type", "application/json");
		hc.setRequestProperty("Charset", "UTF-8");

		hc.connect();
		if ("POST".equals(Method))
		{
			OutputStream ops = hc.getOutputStream();
			byte[] buff;
			if (data != null)
			{
				buff = data.getBytes("UTF-8");
				ops.write(buff);
			}
			ops.flush();
			ops.close();
		}
		int code = hc.getResponseCode();
		if (code == 200)
		{
			InputStream ins;
			ins = hc.getInputStream();
			InputStreamReader isr = new InputStreamReader(ins, "UTF-8");
			char[] cbuf = new char[1024];
			int i = isr.read(cbuf);
			while (i > 0)
			{
				response.append(new String(cbuf, 0, i));
				i = isr.read(cbuf);
			}
			ins.close();
		} else
		{
			InputStream ins;
			ins = hc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(ins, "UTF-8");
			char[] cbuf = new char[1024];
			int i = isr.read(cbuf);
			while (i > 0)
			{
				response.append(new String(cbuf, 0, i));
				i = isr.read(cbuf);
			}
			ins.close();
		}
		hc.disconnect();
		return response.toString();
	}
}

class myX509TrustManager implements X509TrustManager
{
	public myX509TrustManager()
	{
	}

	public void checkClientTrusted(X509Certificate[] chain, String authType)
	{
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType)
	{
		// System.out.println("cert: " + chain[0].toString() + ", authType: " + authType);
	}

	public X509Certificate[] getAcceptedIssuers()
	{
		return null;
	}
}

class myHostnameVerifier implements HostnameVerifier
{
	public myHostnameVerifier()
	{
	}

	public boolean verify(String hostname, SSLSession session)
	{
		// System.out.println("hostname: " + hostname);
		return true;
	}
}
