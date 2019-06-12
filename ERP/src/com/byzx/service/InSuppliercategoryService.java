package com.byzx.service;

import java.util.Map;

import com.byzx.model.InSuppliercategory;
import com.byzx.model.UserInfo;

import net.sf.json.JSONArray;

    public interface InSuppliercategoryService {
    	
    //类型查找	
	public JSONArray findAllSupplier(Map<String, Object> map);
    //分业行数
	public int findAllSupplierCount(Map<String, Object> map);
    //类型添加
	
	public int addsupplier(InSuppliercategory inSuppliercategory, UserInfo userInfo);
	
	//验证名称和编码唯一
	public String findInsccodeNameExist(String insccode);
	
	public String findsupplierNameExist(String inscname);
	//类型修改
	public int updateSupplier(InSuppliercategory inSuppliercategory);
	//类型删除
	public int deletesupplier(String ids);

}
