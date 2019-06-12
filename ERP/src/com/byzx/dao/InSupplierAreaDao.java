package com.byzx.dao;

import java.util.List;

import com.byzx.model.InSupplierArea;

public interface InSupplierAreaDao {
	
	//字表查询
	public List<InSupplierArea> findInSupplierArea(Integer insaid);
	
	
//字表添加
	public void addInSupplierArea(InSupplierArea inSupplierArea);

//删除字表
	public void deleteInSupplierAreaByinsaid(Integer insaid);
	

}
