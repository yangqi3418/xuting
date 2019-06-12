package com.byzx.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.AuthInfoDao;
import com.byzx.model.AuthInfo;
import com.byzx.service.AuthInfoService;
import com.byzx.util.DateUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Service
public class AuthInfoServiceImpl implements AuthInfoService{

	
@Autowired
private AuthInfoDao authInfoDao;//注入DAO层方法



//菜单展示
@Override
public JSONArray findAllAuth(String parentId, List<Integer> authslist) {

	JSONArray jsonArray=this.getAllAuth(parentId, authslist);//使用递归方法查询判断是否还有子节点
	for(int i=0;i<jsonArray.size();i++) {
		JSONObject jsonObject=(JSONObject) jsonArray.get(i);
		if("open".equals(jsonObject.getString("state"))) {
			continue;
		}else {
			jsonObject.put("children", findAllAuth(jsonObject.getInt("id")+"",authslist));
			
		}
		
	}
	return jsonArray;
}
//菜单展示解析
public JSONArray getAllAuth(String parentId,List<Integer> authslist) {
	Map<String,Object> map=new HashMap<String,Object>();//将查询的ParentId,和authIds封装到map集合里
	map.put("parentId", parentId);
	map.put("authslist", authslist);
	List<AuthInfo> AuthInfolist=authInfoDao.getAllAuth(map);
	JSONArray jsonArray=new JSONArray();
	for(int i=0;i<AuthInfolist.size();i++) {//遍历解析查询得到的数据
		JSONObject  jsonObject=new  JSONObject();
		jsonObject.put("id",AuthInfolist.get(i).getAuthId() );
		jsonObject.put("text",AuthInfolist.get(i).getAuthName() );
		jsonObject.put("iconCls",AuthInfolist.get(i).getIconCls() );
			
			/*
			 * if(!hasChildren(AuthInfolist.get(i).getAuthId(),AuthInfolist)) {
			 * 
			 * jsonObject.put("state", "open"); }else {
			 * jsonObject.put("state",AuthInfolist.get(i).getParentId()); }
			 */
			 	
	    jsonObject.put("state",AuthInfolist.get(i).getParentId());
		jsonObject.put("parentId", AuthInfolist.get(i).getParentId());
		
		
		JSONObject jsonObjectAuthPath=new  JSONObject();
		jsonObjectAuthPath.put("url",AuthInfolist.get(i).getAuthPath());
		jsonObject.put("attributes",jsonObjectAuthPath);
		jsonArray.add(jsonObject);
		
	}
	return jsonArray;
}





	//判断师傅有子节点
	
	  public boolean hasChildren(Integer parentId, List<AuthInfo> authInfolist) {
		  
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("parentId",parentId+"");
	   
	  map.put("authIdList", authInfolist); 
	  int result=authInfoDao.hasChildren(map);
	  
	 
	 if(result>0) { 
		 return true; 
		 }else { 
		 return false;
			 
} 
	 }
	 
	 


//角色授权
@Override
public JSONArray findAllAuthInfo(String parentId,String authIds) {
	JSONArray jsonArray=this.getAllAuthByParentId(parentId,authIds);//使用递归方法查询判断是否还有子节点
	
	for(int i=0;i<jsonArray.size();i++) {
		JSONObject jsonObject=(JSONObject) jsonArray.get(i);
		if("open".equals(jsonObject.getString("state"))) {
			continue;
		}else {
			jsonObject.put("children", findAllAuthInfo(jsonObject.getInt("id")+"", authIds));
			
		}
		
	}
	return jsonArray;
	
}



//角色授权解析
public JSONArray getAllAuthByParentId(String parentId, String authIds) {
	Map<String,Object> map=new HashMap<String,Object>();//将查询的ParentId,和authIds封装到map集合里
	map.put("parentId", parentId);
	map.put("authIdList", authIds);
	List<AuthInfo> AuthInfolist=authInfoDao.getAllAuthByParentId(map);
	System.out.println(AuthInfolist);
	JSONArray jsonArray=new JSONArray();
	for(int i=0;i<AuthInfolist.size();i++) {//遍历解析查询得到的数据
		JSONObject  jsonObject=new  JSONObject();
		int authId=AuthInfolist.get(i).getAuthId();
		jsonObject.put("id",AuthInfolist.get(i).getAuthId());
		jsonObject.put("text",AuthInfolist.get(i).getAuthName() );
		jsonObject.put("iconCls",AuthInfolist.get(i).getIconCls() );
		jsonObject.put("state",AuthInfolist.get(i).getState() );
		if(StringUtil.existStrArr(authId+"", authIds.split(","))) {
			jsonObject.put("checked", true);
			
		}
		JSONObject jsonObjectAuthPath=new  JSONObject();
		jsonObjectAuthPath.put("url",AuthInfolist.get(i).getAuthPath());
		jsonObject.put("attributes",jsonObjectAuthPath);
		jsonArray.add(jsonObject);
		
	}
	return jsonArray;
}







//菜单展示
@Override
public JSONArray findAllAuthInfos(String parentId) {
	
	JSONArray jsonArray=this.getAllAuthInfos(parentId);//使用递归方法查询判断是否还有子节点

	for(int i=0;i<jsonArray.size();i++) {
		JSONObject jsonObject=(JSONObject) jsonArray.get(i);
		if("open".equals(jsonObject.getString("state"))) {
			continue;
		}else {
			jsonObject.put("children",findAllAuthInfos(jsonObject.getInt("authId")+""));
			
		}
		
	}
	return jsonArray;
	
}
//菜单展示解析
public JSONArray getAllAuthInfos(String parentId) {
	List<AuthInfo> authInfoList=authInfoDao.findAllAuthInfos(Integer.parseInt(parentId));
	JSONArray jsonArray=new JSONArray();
	for(int i=0;i<authInfoList.size();i++) {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("authId",authInfoList.get(i).getAuthId());
		jsonObject.put("authName",authInfoList.get(i).getAuthName());
		jsonObject.put("authPath",authInfoList.get(i).getAuthPath());
		jsonObject.put("parentId",authInfoList.get(i).getParentId());
		jsonObject.put("authDescription",authInfoList.get(i).getAuthDescription() );
		jsonObject.put("state",authInfoList.get(i).getState());
		jsonObject.put("iconCls",authInfoList.get(i).getIconCls());
		jsonObject.put("delflag",authInfoList.get(i).getDelflag());
		jsonObject.put("currentTime",authInfoList.get(i).getCurrentTime());
		jsonArray.add(jsonObject);
	}
	return jsonArray;
}
//菜单添加
@Override
public int addAuthInfo(AuthInfo authInfo) {
	
	authInfoDao.updateAuthIdByparentId(authInfo.getAuthId());
	authInfo.setParentId(authInfo.getAuthId());
	authInfo.setAuthId(null);
	authInfo.setState("close");
	
	authInfo.setDelflag(0);
	
	authInfo.setAuthPath("界面链接");
	authInfo.setIconCls("菜单图标");
	
	authInfo.setCurrentTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd hh-mm-ss"));
	
	return authInfoDao.addAuthInfo(authInfo);
	
		
}
//菜单删除
@Override
public int deleteAuthInfo(String authId) {
	int result = authInfoDao.deleteAuthInfo(Integer.parseInt(authId));
	return result;
}
//菜单修改
@Override
public int updateAuthInfo(AuthInfo authInfo) {
	return authInfoDao.updateAuthInfo(authInfo);}


	/*
	 * //查找父节点
	 * 
	 * @Override public JSONArray findAllAuthInfo(String parentId) { JSONArray
	 * jsonArray = this.getAllAuthInfos(parentId);
	 * 
	 * for(int i=0;i<jsonArray.size();i++) {
	 * 
	 * JSONObject jsonObject = new JSONObject();
	 * 
	 * jsonObject=(JSONObject) jsonArray.get(i);
	 * 
	 * if(!"open".equals(jsonObject.getString("state"))) {
	 * 
	 * jsonObject.put("children", findAllAuthInfo(jsonObject.getInt("authId")+""));
	 * 
	 * }else {
	 * 
	 * continue; } } return jsonArray; }
	 */
}

