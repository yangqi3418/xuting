package com.byzx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.InDeliveryWayDao;
import com.byzx.model.InDeliveryWay;
import com.byzx.model.UserInfo;
import com.byzx.service.InDeliveryWayService;
import com.byzx.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class InDeliveryWayServiceImpl implements InDeliveryWayService {
	
	@Autowired
   private   InDeliveryWayDao  inDeliveryWayDao;
	
	
	//������ʽ��Ѷ
	@Override
	public JSONArray findAllInDeliveryWay(Map<String, Object> map) {
		
		List<InDeliveryWay> idvList=inDeliveryWayDao.findAllInDeliveryWay(map);
		
		JSONArray jsonArray=new JSONArray();
		
		for(int i=0;i<idvList.size();i++) {
			
			JSONObject jsonObject=new JSONObject();
			
			jsonObject.put("indwid",idvList.get(i).getIndwid());
			jsonObject.put("indwcode",idvList.get(i).getIndwcode());
			jsonObject.put("indwname",idvList.get(i).getIndwname());
			jsonObject.put("remark",idvList.get(i).getRemark());
			jsonObject.put("state",idvList.get(i).getState());
			jsonObject.put("delflag",idvList.get(i).getDelflag());
			jsonObject.put("optid",idvList.get(i).getOptid());
			jsonObject.put("optname",idvList.get(i).getOptname());
			jsonObject.put("optdeptid",idvList.get(i).getOptdeptid());
			jsonObject.put("optorgid",idvList.get(i).getOptorgid());
			jsonObject.put("currdate",idvList.get(i).getCurrdate());
			jsonArray.add(jsonObject);
		}
		    return jsonArray;
	}
	 //������ʽ��ҳ����
	@Override
	public int findAllInDeliveryWayCount(Map<String, Object> map) {
		int  count=inDeliveryWayDao.findAllInDeliveryWayCount(map);
		return count;
	}
	 //������ʽ���
	@Override
	public int addInDeliveryWay(InDeliveryWay inDeliveryWay, UserInfo userInfo) {
	
		inDeliveryWay.setDelflag(0);
		inDeliveryWay.setCurrdate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		inDeliveryWay.setState(1);
		inDeliveryWay.setIndwname(userInfo.getUname());
		
		return inDeliveryWayDao.addInDeliveryWay(inDeliveryWay);
	}
	 //������ʽ�޸�
	@Override
	public int updateInDeliveryWay(InDeliveryWay inDeliveryWay) {
		
		return inDeliveryWayDao.updateInDeliveryWay(inDeliveryWay);
	}
	 //��������Ψһ��
	@Override
	public String findIndwcodeNameExist(String indwcode) {
		
		return inDeliveryWayDao.findIndwcodeNameExist(indwcode);
	}
	//��������Ψһ��
	@Override
	public String findIndwnameNameExist(String indwname) {
		
		return inDeliveryWayDao.findIndwnameNameExist(indwname);
	}
	
	//��������ɾ��
	@Override
	public int deleteInDeliveryWay(String ids) {
		
		return inDeliveryWayDao.deleteInDeliveryWay(ids);
	}

}
