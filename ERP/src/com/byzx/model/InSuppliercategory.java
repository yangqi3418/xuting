package com.byzx.model;

public class InSuppliercategory {  //��Ӧ�����
	
	private Integer inscid;   //��Ӧ�����id
	private  String insccode;  //��Ӧ�����ͼ��
	private  String inscname;  //��Ӧ���������
	private  String remark;   //��Ӧ�����ע
	private  int  state;   //��Ӧ�����״̬
	private  int delflag;   //��Ӧ�����ɾ��״̬
	private  int optid;   //��Ӧ����� ������id
	private  String  optname;  //��Ӧ�����  ����������
	private  int optdeptid;  //��Ӧ����� �����˲���id
	private  int optorgid;  //��Ӧ�����  ��������id
	private  String currdate;  //��Ӧ����� ��ǰʱ��
	
	
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
