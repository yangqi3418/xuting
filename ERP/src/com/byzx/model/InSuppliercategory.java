package com.byzx.model;

public class InSuppliercategory {  //供应商类别
	
	private Integer inscid;   //供应商类别id
	private  String insccode;  //供应商类别图标
	private  String inscname;  //供应商类别名称
	private  String remark;   //供应商类别备注
	private  int  state;   //供应商类别状态
	private  int delflag;   //供应商类别删除状态
	private  int optid;   //供应商类别 操作人id
	private  String  optname;  //供应商类别  操作人名称
	private  int optdeptid;  //供应商类别 操作人部门id
	private  int optorgid;  //供应商类别  操作机构id
	private  String currdate;  //供应商类别 当前时间
	
	
	public Integer getInscid() {
		return inscid;
	}
	public void setInscid(Integer inscid) {
		this.inscid = inscid;
	}
	public String getInsccode() {
		return insccode;
	}
	public void setInsccode(String insccode) {
		this.insccode = insccode;
	}
	public String getInscname() {
		return inscname;
	}
	public void setInscname(String inscname) {
		this.inscname = inscname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	public int getOptid() {
		return optid;
	}
	public void setOptid(int optid) {
		this.optid = optid;
	}
	public String getOptname() {
		return optname;
	}
	public void setOptname(String optname) {
		this.optname = optname;
	}
	public int getOptdeptid() {
		return optdeptid;
	}
	public void setOptdeptid(int optdeptid) {
		this.optdeptid = optdeptid;
	}
	public int getOptorgid() {
		return optorgid;
	}
	public void setOptorgid(int optorgid) {
		this.optorgid = optorgid;
	}
	public String getCurrdate() {
		return currdate;
	}
	public void setCurrdate(String currdate) {
		this.currdate = currdate;
	}
	
	
}
