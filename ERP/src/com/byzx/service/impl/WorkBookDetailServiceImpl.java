package com.byzx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.WorkBookDetailDao;
import com.byzx.model.WorkBookDetail;
import com.byzx.service.WorkBookDetailService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Service
public  class WorkBookDetailServiceImpl implements WorkBookDetailService{
	
	@Autowired
    private WorkBookDetailDao workBookDetailDao;
	//≤È—Ø
	@Override
	public JSONArray findAllWorkBookDetail(String wids) {
		int wid=Integer.parseInt(wids);
		List<WorkBookDetail>  wkDlist=workBookDetailDao.findAllWorkBookDetail(wid);
		JSONArray jsonArray=new  JSONArray();
		for(int i=0;i<wkDlist.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("wbdId",wkDlist.get(i).getWbdId());
			jsonObject.put("wid",wkDlist.get(i).getWid());
			jsonObject.put("wbdName",wkDlist.get(i).getWbdName());
			jsonObject.put("remark",wkDlist.get(i).getRemark());
			jsonObject.put("delflag",wkDlist.get(i).getDelflag());
			jsonObject.put("currentTime",wkDlist.get(i).getCurrentTime());
			jsonObject.put("updateTime",wkDlist.get(i).getUpdateTime());
			jsonObject.put("optionPerson",wkDlist.get(i).getOptionPerson());
		
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
	}



}
