package com.byzx.model;

public class InDeliveryWay {  //支付方式
	
	private Integer indwid;  //支付方式id
	private String indwcode;  //支付方式  編碼
	private String indwname;  //支付方式  名稱
	private String remark;   //支付方式  备注
	private   int  state;  //支付方式  支付状态
	private   int delflag;  //支付方式  删除状态
	private   int  optid;   //支付方式  操作人id
	private String optname;   //支付方式  操作人名称
	private   int optdeptid;   //支付方式  操作部门id
	private   int optorgid;   //支付方式    操作机构id
	private String currdate;   //支付方式  当前时间
	
	
	
	public Integer getIndwid() {
		return indwid;
	}
	public void setIndwid(Integer indwid) {
		this.indwid = indwid;
	}
	public String getIndwcode() {
		return indwcode;
	}
	public void setIndwcode(String indwcode) {
		this.indwcode = indwcode;
	}
	public String getIndwname() {
		return indwname;
	}
	public void setIndwname(String indwname) {
		this.indwname = indwname;
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
