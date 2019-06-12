package com.byzx.service;

import java.util.Map;

import com.byzx.model.InDeliveryWay;
import com.byzx.model.UserInfo;

import net.sf.json.JSONArray;

public interface InDeliveryWayService {

	//���ҽ������
	public JSONArray findAllInDeliveryWay(Map<String, Object> map);
    //���ҷ�ҵ����
	public int findAllInDeliveryWayCount(Map<String, Object> map);
	 //������ʽ���
	public int addInDeliveryWay(InDeliveryWay inDeliveryWay, UserInfo userInfo);
	//������ʽ�޸�
	public int updateInDeliveryWay(InDeliveryWay inDeliveryWay);
	//��֤���ƺͱ���Ψһ��
	public String findIndwcodeNameExist(String indwcode);
	public String findIndwnameNameExist(String indwname);
	//��������ɾ��
	public int deleteInDeliveryWay(String ids);
	
	
	

}
