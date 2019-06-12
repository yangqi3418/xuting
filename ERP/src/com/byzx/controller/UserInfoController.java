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
	private UserInfoService userInfoService;//注解用户service层

	@RequestMapping("/login")
	//请求参数 @RequestParam(value = "imageCode", required = false)//开启验证
	public String login(UserInfo userInfo, @RequestParam(value = "imageCode", required = false) String imageCode,
			HttpServletRequest request) {
		HttpSession session = request.getSession();//获取session

		UserInfo currentUserInfo = (UserInfo) session.getAttribute("currentUserInfo");//通过session获取前端输入的属性

		String sRand = (String) session.getAttribute("sRand");//获取前端传过来的验证码

		if (currentUserInfo!=null&&imageCode==null) {//判断用户名和验证码是否为空
			      return "main";
		} else {
			// session验证码为空时
			
			if (imageCode == null) {
				return "redirect:/login.jsp";
			} else {
				// 输入验证码不正确时
				if (!imageCode.equals(sRand)) {
					return "redirect:/login.jsp?error=1&uname=" + userInfo.getUname() + "&password="
							+ Md5.JM(userInfo.getPassword()) + "";

				} else {
					
				//用户登录
			             currentUserInfo=userInfoService.login(userInfo);
					
					if (currentUserInfo==null) {//判断用户是否为空
						return "redirect:/login.jsp?error=2&uname=" + userInfo.getUname() + "&password="
								+ Md5.JM(userInfo.getPassword()) + "";

					}else {
						// 当账号和密码匹配时
						session = request.getSession();
						//当用户名和密码匹配时，将用户数据设置为session的属性
						session.setAttribute("currentUserInfo", currentUserInfo);
						return "main";//返回到详情页面
					}
				}
				}
			}

		}
	
	
	@RequestMapping("/findAllUserInfos")//用户管理展示界面
	public  void findAllUserInfos(@RequestParam(value="s_roleId",required=false)String s_roleId,//注入用户界面列表请求的参数
			                     @RequestParam(value="s_userName",required=false)String s_userName,
			                     @RequestParam(value="page",required=false)String page,//当前页
			                     @RequestParam(value="rows",required=false)String rows,//显示一页展示几条数据
			HttpServletResponse response) throws Exception {
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));//创建一个pagebean，将page和rows作为参数封装到里面
		UserInfo userInfo=new UserInfo();//创建一个UserInfo
		if(StringUtil.isNotEmpty(s_roleId)) {//判断页面展示的参数是否为空
			userInfo.setRoleId(Integer.parseInt(s_roleId));//将页面展示的参数传给UserInfo
		}
		if(StringUtil.isNotEmpty(s_userName)) {
			userInfo.setUname(s_userName);
		}
	
		Map<String,Object>  map=new  HashMap<String,Object>();//创建一个map集合
		map.put("pageBean",pageBean);//将封装有参数的pagebean放到集合里
		map.put("userInfo", userInfo);//将封装有参数的userinfo放到集合里
		int count=userInfoService.findAllUserInfoCount(map);//调用sevice层方法，将map集合放到service里并用行数count接收
        JSONArray jsonArray=userInfoService.findAllUserInfos(map);//同样将map放到一个json数组里
        JSONObject jsonObject=new JSONObject();//创建一个jsonobject
        jsonObject.put("total", count);//将count放到jsonobject里
        jsonObject.put("rows", jsonArray);//将jsonArray放到jsonobject里
		ResponseUtil.write(response, jsonObject);//用流的方式写出来
	}
	//退出當前用戶
	@RequestMapping("/exitCurrentUserInfo")
	public void exitCurrentUserInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		HttpSession  session=request.getSession();//获取session
	     session.removeAttribute("currentUserInfo");//移除session中当前用户的信息
	     JSONObject jsonObject=new JSONObject();//创建一个json对象
	     jsonObject.put("msg", "退出成功!");//将需要返回的信息放到json对象
		ResponseUtil.write(response, jsonObject);//将对象用流的方式写出来
	}
	
	
	
	//验证用户唯一性
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
		//用戶添加	
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
		
		//用戶修改
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
		//用戶刪除
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
	


