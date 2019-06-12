package com.byzx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.InSupplierlinkManDao;
import com.byzx.model.InSupplierlinkMan;
import com.byzx.service.InSupplierlinkManService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class InSupplierlinkManServiceImpl implements InSupplierlinkManService {
	
	
	@Autowired
private InSupplierlinkManDao  inSupplierlinkManDao;
	
	
	//查询供应商联系人
	@Override
	public JSONArray findInSupplierlinkMan(String insiid) {
		
		List<InSupplierlinkMan>  inalist=inSupplierlinkManDao.findInSupplierlinkMan(Integer.parseInt(insiid));
		JSONArray jsonArray=new  JSONArray();
		for(int i=0;i<inalist.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("inslmid",inalist.get(i).getInslmid());
			jsonObject.put("inslmcode",inalist.get(i).getInslmcode());
			jsonObject.put("insiid",inalist.get(i).getInsiid());
			jsonObject.put("inslmname",inalist.get(i).getInslmname());
			jsonObject.put("inslmphone",inalist.get(i).getInslmphone());
			jsonObject.put("remark",inalist.get(i).getRemark());
			jsonObject.put("state",inalist.get(i).getState());
			jsonObject.put("delflag",inalist.get(i).getDelflag());
		
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
		
	
	}

}
