/**
 * Created at 2017-10-31
**/
package com.yh.component.dynamicproperty.dto;
/**
 * 动态字段控制 -- 表属性
 * @author Administrator
 *
 */
public class TablePropertyDTO {

	private java.lang.String  	dataType;//字段类型
	private java.lang.String	columnName;	//字段名称
	private java.lang.String  	dpCode;	//字段编码
	private java.lang.String 	dpCodeName;//字段编码名称
	public java.lang.String getDataType() {
		return dataType;
	}
	public void setDataType(java.lang.String dataType) {
		this.dataType = dataType;
	}
	
	public java.lang.String getColumnName() {
		return columnName;
	}
	public void setColumnName(java.lang.String columnName) {
		this.columnName = columnName;
	}
	public java.lang.String getDpCode() {
		return dpCode;
	}
	public void setDpCode(java.lang.String dpCode) {
		this.dpCode = dpCode;
	}
	public java.lang.String getDpCodeName() {
		return dpCodeName;
	}
	public void setDpCodeName(java.lang.String dpCodeName) {
		this.dpCodeName = dpCodeName;
	}

}
