package com.byzx.model;

public class UserInfo {
		
private String	uid; //用户信息id
private String uname;//用户名称

private String password;//用户密码
private int userType;//用户类型
private int  roleId;//角色id
private String  userDescription;//用户描述
private int delflag;//用户删除状态
private String roleName;//角色名字

private String  currentTime;//用户创建时间

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
