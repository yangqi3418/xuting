package com.byzx.dao;

import java.util.List;

import com.byzx.model.WorkBookDetail;

public interface WorkBookDetailDao {

     public  List<WorkBookDetail> findAllWorkBookDetail(Integer wid);

	
	 public void addworkBookDetail(WorkBookDetail workBookDetail);

     public int deleteDetailByWid(Integer wid);


     public List<WorkBookDetail> getAllWorkBookDetailByWid(Integer wid);


     //×Ö±í
	


	public void updateWorkBookDetail(WorkBookDetail workBookDetail);


	public void deleteDetailByWbdId(Integer wbdId);;
}
