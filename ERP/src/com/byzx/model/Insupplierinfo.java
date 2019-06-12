package com.byzx.model;

import java.util.List;

public class Insupplierinfo {
	
	private  Integer  insiid;//��������Ϣ���� id
	private String insicode; //��������Ϣ����  ����
	private String insiname; //��������Ϣ���� ����
	private int inscid; //����������id
	private int inslid; //�����̵ȼ�id
	private int insaid; //����������id
	private String insiaddress; //��������Ϣ����   ��ַ
	private String insiphone; //��������Ϣ����   ��ϵ��ʽ
	private String insilicense; //��������Ϣ����  ִ��
	private String insipermitlicense; //��������Ϣ����  ���֤
	private String insilegalman; //��������Ϣ����  ���˴���
	private String insitaxnum; //��������Ϣ����  ˰��
	private String insibank; //��������Ϣ����    �˺� 
	private String  insibankaccount; //��������Ϣ����  �����˻�
	private String  remark; //��������Ϣ����  ��ע
	private int state; //��������Ϣ����   ִ��״̬
	private int delflag; //��������Ϣ����  ɾ��״̬
	private int optid; //��������Ϣ����   ������id
	private String  optname;  //��������Ϣ����  ����������
	private int optdeptid;  //��������Ϣ����   ִ�в���id
	private int optorgid;  //��������Ϣ����   ִ�л���id
	private String currdate;  //��������Ϣ����   ������ǰʱ��
	private List<InSupplierArea> inSupplierArea;  //����������
	private List<InSuppliercategory> inSuppliercategory;  //���������
	private List<InSupplierlevel> inSupplierlevel;  //������ �Ǽ�
	private List<InSupplierlinkMan> inSupplierlinkMan;  //��������ϵ��
	
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
