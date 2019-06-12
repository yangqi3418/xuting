package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.byzx.model.PageBean;
import com.byzx.model.RoleInfo;
import com.byzx.model.UserInfo;
import com.byzx.service.RoleInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/roleInfo")
public class RoleInfoController {
	
	
	@Autowired
	private RoleInfoService roleInfoService;
	//��ɫѡ��������
	@RequestMapping("/roleComboxList")
	public void roleComboxList(HttpServletResponse response) throws Exception {
		
		JSONArray jsonArray=roleInfoService.roleComboxList();
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("roleName", "--Ո�x��--");
		jsonObject.put("roleId", "");
		
		jsonArray.add(jsonObject);
		ResponseUtil.write(response, jsonArray);
		
		
	}
	//�û���������ѯ��ɫ
	@RequestMapping("/findAllRole")
	public void findAllRole(@RequestParam(value="s_roleName",required=false)String s_roleName,
			                @RequestParam(value="page",required=false)String page,
                             @RequestParam(value="rows",required=false)String rows,
			HttpServletResponse response ) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		map.put("pageBean", pageBean);
		if(StringUtil.isNotEmpty(s_roleName)) {
			map.put("s_roleName", s_roleName);
		}
		
		JSONArray jsonArray=roleInfoService.findAllRole(map);
		int total=roleInfoService.findAllRoleCount(map);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	
		
	}
	//��ӽ�ɫ
	@RequestMapping("/addRoleInfo")
	public void AddUserInfo(RoleInfo roleInfo,HttpServletResponse response) throws Exception {
		int result=roleInfoService.addRoleInfo(roleInfo);
		JSONObject  jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
			
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
		
		
	}
		//�޸Ľ�ɫ
@RequestMapping("/updateRoleInfo")
public void updateRoleInfo(RoleInfo roleInfo,HttpServletResponse response) throws Exception {
	int result=roleInfoService.updateRoleInfo(roleInfo);
	JSONObject  jsonObject=new JSONObject();
	if(result>0) {
		jsonObject.put("msg", true);
		
	}else {
		jsonObject.put("msg", false);
	}
	ResponseUtil.write(response, jsonObject);
	
	
}

//ɾ����ɫ
@RequestMapping("/deleteRoleInfo")
public void deleteUserInfo(@RequestParam(value="ids",required=false)String ids,
		HttpServletResponse response) throws Exception {
	int result=roleInfoService.deleteRoleInfo(ids);
	JSONObject  jsonObject=new JSONObject();
	if(result>0) {
		jsonObject.put("msg", true);
		jsonObject.put("count", result);
		
	}else {
		jsonObject.put("msg", false);
	}
	ResponseUtil.write(response, jsonObject);
	
	
}
	
//���ݽ�ɫid�޸Ĳ˵����룬�ﵽ�޸�Ȩ�޵�Ŀ��
@RequestMapping("/updateAuthIdByRoleId")
public void updateAuthIdByRoleId(@RequestParam(value="authIds",required=false)String authIds,
		                        @RequestParam(value="roleId",required=false)String roleId,
		HttpServletResponse response) throws Exception {
	Map<String,Object> map=new HashMap<String,Object>();
	map.put("authIds", authIds);
	map.put("roleId", Integer.parseInt(roleId));
	int result=roleInfoService.updateAuthIdByRoleId(map);
	JSONObject  jsonObject=new JSONObject();
	if(result>0) {
		jsonObject.put("msg", true);
		
	}else {
		jsonObject.put("msg", false);
	}
	ResponseUtil.write(response, jsonObject);
	
	
}



	
}
