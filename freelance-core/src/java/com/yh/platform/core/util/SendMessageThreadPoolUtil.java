package com.yh.platform.core.util;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SendMessageThreadPoolUtil {

	
	private static ThreadPoolExecutor JobThreadPool = new ThreadPoolExecutor(2, 20, 30, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2000));
	
	/**发送短信
	 * 开始新任务
	 * @param map
	 * @throws InterruptedException 
	 */
	public static void runJob(HashMap<String, String> map) throws InterruptedException
	{
		SendMessageThreadUtil thread=new SendMessageThreadUtil(map);
		JobThreadPool.execute(thread);
		
	}

}
