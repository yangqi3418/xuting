package com.byzx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.InSupplierAreaDao;
import com.byzx.dao.InSuppliercategoryDao;
import com.byzx.dao.InSupplierlevelDao;
import com.byzx.dao.InSupplierlinkManDao;
import com.byzx.dao.InsupplierInfoDao;
import com.byzx.model.InSupplierArea;
import com.byzx.model.InSuppliercategory;
import com.byzx.model.InSupplierlevel;
import com.byzx.model.InSupplierlinkMan;
import com.byzx.model.Insupplierinfo;
import com.byzx.model.UserInfo;
import com.byzx.model.WorkBookDetail;
import com.byzx.service.InsupplierInfoServcie;
import com.byzx.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Service
public class InsupplierInfoServcieImpl implements InsupplierInfoServcie {






	@Autowired
	private InSupplierlinkManDao  inSupplierlinkManDao;

	@Autowired
	private InsupplierInfoDao   insupplierInfoDao;


	

	@Override
	public JSONArray findAllInsupplierinfo(Map<String, Object> map) {
		List<Insupplierinfo> ilList=insupplierInfoDao.findAllInsupplierinfo(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<ilList.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("insiid",ilList.get(i).getInsiid());
			jsonObject.put("insicode",ilList.get(i).getInsicode());
			jsonObject.put("insiname",ilList.get(i).getInsiname());
			jsonObject.put("inscid",ilList.get(i).getInscid());
			jsonObject.put("inslid",ilList.get(i).getInslid());
			jsonObject.put("insaid",ilList.get(i).getInsaid());
			jsonObject.put("insiaddress",ilList.get(i).getInsiaddress());
			jsonObject.put("insiphone",ilList.get(i).getInsiphone());
			jsonObject.put("insilicense",ilList.get(i).getInsilicense());
			jsonObject.put("insipermitlicense",ilList.get(i).getInsipermitlicense());
			jsonObject.put("insilegalman",ilList.get(i).getInsilegalman());
			jsonObject.put("insitaxnum",ilList.get(i).getInsitaxnum());
			jsonObject.put("insibank",ilList.get(i).getInsibank());
			jsonObject.put("insibankaccount",ilList.get(i).getInsibankaccount());
			jsonObject.put("remark",ilList.get(i).getRemark());
			jsonObject.put("state",ilList.get(i).getState());
			jsonObject.put("delflag",ilList.get(i).getDelflag());
			jsonObject.put("optid",ilList.get(i).getOptid());
			jsonObject.put("optname",ilList.get(i).getOptname());
			jsonObject.put("optdeptid",ilList.get(i).getOptdeptid());
			jsonObject.put("optorgid",ilList.get(i).getOptorgid());
			jsonObject.put("currdate",ilList.get(i).getCurrdate());

			List<InSupplierArea>  inalist=ilList.get(i).getInSupplierArea();
			JSONArray jsonArray1=new  JSONArray();
			for(int j=0;j<inalist.size();j++) {
				JSONObject jsonObject1=new JSONObject();
				jsonObject1.put("insaid",inalist.get(j).getInsaid());
				jsonObject1.put("insacode",inalist.get(j).getInsacode());
				jsonObject1.put("insaname",inalist.get(j).getInsaname());
				jsonObject1.put("remark",inalist.get(j).getRemark());
				jsonObject1.put("state",inalist.get(j).getState());
				jsonObject1.put("delflag",inalist.get(j).getDelflag());
				jsonObject1.put("optid",inalist.get(j).getOptid());
				jsonObject1.put("optname",inalist.get(j).getOptname());
				jsonObject1.put("optdeptid",inalist.get(j).getOptdeptid());
				jsonObject1.put("optorgid",inalist.get(j).getOptorgid());
				jsonObject1.put("currdate",inalist.get(j).getCurrdate());

				jsonArray1.add(jsonObject1);
			}
			
			
			
			  List<InSuppliercategory> inList=ilList.get(i).getInSuppliercategory();
			  JSONArray jsonArray2=new JSONArray(); 
			  for(int k=0;k<inList.size();k++) {
				  JSONObject jsonObject2=new JSONObject();
				  jsonObject2.put("inscid",inList.get(k).getInscid());
				  jsonObject2.put("insccode",inList.get(k).getInsccode());
				  jsonObject2.put("inscname",inList.get(k).getInscname());
				  jsonObject2.put("remark",inList.get(k).getRemark());
				  jsonObject2.put("state",inList.get(k).getState());
				  jsonObject2.put("delflag",inList.get(k).getDelflag());
				  jsonObject2.put("optid",inList.get(k).getOptid());
				  jsonObject2.put("optname",inList.get(k).getOptname());
				  jsonObject2.put("optdeptid",inList.get(k).getOptdeptid());
				  jsonObject2.put("optorgid",inList.get(k).getOptorgid());
				  jsonObject2.put("currdate",inList.get(k).getCurrdate());
				  jsonArray2.add(jsonObject2);
			  }
			  
			 
			  List<InSupplierlevel> inalistl=ilList.get(i).getInSupplierlevel(); 
			  JSONArray jsonArray3=new JSONArray(); 
			  for(int f=0;f<inalist.size();f++) { 
			  JSONObject jsonObject3=new JSONObject();
			  jsonObject3.put("inslid",inalistl.get(f).getInslid());
			  jsonObject3.put("inslcode",inalistl.get(f).getInslcode());
			  jsonObject3.put("inslname",inalistl.get(f).getInslname());
			  jsonObject3.put("remark",inalistl.get(f).getRemark());
			  jsonObject3.put("state",inalistl.get(f).getState());
			  jsonObject3.put("delflag",inalistl.get(f).getDelflag());
			  jsonObject3.put("optid",inalistl.get(f).getOptid());
			  jsonObject3.put("optname",inalistl.get(f).getOptname());
			  jsonObject3.put("optdeptid",inalistl.get(f).getOptdeptid());
			  jsonObject3.put("optorgid",inalistl.get(f).getOptorgid());
			  jsonObject3.put("currdate",inalistl.get(f).getCurrdate());
			  
			  jsonArray3.add(jsonObject3); 
			  }
			  
			  List<InSupplierlinkMan> inalistk=ilList.get(i).getInSupplierlinkMan();
			  JSONArray jsonArray4=new JSONArray(); 
			  if(inalistk!=null&&inalistk.size()>0) {
			    for(int a=0;a<inalist.size();a++) {
			  JSONObject jsonObject4=new JSONObject();
			  jsonObject4.put("inslmid",inalistk.get(a).getInslmid());
			  jsonObject4.put("inslmcode",inalistk.get(a).getInslmcode());
			  jsonObject4.put("insiid",inalistk.get(a).getInsiid());
			  jsonObject4.put("inslmname",inalistk.get(a).getInslmname());
			  jsonObject4.put("inslmphone",inalistk.get(a).getInslmphone());
			  jsonObject4.put("remark",inalistk.get(a).getRemark());
			  jsonObject4.put("state",inalistk.get(a).getState());
			  jsonObject4.put("delflag",inalistk.get(a).getDelflag());
			  jsonArray4.add(jsonObject4); 
			  } 
			  }
			  jsonObject.put("inSupplierArea", jsonArray1);
			  jsonObject.put("inSuppliercategory",jsonArray2);
			  jsonObject.put("inSupplierlevel", jsonArray3);
     		  jsonObject.put("inSupplierlinkMan", jsonArray4);
			  
			  jsonArray.add(jsonObject);

		}

		return jsonArray;
	}

	@Override
	public int findAllInsupplierCount(Map<String, Object> map) {
		int count=insupplierInfoDao.findAllInsupplierCount(map);
		return count;
	}

	
	
//主细表添加	
	@Override
	public int addInsupplierinfo(Insupplierinfo insupplierinfo, UserInfo userInfo) {
		
		insupplierinfo.setDelflag(0);  //添加状态
		insupplierinfo.setCurrdate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss")); //添加时间
		  
		insupplierinfo.setOptname(userInfo.getUname());//添加当前人
	
		  int count=insupplierInfoDao.addInsupplierinfo(insupplierinfo);    //添加主表
		  
		  int  maxInsupplierId=insupplierInfoDao.getMaxInsupplierInfoId();  
	  
          List<InSupplierlinkMan> inSupplierlinkMan=insupplierinfo.getInSupplierlinkMan();//添加字表供应商联系人
			  
			  
			  for(int i=0;i<inSupplierlinkMan.size();i++) {
				  
				  inSupplierlinkMan.get(i).setDelflag(0);
				  inSupplierlinkMan.get(i).setInsiid(maxInsupplierId);
				  inSupplierlinkMan.get(i).setState(1);
				  inSupplierlinkManDao.addInSupplierlinkMan(inSupplierlinkMan.get(i));
				
			  }
				
				  
		  
		return count;
	}

	
//主细表删除
	@Override
	public int deleteInsupplierinfoByInsiid(String insiid
			) {
		int result=insupplierInfoDao.deleteInsupplierinfoByInsiid(Integer.parseInt(insiid));
		
		inSupplierlinkManDao.deleteInSupplierlinkManByinslmid(Integer.parseInt(insiid));
		
		
		
		return result;
	}
//主细表修改
	@Override
	public int updateInsupplierinfo(Insupplierinfo insupplierinfo, UserInfo userInfo) {
		insupplierinfo.setCurrdate(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		int result=insupplierInfoDao.updateInsupplierinfo(insupplierinfo);
		List<InSupplierlinkMan> oldData=inSupplierlinkManDao.getAllInsupplierinfoDetailByInsiid(insupplierinfo.getInsiid());
		List<InSupplierlinkMan> newData=insupplierinfo.getInSupplierlinkMan();
		if(oldData!=null) {
			for(InSupplierlinkMan  oldWbd:oldData) {
			      boolean	isDelete=true;
				if(newData!=null) {
					for(InSupplierlinkMan  newWbd:newData) {
						if(newWbd.getInslmid()!=null&&newWbd.getInslmid().equals(oldWbd.getInslmid())) {
							isDelete=false;
						}
				}
		}
				if(isDelete) {
					inSupplierlinkManDao.deleteinSupplierlinkManByInslmid(oldWbd.getInslmid());
				}
		}
	}
		
		if(newData!=null) {
			for(InSupplierlinkMan  newWBD:newData) {
				
				if(newWBD.getInslmid()!=null) {
					
					inSupplierlinkManDao.updateInSupplierlinkManDetail(newWBD);
				}else {
					newWBD.setInsiid(insupplierinfo.getInsiid());
					newWBD.setDelflag(1);
					newWBD.setInslmname(userInfo.getUname());
					inSupplierlinkManDao.addInSupplierlinkMankDetail(newWBD);
				}
			}
		}
		return result;
	}
					
					
					
					
				
			
			
		
//验证名称唯一性
	@Override
	public String findIndInsinameNameExist(String insiname) {
		
		return insupplierInfoDao.findIndInsinameNameExist(insiname);
	}

	@Override
	public String findIndInsitaxnumNameExist(String insitaxnum) {
		
		return insupplierInfoDao.findIndInsitaxnumNameExist(insitaxnum);
	}

	@Override
	public String findIndInsiphoneNameExist(String insiphone) {
		
		return insupplierInfoDao.findIndInsiphoneNameExist(insiphone);
	}


}














