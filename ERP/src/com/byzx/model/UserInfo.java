package com.byzx.model;

public class UserInfo {
		
private String	uid; //�û���Ϣid
private String uname;//�û�����

private String password;//�û�����
private int userType;//�û�����
private int  roleId;//��ɫid
private String  userDescription;//�û�����
private int delflag;//�û�ɾ��״̬
private String roleName;//��ɫ����

private String  currentTime;//�û�����ʱ��

public String getUid() {
	return uid;
}

public void setUid(String uid) {
	this.uid = uid;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getUserType() {
	return userType;
}

public void setUserType(int userType) {
	this.userType = userType;
}

public int getRoleId() {
	return roleId;
}

public void setRoleId(int roleId) {
	this.roleId = roleId;
}

public String getUserDescription() {
	return userDescription;
}

public void setUserDescription(String userDescription) {
	this.userDescription = userDescription;
}

public int getDelflag() {
	return delflag;
}

public void setDelflag(int delflag) {
	this.delflag = delflag;
}

public String getCurrentTime() {
	return currentTime;
}

public void setCurrentTime(String currentTime) {
	this.currentTime = currentTime;
}

public String getRoleName() {
	return roleName;
}

public void setRoleName(String roleName) {
	this.roleName = roleName;
}


}
