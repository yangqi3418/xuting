package com.byzx.service;

import java.util.Map;

import com.byzx.model.UserInfo;
import com.byzx.model.WorkBook;

import net.sf.json.JSONArray;

public interface WorkBookService {
	
	public  JSONArray  findAllWorkBook(Map<String, Object> map);

	public int findAllWorkBookCount(Map<String, Object> map);

	
	//��ϸ���޸�


	public int deleteWorkBookAndDetailByWid(String wid);

  

	public  int updateWorkBook(WorkBook workBook,UserInfo userInfo);

	 

	public int addWorkBook( WorkBook workBook,UserInfo userInfo);
	
//����Ψһ����֤
	public String findworkBookwNameExist(String wname);

	

}
