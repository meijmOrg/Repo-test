package com.yh.hr.component.annex.utils;




import java.util.Date;

import com.yh.platform.core.util.ConfigUtil;
import com.yh.platform.core.util.DateUtil;


/**
 * 
 *@description       上传文件工具类
 *@author            liul
 *@created           2018-05-8
 *@version           1.0
 *
 */
public class UploadAnnexComponentUtil
{
	private static String UPLOAD_URL = "file.path.annex";
	/**
     * 得到文件路径
     *
     * @param uploadCreateDate
     * @return
     */
    public static String getFilePath( Date uploadCreateDate) {
        String dateStr = DateUtil.format(uploadCreateDate, DateUtil.DATA_PATTERN_YYYYMMDD);
        String year = dateStr.substring(0, 4);
        String month = dateStr.substring(4, 6);
        StringBuffer path = new StringBuffer(ConfigUtil.getProperty(UPLOAD_URL)); //文件上传默认路径
        // 文件上传默认路径/业务类别名/文件上传年/文件上传月/文件
        path.append("/").append(year).append("/").append(month);
        return path.toString();
    }
}
