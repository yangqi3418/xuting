package com.byzx.dao;

import java.util.List;

import com.byzx.model.InSupplierlinkMan;

public interface InSupplierlinkManDao {

	//供应商联系人查找
	 public List<InSupplierlinkMan> findInSupplierlinkMan(Integer insiid);

	 //添加供应商联系人
	public void addInSupplierlinkMan(InSupplierlinkMan inSupplierlinkMan);
//删除字表
	public void deleteInSupplierlinkManByinslmid(Integer insiid);
	
//获取主表数据byid
	public List<InSupplierlinkMan> getAllInsupplierinfoDetailByInsiid(Integer insiid);
	
//删除字表
	public void deleteinSupplierlinkManByInslmid(Integer inslmid);
	//修改字表
	public void updateInSupplierlinkManDetail(InSupplierlinkMan inSupplierlinkMan);
//添加字表
	public void addInSupplierlinkMankDetail(InSupplierlinkMan inSupplierlinkMan);
	
	
	

}
