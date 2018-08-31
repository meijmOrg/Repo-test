package com.yh.hr.component.flow.service.impl;

import org.apache.commons.lang.StringUtils;

import com.yh.component.workflow.bo.FileTemplate;
import com.yh.component.workflow.bo.FlowActivity;
import com.yh.hr.component.flow.bo.CarbonCopy;
import com.yh.hr.component.flow.bo.File;
import com.yh.hr.component.flow.bo.SelUser;
import com.yh.hr.component.flow.bo.Task;
import com.yh.hr.component.flow.bo.TaskProcess;
import com.yh.hr.component.flow.dto.YhFlowComponentDTO;
import com.yh.hr.component.flow.service.YhfTaskManageService;
import com.yh.platform.core.dao.DaoUtil;
import com.yh.platform.core.exception.ServiceException;
import com.yh.platform.core.util.DateUtil;
import com.yh.platform.core.util.UuidUtils;
import com.yh.platform.core.web.UserContext;
/**
 * @description 流程启动组件ServiceImpl抽像类
 * @author meijm
 * @created 2018-6-26
 * @version 1.0
 */
public abstract class YhFlowComponentAbstractServiceImpl implements  YhfTaskManageService
{
	protected YhFlowComponentDTO yhFlowComponentDTO;
	
	public void setYhFlowComponentDTO(YhFlowComponentDTO yhFlowComponentDTO) {
		this.yhFlowComponentDTO = yhFlowComponentDTO;
	}
	
	/**
	 * 提交流程（确定）
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitFlowStart(YhFlowComponentDTO dto) throws ServiceException{
		//下一步选择的办理人及活动单元Id
		String[] nextUsers = null;
		String nextActId = "";
		//获取上一步活动单元信息
		FlowActivity probo = DaoUtil.get(FlowActivity.class, dto.getTaskPreActId());
		
		if(StringUtils.isNotEmpty(dto.getNextUserList())){
			//1.保存文档信息 YHFile(文件基础表状态1-审批中)
			String fileId = saveFileInfo(dto);
			yhFlowComponentDTO.setFileId(fileId);
			nextUsers = dto.getNextUserList().split(",");//注意每个用户id前面带了36位的所属actId
			for(int i = 0;i<nextUsers.length;i++){
				nextActId = nextUsers[i].toString().substring(0, 36);
				//获取当前（下一步审批）活动单元信息
				FlowActivity currentbo = DaoUtil.get(FlowActivity.class, nextActId);
				//2.保存任务表信息 YHTask
				saveTaskInfo(dto, probo, currentbo, fileId);
			}
		
			//3.保存任务进程表信息 YHTaskProcess
			saveTaskProcessInfo(dto);
			//4.保存设置的下一步用户办理人信息
			saveSelUserInfo(dto, fileId, nextUsers);
			//5.保存抄送记录信息(如果有选择抄送人才保存)
			if(StringUtils.isNotEmpty(dto.getCsUserList())){
				CarbonCopy cbc = new CarbonCopy();
				cbc.setCcId(UuidUtils.getUUID36());
				cbc.setCcActId(dto.getTaskCurrentActId());
				cbc.setCcUser(dto.getCsUserList());
				cbc.setCcFlowId(dto.getFlowId());
				cbc.setCcTime(DateUtil.now());
				cbc.setCcCreateUser(UserContext.getLoginUserID());
				cbc.setCcFileID(fileId);
				cbc.save();
			}
			
			//6.保存其他业务信息
			createSubTaskInfo(yhFlowComponentDTO);
		}
	}
	
	public String saveFileInfo(YhFlowComponentDTO dto) throws ServiceException{
		//获取模板信息
		FileTemplate tbo =DaoUtil.get(FileTemplate.class, dto.getTemplateId());
		File f = new File();
		f.setFileId(UuidUtils.getUUID36());
		f.setTemplateId(tbo.getTemplateId());
		f.setTemplateCode(tbo.getTemplateCode());
		f.setFileCode(dto.getFileCode());
		f.setFileTitle(dto.getFileTitle());
		f.setFileKeyWord(dto.getFileKeyWord());
		f.setFileFlowStatus(dto.getFileFlowStatus());
		f.setCreateDate(DateUtil.now());
		f.setCreateUserID(UserContext.getLoginUserID());
		f.setCreateUserName(UserContext.getLoginUserName());
		f.setCreateDepartID(UserContext.getLoginUserDeptOid());
		f.setFileEmergencyLevel(dto.getFileEmergencyLevel());
		f.setFileSecurityRate(dto.getFileSecurityRate());
		f.save();
		return f.getFileId();
	}
	
	public void saveTaskInfo(YhFlowComponentDTO dto, FlowActivity probo, FlowActivity currentbo, String fileId) throws ServiceException{
		Task t = new Task();
		t.setTaskId(UuidUtils.getUUID36());
		t.setFlowId(probo.getFlowId());
		t.setRuleId(probo.getActEndRuleId());
		t.setFileId(fileId);
		t.setDeptId(UserContext.getLoginUserDeptOid());
		t.setTaskCurrentActId(currentbo.getActId());
		t.setTaskPreActId(dto.getTaskPreActId());
		t.setTaskUser(UserContext.getLoginUserID());
		t.setTaskName(dto.getTaskName());
		t.setTaskSendTime(DateUtil.now());
		t.setTaskSendUser(UserContext.getLoginUserID());
		t.setTaskSign(dto.getTaskSign());
		t.setTaskCoordination(dto.getTaskCoordination());
		t.setTaskConunterSign(dto.getTaskConunterSign());
		t.save();
	}
	
	public void saveTaskProcessInfo(YhFlowComponentDTO dto) throws ServiceException{
		TaskProcess tp = new TaskProcess();
		tp.setTaskProcessId(UuidUtils.getUUID36());
		tp.setTaskId("");
		tp.setFlowId(dto.getFlowId());
		tp.setActId("");
		tp.setActName("");
		tp.setFileId(dto.getFileId());
		tp.setRuleId("");
		tp.setTaskProcessDoTime(DateUtil.now());
		tp.setTaskProcessUser(UserContext.getLoginUserID());
		tp.setTaskProcessResult(dto.getTaskProcessResult());
		tp.setTaskProcessExplain(dto.getTaskProcessExplain());
		tp.setDeptId(UserContext.getLoginUserDeptOid());
		tp.setTaskProcessName("");
		tp.setTaskProcessType("");
		tp.setIsSkip(null);
		tp.setSkipUser("");
		tp.setTaskStartTime(null);
		tp.setTaskEndTime(DateUtil.now());
		tp.setTaskFromUser(UserContext.getLoginUserID());
		tp.setTaskSendNextUser("");
		tp.save();
	}
	
	public void saveSelUserInfo(YhFlowComponentDTO dto, String fileId, String[] nextUsers) throws ServiceException{
		//下一步选择的办理人及活动单元Id
		String nextActId = "";
		String nextUserId = "";
		for(int i = 0;i<nextUsers.length;i++){
			nextActId = nextUsers[i].toString().substring(0, 36);
			nextUserId = nextUsers[i].toString().substring(36, nextUsers[i].toString().length());
			SelUser su = new SelUser();
			su.setSelUserId(UuidUtils.getUUID36());
			su.setFileId(fileId);
			su.setActId(nextActId);
			su.setUserId(nextUserId);
			su.setSelType("0");//提交流程所选择的用户
			su.save();
		}
		//如果其他步骤也有设置则保存
		if(StringUtils.isNotEmpty(dto.getOtherUserList())){
			String otherActId = "";
			String otherUserId = "";
			//其他步骤选择的办理人及活动单元Id
			String[] otherUsers = dto.getOtherUserList().split(",");//注意每个用户id前面带了36位的所属actId
//			boolean b = false;
//			String val = "";
//			String val2 = "";
//			List<String> otherUsersList = new ArrayList<String>();
//			for(int j = 0;j<otherUsers.length;j++){
//				val = otherUsers[j];
//				if(otherUsersList.size() == 0){
//					otherUsersList.add(val);
//				}else{
//					for(int k = 0;k<otherUsersList.size();k++){
//						val2 = otherUsersList.get(k);
//						if(val2.substring(0, 36).equals(val.substring(0, 36))){
//							val2 = val2+","+val.substring(36, val.length());
//							otherUsersList.set(k, val2);
//							b=true;
//							break;
//						}
//					}
//					if(!b){
//						otherUsersList.add(val);
//					}
//				}
//			}
			for(int y = 0;y<otherUsers.length;y++){
				otherActId = otherUsers[y].toString().substring(0, 36);
				otherUserId = otherUsers[y].toString().substring(36, otherUsers[y].toString().length());
				SelUser bo = new SelUser();
				bo.setSelUserId(UuidUtils.getUUID36());
				bo.setFileId(fileId);
				bo.setActId(otherActId);
				bo.setUserId(otherUserId);
				bo.setSelType("0");//提交流程所选择的用户
				bo.save();
			}
		}
	}
	
	
	/**
	 * 表单数据暂存
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void saveTemporaryStorage() throws ServiceException{
		//保存文档信息 YHFile(文件基础表状态0-未启动)
		String fileId = saveFileInfo(yhFlowComponentDTO);
		yhFlowComponentDTO.setFileId(fileId);
		//保存具体业务信息
		createSubTaskInfo(yhFlowComponentDTO);
	}
	
	/**
	 * 历史数据
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void saveHistoryData() throws ServiceException{
		//保存文档信息 YHFile(文件基础表状态6-历史数据)
		String fileId = saveFileInfo(yhFlowComponentDTO);
		yhFlowComponentDTO.setFileId(fileId);
		//保存具体业务信息
		createSubTaskInfo(yhFlowComponentDTO);
	}
	
	/**
	 *	保存具体事项信息
	 *	@param	fileId		文件OID
	 *	@throws ServiceException
	 */
	public abstract void createSubTaskInfo(YhFlowComponentDTO dto) throws ServiceException;
	
	/**
	 * 加签(确定)
	 * @param 
	 * @return
	 * @throws ServiceException
	 */
	public void submitSighUsers(YhFlowComponentDTO dto) throws ServiceException{
		//加签选择的办理人(只能选一个人)
		String nextUsersId = dto.getNextUserList();
		String nextActId = dto.getTaskCurrentActId();
		//获取上一步活动单元信息
		FlowActivity probo = DaoUtil.get(FlowActivity.class, dto.getTaskPreActId());
		//获取当前（下一步审批）活动单元信息
		FlowActivity currentbo = DaoUtil.get(FlowActivity.class, nextActId);
		
		
		//1.保存文档信息 YHFile(文件基础表状态5-加签中)
		String fileId = saveFileInfo(dto);
		
		//2.保存任务表信息 YHTask
		saveTaskInfo(dto, probo, currentbo, fileId);
		
		//3.保存任务进程表信息 YHTaskProcess
		saveTaskProcessInfo(dto);
		
		//4.保存加签办理人信息
		SelUser su = new SelUser();
		su.setSelUserId(UuidUtils.getUUID36());
		su.setFileId(fileId);
		su.setActId(nextActId);
		su.setUserId(nextUsersId);
		su.setSelType("1");//加签所选择的用户
		su.save();
		//5.保存其他业务信息
		createSubTaskInfo(yhFlowComponentDTO);
	}
	
}
