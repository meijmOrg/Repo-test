/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2017-07-11
**/
package com.yh.hr.res.im.dto;

public class ImImportBatchDTO {

	private java.lang.Long  	importBatchOid;	//主键OID
	private java.util.Date  	startTime;	//导入开始时间
	private java.util.Date  	endTime;	//导入结束时间
	private java.lang.Integer	totalAmount;	//文件数据量
	private java.lang.Integer	importAmount;	//导入数据量
	private java.lang.Integer	checkPassedAmount;	//检查通过数据量
	private java.lang.Integer	checkNopassedAmount;	//检查未通过数据量
	private java.lang.String	checkNopassedReason;	//检查未通过说明
	private java.lang.String	importFlowStatus;	//导入流程状态	1：导入前检查通过	2：导入前检查未通过	3：校核通过	4：校核未通过	5：已入库
	private java.lang.Long  	batchBelongId;	//批次隶属ID
	private java.lang.String	batchBelongType;	//批次隶属类型	1：单位	2：科室	3：地区
	private java.lang.String	effectiveFlag;	//生效标识	1：生效	0：失效
	private java.lang.String	remark;	//备注
	private java.lang.String	createdByCode;	//创建人ID
	private java.lang.String	createdByName;	//创建人名称
	private java.util.Date  	createdDate;	//创建时间
	private java.lang.String	updatedByCode;	//修改人ID
	private java.lang.String	updatedByName;	//修改人名称
	private java.util.Date  	updatedDate;	//修改时间

	public ImImportBatchDTO() {
		
	}

	public void setImportBatchOid(java.lang.Long importBatchOid){
		this.importBatchOid = importBatchOid;
	}

	public java.lang.Long getImportBatchOid(){
		return this.importBatchOid;
	}

	public void setStartTime(java.util.Date startTime){
		this.startTime = startTime;
	}

	public java.util.Date getStartTime(){
		return this.startTime;
	}

	public void setEndTime(java.util.Date endTime){
		this.endTime = endTime;
	}

	public java.util.Date getEndTime(){
		return this.endTime;
	}

	public void setTotalAmount(java.lang.Integer totalAmount){
		this.totalAmount = totalAmount;
	}

	public java.lang.Integer getTotalAmount(){
		return this.totalAmount;
	}

	public void setImportAmount(java.lang.Integer importAmount){
		this.importAmount = importAmount;
	}

	public java.lang.Integer getImportAmount(){
		return this.importAmount;
	}

	public void setCheckPassedAmount(java.lang.Integer checkPassedAmount){
		this.checkPassedAmount = checkPassedAmount;
	}

	public java.lang.Integer getCheckPassedAmount(){
		return this.checkPassedAmount;
	}

	public void setCheckNopassedAmount(java.lang.Integer checkNopassedAmount){
		this.checkNopassedAmount = checkNopassedAmount;
	}

	public java.lang.Integer getCheckNopassedAmount(){
		return this.checkNopassedAmount;
	}

	public void setCheckNopassedReason(java.lang.String checkNopassedReason){
		this.checkNopassedReason = checkNopassedReason;
	}

	public java.lang.String getCheckNopassedReason(){
		return this.checkNopassedReason;
	}

	public void setImportFlowStatus(java.lang.String importFlowStatus){
		this.importFlowStatus = importFlowStatus;
	}

	public java.lang.String getImportFlowStatus(){
		return this.importFlowStatus;
	}

	public void setBatchBelongId(java.lang.Long batchBelongId){
		this.batchBelongId = batchBelongId;
	}

	public java.lang.Long getBatchBelongId(){
		return this.batchBelongId;
	}

	public void setBatchBelongType(java.lang.String batchBelongType){
		this.batchBelongType = batchBelongType;
	}

	public java.lang.String getBatchBelongType(){
		return this.batchBelongType;
	}

	public void setEffectiveFlag(java.lang.String effectiveFlag){
		this.effectiveFlag = effectiveFlag;
	}

	public java.lang.String getEffectiveFlag(){
		return this.effectiveFlag;
	}

	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}

	public java.lang.String getRemark(){
		return this.remark;
	}

	public void setCreatedByCode(java.lang.String createdByCode){
		this.createdByCode = createdByCode;
	}

	public java.lang.String getCreatedByCode(){
		return this.createdByCode;
	}

	public void setCreatedByName(java.lang.String createdByName){
		this.createdByName = createdByName;
	}

	public java.lang.String getCreatedByName(){
		return this.createdByName;
	}

	public void setCreatedDate(java.util.Date createdDate){
		this.createdDate = createdDate;
	}

	public java.util.Date getCreatedDate(){
		return this.createdDate;
	}

	public void setUpdatedByCode(java.lang.String updatedByCode){
		this.updatedByCode = updatedByCode;
	}

	public java.lang.String getUpdatedByCode(){
		return this.updatedByCode;
	}

	public void setUpdatedByName(java.lang.String updatedByName){
		this.updatedByName = updatedByName;
	}

	public java.lang.String getUpdatedByName(){
		return this.updatedByName;
	}

	public void setUpdatedDate(java.util.Date updatedDate){
		this.updatedDate = updatedDate;
	}

	public java.util.Date getUpdatedDate(){
		return this.updatedDate;
	}

}
