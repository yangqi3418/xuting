package com.byzx.dao;

import java.util.List;

import com.byzx.model.InSupplierlevel;

public interface InSupplierlevelDao {
//查找星级
	public List<InSupplierlevel> findInSupplierlevel(int insiid);
//添加星级
	
	public void addInSupplierlevel(InSupplierlevel inSupplierlevel);
//删除字表
	public void deleteInSupplierlevelByinslid(Integer inslid);



}
