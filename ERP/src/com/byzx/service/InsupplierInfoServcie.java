package com.byzx.service;

import java.util.Map;

import com.byzx.model.Insupplierinfo;
import com.byzx.model.UserInfo;

import net.sf.json.JSONArray;

public interface InsupplierInfoServcie {

	
	//��ѯ��Ӧ����Ϣ
	public JSONArray findAllInsupplierinfo(Map<String, Object> map);
	
	//��ѯ��Ӧ����Ϣ��ҳ
	public int findAllInsupplierCount(Map<String, Object> map);

	//��ϸ�����
	public int addInsupplierinfo(Insupplierinfo insupplierinfo, UserInfo userInfo);

	//��ϸ��ɾ��
	public int deleteInsupplierinfoByInsiid(String insiid);
	
	//�޸���ϸ��

	public int updateInsupplierinfo(Insupplierinfo insupplierinfo, UserInfo userInfo);
	
	
    //��֤����Ψһ��
	public String findIndInsinameNameExist(String insiname);
	 //��֤˰��Ψһ��
	public String findIndInsitaxnumNameExist(String insitaxnum);
	 //��֤�绰����Ψһ��
	public String findIndInsiphoneNameExist(String insiphone);

	

	
	

}
