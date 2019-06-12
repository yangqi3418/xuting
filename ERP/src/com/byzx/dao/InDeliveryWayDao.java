package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.InDeliveryWay;

public interface InDeliveryWayDao {
	
    //查询交付类型
	public List<InDeliveryWay> findAllInDeliveryWay(Map<String, Object> map);
   //查询分页
	public int findAllInDeliveryWayCount(Map<String, Object> map);

	//交付方式添加
	public int addInDeliveryWay(InDeliveryWay inDeliveryWay);
	//交付方式修改
	public int updateInDeliveryWay(InDeliveryWay inDeliveryWay);
	//唯一验证
	public String findIndwnameNameExist(String indwname);
	public String findIndwcodeNameExist(String indwcode);
	//交付类型删除
	public int deleteInDeliveryWay(String ids);
	
	
	

}
