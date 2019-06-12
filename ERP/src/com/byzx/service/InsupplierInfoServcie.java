package com.byzx.service;

import java.util.Map;

import com.byzx.model.Insupplierinfo;
import com.byzx.model.UserInfo;

import net.sf.json.JSONArray;

public interface InsupplierInfoServcie {

	
	//查询供应商信息
	public JSONArray findAllInsupplierinfo(Map<String, Object> map);
	
	//查询供应商信息分页
	public int findAllInsupplierCount(Map<String, Object> map);

	//主细表添加
	public int addInsupplierinfo(Insupplierinfo insupplierinfo, UserInfo userInfo);

	//主细表删除
	public int deleteInsupplierinfoByInsiid(String insiid);
	
	//修改主细表

	public int updateInsupplierinfo(Insupplierinfo insupplierinfo, UserInfo userInfo);
	
	
    //验证名称唯一性
	public String findIndInsinameNameExist(String insiname);
	 //验证税号唯一性
	public String findIndInsitaxnumNameExist(String insitaxnum);
	 //验证电话号码唯一性
	public String findIndInsiphoneNameExist(String insiphone);

	

	
	

}
