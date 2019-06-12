package com.byzx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.WorkBookDao;
import com.byzx.dao.WorkBookDetailDao;
import com.byzx.model.UserInfo;
import com.byzx.model.WorkBook;
import com.byzx.model.WorkBookDetail;
import com.byzx.service.WorkBookService;
import com.byzx.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class WorkBookServiceImpl implements WorkBookService{

	@Autowired
	private WorkBookDao workBookDao;
	
	@Autowired
	private  WorkBookDetailDao   workBookDetailDao;
	
	//查询主细表
	@Override
	public JSONArray findAllWorkBook(Map<String, Object> map) {
		List<WorkBook>  wklist=workBookDao.findAllWorkBook(map);
		JSONArray jsonArray=new  JSONArray();
		for(int i=0;i<wklist.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("wid",wklist.get(i).getWid());
			jsonObject.put("wname",wklist.get(i).getWname());
			jsonObject.put("delflag",wklist.get(i).getDelflag());
			jsonObject.put("remark",wklist.get(i).getRemark());
			jsonObject.put("currentTime",wklist.get(i).getCurrentTime());
			jsonObject.put("updateTime",wklist.get(i).getUpdateTime());
			jsonObject.put("optionPerson",wklist.get(i).getOptionPerson());

			
			 List<WorkBookDetail> wbklist=wklist.get(i).getWorkBookDetail(); 
			 JSONArray jsonArraywbd=new JSONArray(); 
			  for(int j=0;j<wbklist.size();j++) {
				  JSONObject   jsonObjectwbd=new JSONObject();
			  jsonObjectwbd.put("wbdId",wbklist.get(j).getWbdId());
			  jsonObjectwbd.put("wid",wbklist.get(j).getWid());
			  jsonObjectwbd.put("wbdName",wbklist.get(j).getWbdName());
			  jsonObjectwbd.put("remark",wbklist.get(j).getRemark());
			  jsonObjectwbd.put("delflag",wbklist.get(j).getDelflag());
			  jsonObjectwbd.put("currentTime",wbklist.get(j).getCurrentTime());
			  jsonObjectwbd.put("updateTime",wbklist.get(j).getUpdateTime());
			  jsonObjectwbd.put("optionPerson",wbklist.get(j).getOptionPerson());
			  
			  jsonArraywbd.add(jsonObjectwbd);
			  }
			  
			  jsonObject.put("workBookDetail", jsonArraywbd); 
			 
			  jsonArray.add(jsonObject);

		}
		return jsonArray;
	}


//分页查询
	@Override
	public int findAllWorkBookCount(Map<String, Object> map) {

		return workBookDao.findAllWorkBookCount(map);
	}



	//添加主系表
	  @Override 
	  public int addWorkBook(WorkBook workBook,UserInfo userInfo) {
	  workBook.setDelflag(1);  //添加状态
	  workBook.setCurrentTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss")); //添加时间
	  
	  workBook.setOptionPerson(userInfo.getUname());//添加当前人
	  int count=workBookDao.addWorkBook(workBook);    //添加主表
	  
	  int  maxWorkBookId=workBookDao.getMaxWorkBookId();  //添加字表
	  
	  List<WorkBookDetail> workBookDetail=workBook.getWorkBookDetail();
	  
	  
	  for(int i=0;i<workBookDetail.size();i++) {
		  workBookDetail.get(i).setCurrentTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		  workBookDetail.get(i).setDelflag(1);
		  workBookDetail.get(i).setOptionPerson(userInfo.getUname());
		  workBookDetail.get(i).setWid(maxWorkBookId);
		  workBookDetail.get(i).setUpdateTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		  workBookDetailDao.addworkBookDetail(workBookDetail.get(i));
		  
	  }
	return count;
	  
	  
	  }


	//主细表删除
	@Override
	public int deleteWorkBookAndDetailByWid(String wid) {
		workBookDetailDao.deleteDetailByWid(Integer.parseInt(wid));
		int result=workBookDao.deleteWorkBookAndDetailByWid(Integer.parseInt(wid));
		
		
		return result;
	}


//主细表修改
	@Override
	public int updateWorkBook( WorkBook workBook,UserInfo userInfo) {
		workBook.setUpdateTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		int result=workBookDao.updateWorkBook(workBook);
		List<WorkBookDetail> oldData=workBookDetailDao.getAllWorkBookDetailByWid(workBook.getWid());
		List<WorkBookDetail> newData=workBook.getWorkBookDetail();
	if(oldData!=null) {
		for(WorkBookDetail  oldWbd:oldData) {
		      boolean	isDelete=true;
			if(newData!=null) {
				for(WorkBookDetail  newWbd:newData) {
					if(newWbd.getWbdId()!=null&&newWbd.getWbdId().equals(oldWbd.getWbdId())) {
						isDelete=false;
					}
				}
			}
			if(isDelete) {
				workBookDetailDao.deleteDetailByWbdId(oldWbd.getWbdId());
			}
		}
		
		
	}
	
	if(newData!=null) {
		for(WorkBookDetail  newWBD:newData) {
			
			if(newWBD.getWbdId()!=null) {
				
				workBookDetailDao.updateWorkBookDetail(newWBD);
			}else {
				
				newWBD.setWid(workBook.getWid());
				newWBD.setCurrentTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				newWBD.setDelflag(1);
				newWBD.setOptionPerson(userInfo.getUname());
				
				workBookDetailDao.addworkBookDetail(newWBD);
				
			}
			
		}
		
		
	}
	
		return result;
	}



	@Override
	public String findworkBookwNameExist(String wname) {
		
	        return  workBookDao.findworkBookwNameExist(wname);
	}





	
	

}
