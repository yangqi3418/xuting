package com.byzx.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.UserInfoDao;
import com.byzx.model.UserInfo;
import com.byzx.service.UserInfoService;
import com.byzx.util.DateUtil;
import com.byzx.util.Md5;
import com.byzx.util.UUIDUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	
	//注入UserInfodao层
	@Autowired
	 private UserInfoDao userInfoDao; 
	
	//用户登录service实现方法
	@Override
	public UserInfo login(UserInfo userInfo) {
		userInfo.setPassword(Md5.MD5(userInfo.getPassword()));
		return userInfoDao.login(userInfo);
	}
//用户查询
	@Override
	public JSONArray findAllUserInfos(Map map) {
		List<UserInfo> userInfolist=userInfoDao.findAllUserInfos(map);
		JSONArray jsonArry=new JSONArray();
		for(int i=0;i<userInfolist.size();i++) {
			JSONObject jsonObject= new JSONObject();
			jsonObject.put("uid", userInfolist.get(i).getUid());
			jsonObject.put("uname", userInfolist.get(i).getUname());
			jsonObject.put("password", userInfolist.get(i).getPassword());
			jsonObject.put("userType", userInfolist.get(i).getUserType());
			jsonObject.put("roleId", userInfolist.get(i).getRoleId());
			jsonObject.put("userDescription", userInfolist.get(i).getUserDescription());
			jsonObject.put("delflag", userInfolist.get(i).getDelflag());
			jsonObject.put("currentTime", userInfolist.get(i).getCurrentTime());
			jsonObject.put("roleName", userInfolist.get(i).getRoleName());
			jsonArry.add(jsonObject);
		}
		return jsonArry;
	}
//查询分页
	@Override
	public int findAllUserInfoCount(Map map) {
		
		return  userInfoDao.findAllUserInfoCount(map);
	}
//验证框
	@Override
	public String findUserNameExist(String uname) {
		
		return userInfoDao.findUserNameExist(uname);
	}
//用户添加
	@Override
	public int addUserInfo(UserInfo userInfo) {
		userInfo.setPassword(Md5.MD5(userInfo.getPassword()));
		userInfo.setUid(UUIDUtils.getUUID());
		userInfo.setUserType(1);
		userInfo.setDelflag(0);
		userInfo.setCurrentTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));

		return userInfoDao.addUserInfo(userInfo);
	}
	//用户修改
	@Override
	public int updateUserInfo(UserInfo userInfo) {
		userInfo.setPassword(Md5.MD5(userInfo.getPassword()));
		
		return userInfoDao.updateUserInfo(userInfo);
	}
	//用户删除
	@Override
	public int deleteUserInfo(String ids) {
		String id[]=ids.split(",");
		int count=0;
		for(int i=0;i<id.length;i++) {
			int result=userInfoDao.deleteUserInfo(id[i]);
			if(result>0) {
				count++;
			}
		}
		return count;
	}



}
