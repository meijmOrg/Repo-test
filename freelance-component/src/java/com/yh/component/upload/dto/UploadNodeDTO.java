/**
 * This file is generated by  code generation tool version 0.2 ^_^
 * Created at 2016-11-08
**/
package com.yh.component.upload.dto;

public class UploadNodeDTO {

	private java.lang.String	uploadNodeCode;	//节点代码
	private java.lang.String	parentNodeCode;	//父节点代码
	private java.lang.String	nodeDesc;	//节点描述
	private java.lang.String	path;	//节点位置（项目目录位置）

	public UploadNodeDTO() {
		
	}

	public void setUploadNodeCode(java.lang.String uploadNodeCode){
		this.uploadNodeCode = uploadNodeCode;
	}

	public java.lang.String getUploadNodeCode(){
		return this.uploadNodeCode;
	}

	public void setParentNodeCode(java.lang.String parentNodeCode){
		this.parentNodeCode = parentNodeCode;
	}

	public java.lang.String getParentNodeCode(){
		return this.parentNodeCode;
	}

	public void setNodeDesc(java.lang.String nodeDesc){
		this.nodeDesc = nodeDesc;
	}

	public java.lang.String getNodeDesc(){
		return this.nodeDesc;
	}

	public void setPath(java.lang.String path){
		this.path = path;
	}

	public java.lang.String getPath(){
		return this.path;
	}

}
