package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.InSupplierlinkMan;
import com.byzx.model.Insupplierinfo;

public interface InsupplierInfoDao {
//查找供应商信息
	public List<Insupplierinfo> findAllInsupplierinfo(Map<String, Object> map);
	//查找供应商分页
	public  int  findAllInsupplierCount(Map<String,Object>  map);
	
	//添加主表
	public int addInsupplierinfo(Insupplierinfo insupplierinfo);
	
	//获取当前最大数据表格最大id
	public int getMaxInsupplierInfoId();
	
	//删除主细表
	public int deleteInsupplierinfoByInsiid(Integer insiid);
	
	//主细表修改
	public int updateInsupplierinfo(Insupplierinfo insupplierinfo);
	
	//验证名称唯一性
	public String findIndInsinameNameExist(String insiname);

	//验证税号唯一性
	public String findIndInsitaxnumNameExist(String insitaxnum);
	//验证电话号码唯一性
	public String findIndInsiphoneNameExist(String insiphone);
	
}
