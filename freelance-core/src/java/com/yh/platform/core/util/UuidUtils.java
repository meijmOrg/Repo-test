package com.yh.platform.core.util;

import java.util.UUID;


/**
 *@Title: getUUID 
 *@Description: TODO(仿照Hibernate UUID生成策略生成 32位36位唯一码) 
 *适用jdk 1.5以上  
 *sqlserver 中 实现 sql code   
 *select NEWID()  36位 
 *select REPLACE('C66F55B4-81CB-4496-A119-523A7C1E8E11', '-', '') 32位
 *@param:     
 *@return: string    
 * 
 *
 *@author		meijm
 *@created		18/02/27
 *@version		1.0
 */

public class UuidUtils {
	/**
	 * 生成36位
	 * @param 
	 * @return
	 * @throws 
	 */
	public static String getUUID36(){  
        String  uuid36 = UUID.randomUUID().toString();  
        return uuid36;
    }  
	
	/**
	 * 生成32位
	 * @param 
	 * @return
	 * @throws 
	 */
	public static String getUUID32(){  
        String  uuid32 = UUID.randomUUID().toString().replaceAll("-", "");  
        return uuid32;
    }  
}
