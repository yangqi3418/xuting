package com.byzx.dao;

import java.util.List;

import com.byzx.model.InSupplierlevel;

public interface InSupplierlevelDao {
//�����Ǽ�
	public List<InSupplierlevel> findInSupplierlevel(int insiid);
//����Ǽ�
	
	public void addInSupplierlevel(InSupplierlevel inSupplierlevel);
//ɾ���ֱ�
	public void deleteInSupplierlevelByinslid(Integer inslid);



}
