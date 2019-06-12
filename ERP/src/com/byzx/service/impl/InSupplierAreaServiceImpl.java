package com.byzx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.InSupplierAreaDao;
import com.byzx.model.InSupplierArea;
import com.byzx.model.WorkBookDetail;
import com.byzx.service.InSupplierAreaService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class InSupplierAreaServiceImpl implements InSupplierAreaService {
	
	@Autowired
    private InSupplierAreaDao   inSupplierAreaDao;
	//≤È—Ø
	@Override
	public JSONArray findInSupplierArea(String insaid) {
		List<InSupplierArea>  inalist=inSupplierAreaDao.findInSupplierArea(Integer.parseInt(insaid));
		JSONArray jsonArray=new  JSONArray();
		for(int i=0;i<inalist.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("insaid",inalist.get(i).getInsaid());
			jsonObject.put("insacode",inalist.get(i).getInsacode());
			jsonObject.put("insaname",inalist.get(i).getInsaname());
			jsonObject.put("remark",inalist.get(i).getRemark());
			jsonObject.put("state",inalist.get(i).getState());
			jsonObject.put("delflag",inalist.get(i).getDelflag());
			jsonObject.put("optid",inalist.get(i).getOptid());
			jsonObject.put("optname",inalist.get(i).getOptname());
			jsonObject.put("optdeptid",inalist.get(i).getOptdeptid());
			jsonObject.put("optorgid",inalist.get(i).getOptorgid());
			jsonObject.put("currdate",inalist.get(i).getCurrdate());
			
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
		
	
	}

}
