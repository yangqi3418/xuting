package com.byzx.dao;

import java.util.List;

import com.byzx.model.InSupplierlinkMan;

public interface InSupplierlinkManDao {

	//��Ӧ����ϵ�˲���
	 public List<InSupplierlinkMan> findInSupplierlinkMan(Integer insiid);

	 //��ӹ�Ӧ����ϵ��
	public void addInSupplierlinkMan(InSupplierlinkMan inSupplierlinkMan);
//ɾ���ֱ�
	public void deleteInSupplierlinkManByinslmid(Integer insiid);
	
//��ȡ��������byid
	public List<InSupplierlinkMan> getAllInsupplierinfoDetailByInsiid(Integer insiid);
	
//ɾ���ֱ�
	public void deleteinSupplierlinkManByInslmid(Integer inslmid);
	//�޸��ֱ�
	public void updateInSupplierlinkManDetail(InSupplierlinkMan inSupplierlinkMan);
//����ֱ�
	public void addInSupplierlinkMankDetail(InSupplierlinkMan inSupplierlinkMan);
	
	
	

}
