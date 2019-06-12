package com.byzx.model;

public class WorkBookDetail {
	
	private Integer  wbdId;
	private Integer wid;
	private String wbdName;
	private String remark;
	private int delflag;
	private String currentTime;
	private String  updateTime;
	private  String optionPerson;
	
	public Integer getWbdId() {
		return wbdId;
	}
	public void setWbdId(Integer wbdId) {
		this.wbdId = wbdId;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getWbdName() {
		return wbdName;
	}
	public void setWbdName(String wbdName) {
		this.wbdName = wbdName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
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
