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
	  
	  
	  //验证编码和名称唯一性 
	  public String findInsccodeNameExist(String insccode);
	  
	  public String findsupplierNameExist(String inscname); //名称修改
	  
	  public int updateSupplier(InSuppliercategory inSuppliercategory);
	  //类型删除 
	  public int deletesupplier(String id);
	  
	  



	//供应商类型字表添加

	public void addInSuppliercategory(InSuppliercategory inSuppliercategory);
	
//删除字表
	public void deleteInSuppliercategoryByinscid(Integer inscid);



	 
		

}
