package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.AuthInfo;


public interface AuthInfoDao {


	public List<AuthInfo> getAllAuth(Map<String,Object> map);
//角色授权
	public List<AuthInfo> getAllAuthByParentId(Map map);

//查找所有的菜单
	public List<AuthInfo> findAllAuthInfos(Integer parentId);

	public int addAuthInfo(AuthInfo authInfo);

	public int updateAuthInfo(AuthInfo authInfo);

	public int deleteAuthInfo(Integer parentId);

	
 //public int hasChildren(Map<String, Object> map);

public int updateAuthIdByparentId(Integer authId); 
//加載菜单列表
//public List<AuthInfo> getAllAuthInfo(Integer parentId);
public int hasChildren(Map<String, Object> map);
	


}
