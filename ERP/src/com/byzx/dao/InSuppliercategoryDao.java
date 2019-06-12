package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.InSuppliercategory;
import com.byzx.model.InSupplierlinkMan;

public interface InSuppliercategoryDao {

	 public List<InSuppliercategory> findAllSupplier(Map<String, Object> map); 

	public List<InSuppliercategory> findAllSupplierByInscid(Integer inscid);
	
	
	public int findAllSupplierCount(Map<String, Object> map);
	 
	 
	  public int addsupplier(InSuppliercategory inSuppliercategory);
	  
	  
	  //��֤���������Ψһ�� 
	  public String findInsccodeNameExist(String insccode);
	  
	  public String findsupplierNameExist(String inscname); //�����޸�
	  
	  public int updateSupplier(InSuppliercategory inSuppliercategory);
	  //����ɾ�� 
	  public int deletesupplier(String id);
	  
	  



	//��Ӧ�������ֱ����

	public void addInSuppliercategory(InSuppliercategory inSuppliercategory);
	
//ɾ���ֱ�
	public void deleteInSuppliercategoryByinscid(Integer inscid);



	 
		

}
