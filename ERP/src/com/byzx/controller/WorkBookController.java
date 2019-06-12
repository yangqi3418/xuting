package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.model.WorkBook;
import com.byzx.service.WorkBookService;
import com.byzx.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/workBook")
public class WorkBookController {
	
	@Autowired
	private WorkBookService  workBookService;
	

	@RequestMapping("/findAllWorkBook")
	public void findAllWorkBook(@RequestParam(value="page",required=false)String page,
			                    @RequestParam(value="rows",required=false)String rows, 
			                    @RequestParam(value="searchValue",required=false)String searchValue,
			HttpServletResponse response ) throws Exception {
			
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("pageBean", pageBean);
		map.put("searchValue", searchValue);
		JSONArray  jsonArray=workBookService.findAllWorkBook(map);
		int total=workBookService.findAllWorkBookCount(map);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
		
		
		
	}
	
	
	//主细表添加
	@RequestMapping("/addWorkBook")
	public void addWorkBook(@RequestBody WorkBook workBook ,HttpServletRequest request ,HttpServletResponse response ) throws Exception {
		HttpSession session=request.getSession();
		
		UserInfo userInfo=(UserInfo)session.getAttribute("currentUserInfo");
		int result=workBookService.addWorkBook(workBook,userInfo);
		JSONObject  jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
		
		
	}
	//主细表删除
	@RequestMapping("/deleteWorkBookAndDetailByWid")
	public void deleteWorkBookAndDetailByWid(@RequestParam(value="wid",required=false)String wid,
	                                       HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		int result=workBookService.deleteWorkBookAndDetailByWid(wid);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
			
			
		}else {
			jsonObject.put("msg", false);
		}
		
		ResponseUtil.write(response, jsonObject);
		
	}
	//主细表
	@RequestMapping("/updateWorkBook")
	public void updateWorkBook(@RequestBody WorkBook workBook, HttpServletRequest request,HttpServletResponse response)
			throws Exception {
       HttpSession session=request.getSession();
		
		UserInfo userInfo=(UserInfo)session.getAttribute("currentUserInfo");
		int result = workBookService.updateWorkBook(workBook,userInfo);
		JSONObject jsonObject = new JSONObject();
		if (result > 0) {
			jsonObject.put("msg", true);

		} else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);

	}
	
		//验证名称唯一性
		@RequestMapping("/findworkBookwNameExist")
		public void findworkBookwNameExist(@RequestParam(value="wname",required=false)String wname,
				HttpServletResponse  response) throws Exception {
			String wnames=workBookService.findworkBookwNameExist(wname);
			
			JSONObject jsonObject=new JSONObject();
			
			if(wnames!=null){
				jsonObject.put("msg", true);
					
			}else { jsonObject.put("msg", false);
			
			
			}
			ResponseUtil.write(response, jsonObject);
		}
			
	
	
	
	
}
