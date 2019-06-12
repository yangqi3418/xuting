package com.byzx.model;

import java.util.List;

public class Insupplierinfo {
	
	private  Integer  insiid;//供應商信息管理 id
	private String insicode; //供應商信息管理  编码
	private String insiname; //供應商信息管理 名称
	private int inscid; //供應商类型id
	private int inslid; //供應商等级id
	private int insaid; //供應商区域id
	private String insiaddress; //供應商信息管理   地址
	private String insiphone; //供應商信息管理   联系方式
	private String insilicense; //供應商信息管理  执照
	private String insipermitlicense; //供應商信息管理  许可证
	private String insilegalman; //供應商信息管理  法人代表
	private String insitaxnum; //供應商信息管理  税号
	private String insibank; //供應商信息管理    账号 
	private String  insibankaccount; //供應商信息管理  银行账户
	private String  remark; //供應商信息管理  备注
	private int state; //供應商信息管理   执行状态
	private int delflag; //供應商信息管理  删除状态
	private int optid; //供應商信息管理   操作人id
	private String  optname;  //供應商信息管理  操作人名称
	private int optdeptid;  //供應商信息管理   执行部门id
	private int optorgid;  //供應商信息管理   执行机构id
	private String currdate;  //供應商信息管理   操作当前时间
	private List<InSupplierArea> inSupplierArea;  //供應商区域
	private List<InSuppliercategory> inSuppliercategory;  //供應商类别
	private List<InSupplierlevel> inSupplierlevel;  //供應商 星级
	private List<InSupplierlinkMan> inSupplierlinkMan;  //供應商联系人
	
	public List<InSupplierArea> getInSupplierArea() {
		return inSupplierArea;
	}
	public void setInSupplierArea(List<InSupplierArea> inSupplierArea) {
		this.inSupplierArea = inSupplierArea;
	}
	public List<InSuppliercategory> getInSuppliercategory() {
		return inSuppliercategory;
	}
	public void setInSuppliercategory(List<InSuppliercategory> inSuppliercategory) {
		this.inSuppliercategory = inSuppliercategory;
	}
	public List<InSupplierlevel> getInSupplierlevel() {
		return inSupplierlevel;
	}
	public void setInSupplierlevel(List<InSupplierlevel> inSupplierlevel) {
		this.inSupplierlevel = inSupplierlevel;
	}
	public List<InSupplierlinkMan> getInSupplierlinkMan() {
		return inSupplierlinkMan;
	}
	public void setInSupplierlinkMan(List<InSupplierlinkMan> inSupplierlinkMan) {
		this.inSupplierlinkMan = inSupplierlinkMan;
	}
	public Integer getInsiid() {
		return insiid;
	}
	public void setInsiid(Integer insiid) {
		this.insiid = insiid;
	}
	public String getInsicode() {
		return insicode;
	}
	public void setInsicode(String insicode) {
		this.insicode = insicode;
	}
	public String getInsiname() {
		return insiname;
	}
	public void setInsiname(String insiname) {
		this.insiname = insiname;
	}
	public int getInscid() {
		return inscid;
	}
	public void setInscid(int inscid) {
		this.inscid = inscid;
	}
	public int getInslid() {
		return inslid;
	}
	public void setInslid(int inslid) {
		this.inslid = inslid;
	}
	public int getInsaid() {
		return insaid;
	}
	public void setInsaid(int insaid) {
		this.insaid = insaid;
	}
	public String getInsiaddress() {
		return insiaddress;
	}
	public void setInsiaddress(String insiaddress) {
		this.insiaddress = insiaddress;
	}
	public String getInsiphone() {
		return insiphone;
	}
	public void setInsiphone(String insiphone) {
		this.insiphone = insiphone;
	}
	public String getInsilicense() {
		return insilicense;
	}
	public void setInsilicense(String insilicense) {
		this.insilicense = insilicense;
	}
	public String getInsipermitlicense() {
		return insipermitlicense;
	}
	public void setInsipermitlicense(String insipermitlicense) {
		this.insipermitlicense = insipermitlicense;
	}
	public String getInsilegalman() {
		return insilegalman;
	}
	public void setInsilegalman(String insilegalman) {
		this.insilegalman = insilegalman;
	}
	public String getInsitaxnum() {
		return insitaxnum;
	}
	public void setInsitaxnum(String insitaxnum) {
		this.insitaxnum = insitaxnum;
	}
	public String getInsibank() {
		return insibank;
	}
	public void setInsibank(String insibank) {
		this.insibank = insibank;
	}
	public String getInsibankaccount() {
		return insibankaccount;
	}
	public void setInsibankaccount(String insibankaccount) {
		this.insibankaccount = insibankaccount;
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
