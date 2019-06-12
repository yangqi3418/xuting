package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.UserInfo;

public interface UserInfoDao {
	
	public UserInfo login(UserInfo userInfo);

	public List<UserInfo> findAllUserInfos(Map<String,Object> map);
	

	public int findAllUserInfoCount(Map map);

	public String  findUserNameExist(String uname);
	

	public int addUserInfo(UserInfo userInfo);

	public int updateUserInfo(UserInfo userInfo);

	public int deleteUserInfo(String id);

}
