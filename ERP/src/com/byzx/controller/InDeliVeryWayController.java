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

import com.byzx.model.InDeliveryWay;
import com.byzx.model.InSuppliercategory;
import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.InDeliveryWayService;
import com.byzx.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/inDeliveryWay")
public class InDeliVeryWayController {
	
	@Autowired
	private InDeliveryWayService inDeliveryWayService;

    @RequestMapping("/findAllInDeliveryWay")
    public   void findAllInDeliveryWay(@RequestParam(value="page",required=false)String page,
                                       @RequestParam(value="rows",required=false)String rows, 
                              @RequestParam(value="indwname",required=false)String indwname,
                              HttpServletResponse response) throws Exception {
	    PageBean pagebean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
	    Map<String,Object> map=new HashMap<String,Object>();
	    map.put("pagebean", pagebean);
	    map.put("indwname", indwname);
	
	    JSONArray jsonArray=inDeliveryWayService.findAllInDeliveryWay(map);
	    
	    int total=inDeliveryWayService.findAllInDeliveryWayCount(map);
	
	    JSONObject jsonObject=new JSONObject();
        jsonObject.put("rows", jsonArray);
        jsonObject.put("total", total);
        
    ResponseUtil.write(response, jsonObject);

}
    //交付方式添加
    @RequestMapping("/addInDeliveryWay")
    public void addInDeliveryWay(InDeliveryWay inDeliveryWay,HttpServletRequest  request,HttpServletResponse response) throws Exception {
        HttpSession session=request.getSession();
		
		UserInfo userInfo=(UserInfo)session.getAttribute("currentUserInfo");
		
		int result=inDeliveryWayService.addInDeliveryWay(inDeliveryWay,userInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg",true);
			
		}else {
			jsonObject.put("msg",false);
			
		}
		
		ResponseUtil.write(response, jsonObject);
		
		
	}
    
  //验证名称唯一性
  		@RequestMapping("/findIndwcodeNameExist")
  		public void findIndwcodeNameExist(@RequestParam(value="indwcode",required=false)String indwcode,
  				HttpServletResponse  response) throws Exception {
  			String inscnames=inDeliveryWayService.findIndwcodeNameExist(indwcode);
  			
  			JSONObject jsonObject=new JSONObject();
  			
  			if(inscnames!=null){
  				jsonObject.put("msg", true);
  				
  			}else { jsonObject.put("msg", false);
  		
  			}
  			ResponseUtil.write(response, jsonObject);
  		}
  			
  		//验证编码唯一性
  		@RequestMapping("/findIndwnameNameExist")
  		public void findIndwnameNameExist(@RequestParam(value="indwname",required=false)String indwname,
  				HttpServletResponse  response) throws Exception {
  			String insccodes=inDeliveryWayService.findIndwnameNameExist(indwname);
  			
  			JSONObject jsonObject=new JSONObject();
  			
  			if(insccodes!=null){
  				jsonObject.put("msg", true);
  					
  			}else { jsonObject.put("msg", false);
  			
  			
  			}
  			ResponseUtil.write(response, jsonObject);
  		}
  			
    
    
    
    //交付类型修改
    @RequestMapping("/updateInDeliveryWay")
    public void updateInDeliveryWay(InDeliveryWay inDeliveryWay,HttpServletResponse response) throws Exception {
		int result=inDeliveryWayService.updateInDeliveryWay(inDeliveryWay);
		JSONObject  jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
			
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
		
		
	}
    //交付类型删除
    @RequestMapping("/deleteInDeliveryWay")
    public void deleteInDeliveryWay(@RequestParam(value="ids",required=false)String ids,
			HttpServletResponse response) throws Exception {
		int result=inDeliveryWayService.deleteInDeliveryWay(ids);
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
