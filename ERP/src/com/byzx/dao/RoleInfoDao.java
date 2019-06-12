package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.RoleInfo;

public interface RoleInfoDao {
	
	

	

	

	public String findAuthIdByRoleId(Integer roleId);
	
	public List<RoleInfo>  roleComboxList();
	
	public List<RoleInfo>  findAllRole(Map map);
	
	public int findAllRoleCount(Map map);

	public int addRoleInfo(RoleInfo roleInfo);



	public int updateRoleInfo(RoleInfo roleInfo);

	public int deleteRoleInfo(String string);

	

	public int updateAuthIdByRoleId(Map<String, Object> map);

	
	
}
