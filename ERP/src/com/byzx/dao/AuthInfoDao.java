package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.AuthInfo;


public interface AuthInfoDao {


	public List<AuthInfo> getAllAuth(Map<String,Object> map);
//��ɫ��Ȩ
	public List<AuthInfo> getAllAuthByParentId(Map map);

//�������еĲ˵�
	public List<AuthInfo> findAllAuthInfos(Integer parentId);

	public int addAuthInfo(AuthInfo authInfo);

	public int updateAuthInfo(AuthInfo authInfo);

	public int deleteAuthInfo(Integer parentId);

	
 //public int hasChildren(Map<String, Object> map);

public int updateAuthIdByparentId(Integer authId); 
//���d�˵��б�
//public List<AuthInfo> getAllAuthInfo(Integer parentId);
public int hasChildren(Map<String, Object> map);
	


}
