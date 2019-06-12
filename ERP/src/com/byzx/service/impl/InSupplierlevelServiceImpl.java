package com.byzx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.InSupplierlevelDao;
import com.byzx.model.InSupplierArea;
import com.byzx.model.InSupplierlevel;
import com.byzx.service.InSupplierlevelService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class InSupplierlevelServiceImpl implements InSupplierlevelService {
	
	
	@Autowired
	private InSupplierlevelDao  inSupplierlevelDao;
//–«º∂≤È—Ø
	@Override
	public JSONArray findInSupplierlevel(String inslid) {
		
		List<InSupplierlevel>  inalist=inSupplierlevelDao.findInSupplierlevel(Integer.parseInt(inslid));
		JSONArray jsonArray=new  JSONArray();
		for(int i=0;i<inalist.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("inslid",inalist.get(i).getInslid());
			jsonObject.put("inslcode",inalist.get(i).getInslcode());
			jsonObject.put("inslname",inalist.get(i).getInslname());
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
