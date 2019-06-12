package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.InSupplierlinkMan;
import com.byzx.model.Insupplierinfo;

public interface InsupplierInfoDao {
//���ҹ�Ӧ����Ϣ
	public List<Insupplierinfo> findAllInsupplierinfo(Map<String, Object> map);
	//���ҹ�Ӧ�̷�ҳ
	public  int  findAllInsupplierCount(Map<String,Object>  map);
	
	//�������
	public int addInsupplierinfo(Insupplierinfo insupplierinfo);
	
	//��ȡ��ǰ������ݱ�����id
	public int getMaxInsupplierInfoId();
	
	//ɾ����ϸ��
	public int deleteInsupplierinfoByInsiid(Integer insiid);
	
	//��ϸ���޸�
	public int updateInsupplierinfo(Insupplierinfo insupplierinfo);
	
	//��֤����Ψһ��
	public String findIndInsinameNameExist(String insiname);

	//��֤˰��Ψһ��
	public String findIndInsitaxnumNameExist(String insitaxnum);
	//��֤�绰����Ψһ��
	public String findIndInsiphoneNameExist(String insiphone);
	
}
