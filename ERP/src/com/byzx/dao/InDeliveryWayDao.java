package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.InDeliveryWay;

public interface InDeliveryWayDao {
	
    //��ѯ��������
	public List<InDeliveryWay> findAllInDeliveryWay(Map<String, Object> map);
   //��ѯ��ҳ
	public int findAllInDeliveryWayCount(Map<String, Object> map);

	//������ʽ���
	public int addInDeliveryWay(InDeliveryWay inDeliveryWay);
	//������ʽ�޸�
	public int updateInDeliveryWay(InDeliveryWay inDeliveryWay);
	//Ψһ��֤
	public String findIndwnameNameExist(String indwname);
	public String findIndwcodeNameExist(String indwcode);
	//��������ɾ��
	public int deleteInDeliveryWay(String ids);
	
	
	

}
