package com.byzx.dao;

import java.util.List;

import com.byzx.model.InSupplierArea;

public interface InSupplierAreaDao {
	
	//�ֱ��ѯ
	public List<InSupplierArea> findInSupplierArea(Integer insaid);
	
	
//�ֱ����
	public void addInSupplierArea(InSupplierArea inSupplierArea);

//ɾ���ֱ�
	public void deleteInSupplierAreaByinsaid(Integer insaid);
	

}
