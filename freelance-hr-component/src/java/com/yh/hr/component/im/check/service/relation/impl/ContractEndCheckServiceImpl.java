package com.yh.hr.component.im.check.service.relation.impl;

import com.yh.hr.component.im.check.service.relation.RelationCheckService;
import com.yh.hr.component.im.tablehandle.util.SqlDaoUtil;
import com.yh.platform.core.exception.ServiceException;

/**
 * 合同截止时间关联性检查实现类
 * @author wangx
 * @date 2017-07-19
 * @version 1.0
 */
public class ContractEndCheckServiceImpl implements RelationCheckService {

	/**
	 * 合同截止时间关联性检查
	 * @param importBatchOid 当前导入批次号
	 * @throws ServiceException
	 */
	public void check(Long importBatchOid) throws ServiceException {
		//先清空该导入批次所有人员合同截止时间字段的关联性检查异常数据
		deleteUnusualLogs(importBatchOid);
		//批量插入该导入批次所有人员合同截止时间字段的关联性检查异常数据
		insertUnusualLogs(importBatchOid);
	}

	/**
	 * 删除该导入批次所有人员合同截止时间字段的关联性检查异常数据
	 * @param importBatchOid
	 * @throws ServiceException
	 */
	private void deleteUnusualLogs(Long importBatchOid) throws ServiceException {
		String delSql = "DELETE FROM yhc_im_check_person_unusual WHERE CHECK_TYPE = '5' AND DATABASE_COLUMN_CODE = 'CONTRACT_END'" + " AND IMPORT_BATCH_OID = "+ importBatchOid;
		SqlDaoUtil.executeSqlUpdate(delSql);
	}
	
	/**
	 * 批量插入该导入批次所有人员合同截止时间字段的关联性检查异常数据
	 * @param importBatchOid
	 * @throws ServiceException
	 */
	private void insertUnusualLogs(Long importBatchOid) throws ServiceException {
		String message = "合同签订方式为固定期限合同时合同截止时间为空";
		String insSql = "INSERT INTO yhc_im_check_person_unusual(CHECK_PERSON_INFO_OID,IMPORT_BATCH_OID,CHECK_TYPE,DATABASE_COLUMN_CODE,DATABASE_COLUMN_NAME,CHECK_STATUS,EFFECTIVE_FLAG,REMARK) " +
				"(SELECT icp.CHECK_PERSON_INFO_OID" +
				","+importBatchOid+
				",'5'" +
				",'CONTRACT_END'" +
				",'合同截止时间'" +
				",'0'" +
				",'1'" +
				",'"+message+
				"' FROM yhc_im_check_person_info icp where icp.CONTRACT_TYPE = '1' and icp.CONTRACT_END is null)";
		SqlDaoUtil.executeSqlUpdate(insSql);
	}
}
