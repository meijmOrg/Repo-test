/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-11-12
**/
package com.yh.hr.res.pt.dto;

public class PtReportHistoryDTO{

	private Long  	ptReportHistoryOid;	//主键
	private Long  	taskOid;	//TaskOid
	private String	reportType;	//报表类型
	private String	reportPdfName;	//历史报表名称
	private String	createdByCode;	//CreatedByCode
	private String	createdByName;	//CreatedByName
	private java.util.Date  	createdDate;	//CreatedDate

	public PtReportHistoryDTO() {

	}

	public void setPtReportHistoryOid(Long ptReportHistoryOid){
		this.ptReportHistoryOid = ptReportHistoryOid;
	}

	public Long getPtReportHistoryOid(){
		return this.ptReportHistoryOid;
	}

	public void setTaskOid(Long taskOid){
		this.taskOid = taskOid;
	}

	public Long getTaskOid(){
		return this.taskOid;
	}

	public void setReportType(String reportType){
		this.reportType = reportType;
	}

	public String getReportType(){
		return this.reportType;
	}

	public void setReportPdfName(String reportPdfName){
		this.reportPdfName = reportPdfName;
	}

	public String getReportPdfName(){
		return this.reportPdfName;
	}

	public void setCreatedByCode(String createdByCode){
		this.createdByCode = createdByCode;
	}

	public String getCreatedByCode(){
		return this.createdByCode;
	}

	public void setCreatedByName(String createdByName){
		this.createdByName = createdByName;
	}

	public String getCreatedByName(){
		return this.createdByName;
	}

	public void setCreatedDate(java.util.Date createdDate){
		this.createdDate = createdDate;
	}

	public java.util.Date getCreatedDate(){
		return this.createdDate;
	}

}
