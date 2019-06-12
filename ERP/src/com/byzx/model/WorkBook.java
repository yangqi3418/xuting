package com.byzx.model;

import java.util.List;

public class WorkBook {
	
	private Integer wid;  //数据字典主表id
	private String wname;   //数据字典主表名称
	private int delflag;   //数据字典主表删除状态，删除0，未删除1
	private String remark;   //数据字典主表备注
	private String  currentTime;   //数据字典创建时间
	private String  updateTime;   //数据字典修改时间
	
	private String  optionPerson;     //数据字典主表操作人
	private List<WorkBookDetail> workBookDetail;//数据字典字表列表
	
	
	
	public List<WorkBookDetail> getWorkBookDetail() {
		return workBookDetail;
	}
	public void setWorkBookDetail(List<WorkBookDetail> workBookDetail) {
		this.workBookDetail = workBookDetail;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getOptionPerson() {
		return optionPerson;
	}
	public void setOptionPerson(String optionPerson) {
		this.optionPerson = optionPerson;
	}
	
	
	
	
	
}
