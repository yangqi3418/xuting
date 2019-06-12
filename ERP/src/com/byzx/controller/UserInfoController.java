package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.UserInfoService;
import com.byzx.util.Md5;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;//ע���û�service��

	@RequestMapping("/login")
	//������� @RequestParam(value = "imageCode", required = false)//������֤
	public String login(UserInfo userInfo, @RequestParam(value = "imageCode", required = false) String imageCode,
			HttpServletRequest request) {
		HttpSession session = request.getSession();//��ȡsession

		UserInfo currentUserInfo = (UserInfo) session.getAttribute("currentUserInfo");//ͨ��session��ȡǰ�����������

		String sRand = (String) session.getAttribute("sRand");//��ȡǰ�˴���������֤��

		if (currentUserInfo!=null&&imageCode==null) {//�ж��û�������֤���Ƿ�Ϊ��
			      return "main";
		} else {
			// session��֤��Ϊ��ʱ
			
			if (imageCode == null) {
				return "redirect:/login.jsp";
			} else {
				// ������֤�벻��ȷʱ
				if (!imageCode.equals(sRand)) {
					return "redirect:/login.jsp?error=1&uname=" + userInfo.getUname() + "&password="
							+ Md5.JM(userInfo.getPassword()) + "";

				} else {
					
				//�û���¼
			             currentUserInfo=userInfoService.login(userInfo);
					
					if (currentUserInfo==null) {//�ж��û��Ƿ�Ϊ��
						return "redirect:/login.jsp?error=2&uname=" + userInfo.getUname() + "&password="
								+ Md5.JM(userInfo.getPassword()) + "";

					}else {
						// ���˺ź�����ƥ��ʱ
						session = request.getSession();
						//���û���������ƥ��ʱ�����û���������Ϊsession������
						session.setAttribute("currentUserInfo", currentUserInfo);
						return "main";//���ص�����ҳ��
					}
				}
				}
			}

		}
	
	
	@RequestMapping("/findAllUserInfos")//�û�����չʾ����
	public  void findAllUserInfos(@RequestParam(value="s_roleId",required=false)String s_roleId,//ע���û������б�����Ĳ���
			                     @RequestParam(value="s_userName",required=false)String s_userName,
			                     @RequestParam(value="page",required=false)String page,//��ǰҳ
			                     @RequestParam(value="rows",required=false)String rows,//��ʾһҳչʾ��������
			HttpServletResponse response) throws Exception {
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));//����һ��pagebean����page��rows��Ϊ������װ������
		UserInfo userInfo=new UserInfo();//����һ��UserInfo
		if(StringUtil.isNotEmpty(s_roleId)) {//�ж�ҳ��չʾ�Ĳ����Ƿ�Ϊ��
			userInfo.setRoleId(Integer.parseInt(s_roleId));//��ҳ��չʾ�Ĳ�������UserInfo
		}
		if(StringUtil.isNotEmpty(s_userName)) {
			userInfo.setUname(s_userName);
		}
	
		Map<String,Object>  map=new  HashMap<String,Object>();//����һ��map����
		map.put("pageBean",pageBean);//����װ�в�����pagebean�ŵ�������
		map.put("userInfo", userInfo);//����װ�в�����userinfo�ŵ�������
		int count=userInfoService.findAllUserInfoCount(map);//����sevice�㷽������map���Ϸŵ�service�ﲢ������count����
        JSONArray jsonArray=userInfoService.findAllUserInfos(map);//ͬ����map�ŵ�һ��json������
        JSONObject jsonObject=new JSONObject();//����һ��jsonobject
        jsonObject.put("total", count);//��count�ŵ�jsonobject��
        jsonObject.put("rows", jsonArray);//��jsonArray�ŵ�jsonobject��
		ResponseUtil.write(response, jsonObject);//�����ķ�ʽд����
	}
	//�˳���ǰ�Ñ�
	@RequestMapping("/exitCurrentUserInfo")
	public void exitCurrentUserInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		HttpSession  session=request.getSession();//��ȡsession
	     session.removeAttribute("currentUserInfo");//�Ƴ�session�е�ǰ�û�����Ϣ
	     JSONObject jsonObject=new JSONObject();//����һ��json����
	     jsonObject.put("msg", "�˳��ɹ�!");//����Ҫ���ص���Ϣ�ŵ�json����
		ResponseUtil.write(response, jsonObject);//�����������ķ�ʽд����
	}
	
	
	
	//��֤�û�Ψһ��
	@RequestMapping("/findUserNameExist")
	public void findUserNameExist(@RequestParam(value="uname",required=false)String uanme,HttpServletResponse  response) throws Exception {
			
			                                    
		
		String username=userInfoService.findUserNameExist(uanme);
		
		JSONObject jsonObject=new JSONObject();
		
		if(username!=null){
			jsonObject.put("msg", true);
			
		}else { jsonObject.put("msg", false);
		}


	ResponseUtil.write(response, jsonObject);
	}
		//�Ñ����	
		@RequestMapping("/addUserInfo")
		public void AddUserInfo(UserInfo userInfo,HttpServletResponse response) throws Exception {
			int result=userInfoService.addUserInfo(userInfo);
			JSONObject  jsonObject=new JSONObject();
			if(result>0) {
				jsonObject.put("msg", true);
				
			}else {
				jsonObject.put("msg", false);
			}
			ResponseUtil.write(response, jsonObject);
			
			
		}
		
		//�Ñ��޸�
		@RequestMapping("/updateUserInfo")
		public void updateUserInfo(UserInfo userInfo,HttpServletResponse response) throws Exception {
			int result=userInfoService.updateUserInfo(userInfo);
			JSONObject  jsonObject=new JSONObject();
			if(result>0) {
				jsonObject.put("msg", true);
				
			}else {
				jsonObject.put("msg", false);
			}
			ResponseUtil.write(response, jsonObject);
			
			
		}
		//�Ñ�h��
	@RequestMapping("/deleteUserInfo")
	public void deleteUserInfo(@RequestParam(value="ids",required=false)String ids,
			HttpServletResponse response) throws Exception {
		int result=userInfoService.deleteUserInfo(ids);
		JSONObject  jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count", result);
			
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
		
		
	}
}
	


