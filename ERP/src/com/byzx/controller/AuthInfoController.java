package com.byzx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.byzx.model.AuthInfo;
import com.byzx.model.UserInfo;
import com.byzx.service.AuthInfoService;
import com.byzx.service.RoleInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/authInfo")
public class AuthInfoController {
	@Autowired
	private RoleInfoService roleInfoService;
	@Autowired
	private AuthInfoService authInfoService;

	//目录查询菜单	
	@RequestMapping("/findAllAuth")
	public void findAllAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String parentId = "-1";
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("currentUserInfo");
		String authIds = roleInfoService.findAuthIdByRoleId(userInfo.getRoleId());
		List<Integer> authslist = StringUtil.stringToArry(authIds);

		JSONArray jsonArray = authInfoService.findAllAuth(parentId, authslist);
		ResponseUtil.write(response, jsonArray);

	}

	//角色授权
	@RequestMapping("/findAllAuthInfo")
	public void findAllAuthInfo(@RequestParam(value = "authIds", required = false) String authIds,
			HttpServletResponse response) throws Exception {

		String parentId = "-1";
		/* List<Integer> authList=StringUtil.stringToArry(authIds); */
		JSONArray jsonArray = authInfoService.findAllAuthInfo(parentId, authIds);
		ResponseUtil.write(response, jsonArray);

	}
//菜单查询
	@RequestMapping("/findAllAuthInfos")
	public void findAllAuthInfos(HttpServletResponse response) throws Exception {
		String parentId = "-1";
		JSONArray jsonArray = authInfoService.findAllAuthInfos(parentId);
		ResponseUtil.write(response, jsonArray);
	}

//菜单添加
	@RequestMapping("/addAuthInfo")
	public  void addAuthInfo(AuthInfo authInfo ,
			HttpServletResponse response) throws Exception {

		int result=authInfoService.addAuthInfo(authInfo);
		JSONObject  jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
			
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
		
	}
	
	//菜单修改
	@RequestMapping("/updateAuthInfo")
	public void updateAuthInfo(AuthInfo authInfo,HttpServletResponse response) throws Exception {		
		
		int result = authInfoService.updateAuthInfo(authInfo);
		JSONObject jsonObject = new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		
		ResponseUtil.write(response, jsonObject);
	}
	
	//菜单删除
	@RequestMapping("/deleteAuthInfo")
	public void deleteAuthInfo(@RequestParam(value="authId",required=false)String authId,HttpServletResponse response) throws Exception{
		int result=authInfoService.deleteAuthInfo(authId);
		JSONObject jsonObject = new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		
		ResponseUtil.write(response, jsonObject);
	}
	
	
	
	
	
}
