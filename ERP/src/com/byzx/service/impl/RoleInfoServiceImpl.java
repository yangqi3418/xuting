package com.byzx.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.RoleInfoDao;
import com.byzx.model.RoleInfo;
import com.byzx.service.RoleInfoService;
import com.byzx.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Service
public class RoleInfoServiceImpl implements RoleInfoService {

	@Autowired
	private RoleInfoDao roleInfoDao;
//���ݽ�ɫid��������Ȩ��
	@Override
	public String findAuthIdByRoleId(Integer roleId) {
		
		return roleInfoDao.findAuthIdByRoleId(roleId);
	}

	@Override
	public JSONArray roleComboxList() {
		
	List<RoleInfo>  roleInfoList=roleInfoDao.roleComboxList();
	
	JSONArray  jsonArray=new JSONArray();
	for(int i=0;i<roleInfoList.size();i++) {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("roleId", roleInfoList.get(i).getRoleId());
		jsonObject.put("roleName", roleInfoList.get(i).getRoleName());
		jsonArray.add(jsonObject);
		
	}
		return jsonArray;
	}
//ҳ����ѯ
	@Override
	public int findAllRoleCount(Map<String, Object> map) {
	
		return roleInfoDao.findAllRoleCount(map);
	}
//��ɫ��ѯ
	@Override
	public JSONArray findAllRole(Map<String, Object> map) {
	List<RoleInfo> roleInfolist=roleInfoDao.findAllRole(map);
	JSONArray jsonArray=new JSONArray();
	for(int i=0;i<roleInfolist.size();i++) {
		JSONObject jsonObject=new  JSONObject();
		jsonObject.put("roleId",roleInfolist.get(i) .getRoleId());
		jsonObject.put("roleName",roleInfolist.get(i).getRoleName());
		jsonObject.put("authIds",roleInfolist.get(i).getAuthIds());
		jsonObject.put("roleDescription",roleInfolist.get(i).getRoleDescription());
		jsonObject.put("delflag",roleInfolist.get(i).getDelflag());
		jsonObject.put("currentTime",roleInfolist.get(i).getCurrentTime());
		jsonArray.add(jsonObject);
		
		
	}
		return jsonArray;
	}
//��ɫ���
	@Override
	public int addRoleInfo(RoleInfo roleInfo) {
		roleInfo.setDelflag(0);
		roleInfo.setCurrentTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		return roleInfoDao.addRoleInfo(roleInfo);
	}
//��ɫ�޸�
	@Override
	public int updateRoleInfo(RoleInfo roleInfo) {
		
		return roleInfoDao.updateRoleInfo(roleInfo);
	}

	
	//��ɫɾ��
	@Override
	public int deleteRoleInfo(String ids) {
		
		String id[]=ids.split(",");
		int count=0;
		for(int i=0;i<id.length;i++) {
			int result=roleInfoDao.deleteRoleInfo(id[i]);
			if(result>0) {
				count++;
			}
		}
		return count;
	}
//���ݽ�ɫid�޸Ĳ˵����룬�ﵽ�޸�Ȩ�޵�Ŀ��
	@Override
	public int updateAuthIdByRoleId(Map<String, Object> map) {
		
		return roleInfoDao.updateAuthIdByRoleId(map);
	}

}
