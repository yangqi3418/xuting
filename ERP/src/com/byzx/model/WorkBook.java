package com.byzx.model;

import java.util.List;

public class WorkBook {
	
	private Integer wid;  //�����ֵ�����id
	private String wname;   //�����ֵ���������
	private int delflag;   //�����ֵ�����ɾ��״̬��ɾ��0��δɾ��1
	private String remark;   //�����ֵ�����ע
	private String  currentTime;   //�����ֵ䴴��ʱ��
	private String  updateTime;   //�����ֵ��޸�ʱ��
	
	private String  optionPerson;     //�����ֵ����������
	private List<WorkBookDetail> workBookDetail;//�����ֵ��ֱ��б�
	
	
	
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
