package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.byzx.model.InSuppliercategory;
import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.InSuppliercategoryService;
import com.byzx.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/supplier")
public class InSupplierCategoryController {
	
	@Autowired
	private InSuppliercategoryService  inSuppliercategoryService;
//查找供应商类别
	@RequestMapping("/findAllsupplier")
		public void findAllsupplier(@RequestParam(value="page",required=false)String page,
                @RequestParam(value="rows",required=false)String rows, 
                @RequestParam(value="inscname",required=false)String inscname,
                HttpServletResponse response ) throws Exception {

      PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
       Map<String,Object> map=new HashMap<String,Object>();
         map.put("pageBean", pageBean);
         map.put("inscname", inscname);
       JSONArray  jsonArray=inSuppliercategoryService.findAllSupplier(map);
       int total=inSuppliercategoryService.findAllSupplierCount(map);
    
        JSONObject jsonObject=new JSONObject();
           jsonObject.put("rows", jsonArray);
           jsonObject.put("total", total);
           
       ResponseUtil.write(response, jsonObject);

	}
	//添加供应商类别
	@RequestMapping("/addsupplier")
	public void addsupplier(InSuppliercategory inSuppliercategory,HttpServletRequest  request,HttpServletResponse response) throws Exception {
          HttpSession session=request.getSession();
		
		UserInfo userInfo=(UserInfo)session.getAttribute("currentUserInfo");
		
		int result=inSuppliercategoryService.addsupplier(inSuppliercategory,userInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg",true);
			
		}else {
			jsonObject.put("msg",false);
			
		}
		
		ResponseUtil.write(response, jsonObject);
		
		
	}
	
	//验证名称唯一性
		@RequestMapping("/findsupplierNameExist")
		public void findsupplierNameExist(@RequestParam(value="inscname",required=false)String inscname,
				HttpServletResponse  response) throws Exception {
			String inscnames=inSuppliercategoryService.findsupplierNameExist(inscname);
			
			JSONObject jsonObject=new JSONObject();
			
			if(inscnames!=null){
				jsonObject.put("msg", true);
				
			}else { jsonObject.put("msg", false);
		
			}
			ResponseUtil.write(response, jsonObject);
		}
			
		//验证编码唯一性
		@RequestMapping("/findInsccodeNameExist")
		public void findInsccodeNameExist(@RequestParam(value="insccode",required=false)String insccode,
				HttpServletResponse  response) throws Exception {
			String insccodes=inSuppliercategoryService.findInsccodeNameExist(insccode);
			
			JSONObject jsonObject=new JSONObject();
			
			if(insccodes!=null){
				jsonObject.put("msg", true);
					
			}else { jsonObject.put("msg", false);
			
			
			}
			ResponseUtil.write(response, jsonObject);
		}
				
		
		//类型修改
		@RequestMapping("/updatesupplier")
		public void updateUserInfo(InSuppliercategory inSuppliercategory,HttpServletResponse response) throws Exception {
			int result=inSuppliercategoryService.updateSupplier(inSuppliercategory);
			JSONObject  jsonObject=new JSONObject();
			if(result>0) {
				jsonObject.put("msg", true);
				
			}else {
				jsonObject.put("msg", false);
			}
			ResponseUtil.write(response, jsonObject);
			
			
		}
		
		//类型刪除
		@RequestMapping("/deletesupplier")
		public void deletesupplier(@RequestParam(value="ids",required=false)String ids,
				HttpServletResponse response) throws Exception {
			int result=inSuppliercategoryService.deletesupplier(ids);
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

	

