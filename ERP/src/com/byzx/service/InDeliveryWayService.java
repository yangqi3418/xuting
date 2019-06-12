package com.byzx.service;

import java.util.Map;

import com.byzx.model.InDeliveryWay;
import com.byzx.model.UserInfo;

import net.sf.json.JSONArray;

public interface InDeliveryWayService {

	//查找交付類型
	public JSONArray findAllInDeliveryWay(Map<String, Object> map);
    //查找分业行数
	public int findAllInDeliveryWayCount(Map<String, Object> map);
	 //交付方式添加
	public int addInDeliveryWay(InDeliveryWay inDeliveryWay, UserInfo userInfo);
	//交付方式修改
	public int updateInDeliveryWay(InDeliveryWay inDeliveryWay);
	//验证名称和编码唯一性
	public String findIndwcodeNameExist(String indwcode);
	public String findIndwnameNameExist(String indwname);
	//交付类型删除
	public int deleteInDeliveryWay(String ids);
	
	
	

}
