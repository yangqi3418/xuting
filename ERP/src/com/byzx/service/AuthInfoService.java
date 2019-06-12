package com.byzx.service;

import java.util.List;
import java.util.Map;

import com.byzx.model.AuthInfo;

import net.sf.json.JSONArray;

public interface AuthInfoService {
	
	public  JSONArray findAllAuth(String parentId, List<Integer> authslist);



	public JSONArray findAllAuthInfo(String parentId, String authIds);




	public JSONArray findAllAuthInfos(String parentId);


//�˵����
	public int addAuthInfo(AuthInfo authInfo);

//�ˆι�����d�б�
//	public JSONArray findAllAuthInfo(String parentId);


	public int deleteAuthInfo(String authId);



	public int updateAuthInfo(AuthInfo authInfo);



}
