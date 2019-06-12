package com.byzx.service;

import java.util.Map;

import com.byzx.model.RoleInfo;

import net.sf.json.JSONArray;

public interface RoleInfoService {
	
public String findAuthIdByRoleId(Integer roleId);
	
	
public JSONArray roleComboxList();

public int findAllRoleCount(Map<String, Object> map);


public JSONArray findAllRole(Map<String, Object> map);


public int addRoleInfo(RoleInfo roleInfo);


public int updateRoleInfo(RoleInfo roleInfo);


public int deleteRoleInfo(String ids);

//���ݽ�ɫid�޸Ĳ˵����룬�ﵽ�޸�Ȩ�޵�Ŀ��
public int updateAuthIdByRoleId(Map<String, Object> map);

}
