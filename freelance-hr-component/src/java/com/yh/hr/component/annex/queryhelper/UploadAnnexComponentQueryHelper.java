/**
 * 
 */
package com.yh.hr.component.annex.queryhelper;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.yh.component.taglib.TableTagBean;
import com.yh.hr.component.annex.dto.FileAnnexDTO;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.BeanHelper;

/**
 * 
 * @author	liul
 * @version	1.0
 * @date 2018-5-9
 */

public class UploadAnnexComponentQueryHelper {


	/**
	 * 查询文件列表，不分页
	 * @param ttb（refRoleCode 必填）
	 * @return
	 * @throws ServiceException
	 */
	public static List<FileAnnexDTO> listAnnexFile(TableTagBean ttb) throws ServiceException {
		StringBuilder hql = new StringBuilder();
		
		hql.append("from FileAnnex yfa where 1=1"); 
		
		if(StringUtils.isNotEmpty(ttb.getCondition().get("fileId"))){
			hql.append("and yfa.fileId = '"+ttb.getCondition().get("fileId")+"'");
		}
		if(StringUtils.isNotEmpty(ttb.getCondition().get("faUserName"))){
			hql.append("and yfa.faUserName = '"+ttb.getCondition().get("faUserName")+"'");
		}
		hql.append(" order by yfa.faDate desc ");
		List<FileAnnexDTO> list = BeanHelper.copyProperties(DaoUtil.find(hql.toString()),FileAnnexDTO.class);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return list;
	}
	/**
	 * 判断是否存在同名文件
	 * @param path
	 * @return
	 * @throws ServiceException
	 */
	public static Boolean checkFileName(String path) throws ServiceException{
		StringBuffer sql = new StringBuffer();
		sql.append("select 1 from yhf_file_annex yfa where 1=1");
		if(StringUtils.isNotEmpty(path)){
			sql.append(" and yfa.fa_path = '"+path+"'");
			List<Object[]> list = DaoUtil.findWithSQL(sql.toString());
			if(CollectionUtils.isNotEmpty(list)) {
				return true;
			}
		}
		return false;
	}

}
