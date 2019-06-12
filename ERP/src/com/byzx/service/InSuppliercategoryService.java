package com.byzx.service;

import java.util.Map;

import com.byzx.model.InSuppliercategory;
import com.byzx.model.UserInfo;

import net.sf.json.JSONArray;

    public interface InSuppliercategoryService {
    	
    //���Ͳ���	
	public JSONArray findAllSupplier(Map<String, Object> map);
    //��ҵ����
	public int findAllSupplierCount(Map<String, Object> map);
    //�������
	
	public int addsupplier(InSuppliercategory inSuppliercategory, UserInfo userInfo);
	
	//��֤���ƺͱ���Ψһ
	public String findInsccodeNameExist(String insccode);
	
	public String findsupplierNameExist(String inscname);
	//�����޸�
	public int updateSupplier(InSuppliercategory inSuppliercategory);
	//����ɾ��
	public int deletesupplier(String ids);

}
