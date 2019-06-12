package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.WorkBook;

public interface WorkBookDao {

	
	
	public List<WorkBook> findAllWorkBook(Map map);
	
	public int  findAllWorkBookCount(Map map );

	

	public int getMaxWorkBookId();

	public int addWorkBook(WorkBook workBook);

	public int deleteWorkBookAndDetailByWid(Integer wid);



	public int updateWorkBook(WorkBook workBook);
	
//名称唯一性验证
	public String findworkBookwNameExist(String wnames);

	

	
}
