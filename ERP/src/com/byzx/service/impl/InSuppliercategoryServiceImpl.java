package com.byzx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.InSuppliercategoryDao;
import com.byzx.model.InSuppliercategory;
import com.byzx.model.UserInfo;
import com.byzx.service.InSuppliercategoryService;
import com.byzx.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class InSuppliercategoryServiceImpl implements InSuppliercategoryService {
	
	@Autowired
	private  InSuppliercategoryDao  inSuppliercategoryDao;
	


	@Override
	public JSONArray findAllSupplier(Map<String, Object> map) {
		List<InSuppliercategory>  inList=inSuppliercategoryDao.findAllSupplier(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<inList.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("inscid",inList.get(i).getInscid());
			jsonObject.put("insccode",inList.get(i).getInsccode());
			jsonObject.put("inscname",inList.get(i).getInscname());
			jsonObject.put("remark",inList.get(i).getRemark());
			jsonObject.put("state",inList.get(i).getState());
			jsonObject.put("delflag",inList.get(i).getDelflag());
			jsonObject.put("optid",inList.get(i).getOptid());
			jsonObject.put("optname",inList.get(i).getOptname());
			jsonObject.put("optdeptid",inList.get(i).getOptdeptid());
			jsonObject.put("optorgid",inList.get(i).getOptorgid());
			jsonObject.put("currdate",inList.get(i).getCurrdate());
			jsonArray.add(jsonObject);
			
			
		}
		
		return jsonArray;
	}

	@Override
	public int findAllSupplierCount(Map<String, Object> map) {
		int  count=inSuppliercategoryDao.findAllSupplierCount(map);
		return count;
	}

	@Override
	public int addsupplier(InSuppliercategory inSuppliercategory,UserInfo UserInfo) {
		inSuppliercategory.setDelflag(0);
		inSuppliercategory.setCurrdate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		inSuppliercategory.setState(1);
		inSuppliercategory.setOptname(UserInfo.getUname());
		
		return inSuppliercategoryDao.addsupplier(inSuppliercategory);
	}
   //编码验证
	@Override
	public String findInsccodeNameExist(String insccode) {
	
		return inSuppliercategoryDao.findInsccodeNameExist(insccode);
	}
	//类型名称验证
	@Override
	public String findsupplierNameExist(String inscname) {
		
		return inSuppliercategoryDao.findsupplierNameExist(inscname);
	}
//类型修改
	@Override
	public int updateSupplier(InSuppliercategory inSuppliercategory) {
		
		return inSuppliercategoryDao.updateSupplier(inSuppliercategory);
	}

	@Override
	public int deletesupplier(String ids) {
		String id[]=ids.split(",");
		int count=0;
		for(int i=0;i<id.length;i++) {
			int result=inSuppliercategoryDao.deletesupplier(id[i]);
			if(result>0) {
				count++;
			}
		}
		return count;
	}


}
