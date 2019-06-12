package com.byzx.service;

import java.util.Map;

import com.byzx.model.UserInfo;

import net.sf.json.JSONArray;

public interface UserInfoService {
	
	public UserInfo login(UserInfo userInfo);
	
	

	public JSONArray findAllUserInfos(Map<String,Object> map);
	
	public int findAllUserInfoCount(Map map);
	
	public String findUserNameExist(String uname);
	
	public int addUserInfo(UserInfo userInfo);
	
	public int updateUserInfo(UserInfo userInfo);



	public int deleteUserInfo(String ids);
	
	
}
