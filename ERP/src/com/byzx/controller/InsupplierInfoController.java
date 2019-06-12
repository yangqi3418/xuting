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

import com.byzx.model.Insupplierinfo;
import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.model.WorkBook;
import com.byzx.service.InsupplierInfoServcie;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/insupplierinfo")
public class InsupplierInfoController {

	@Autowired
	private InsupplierInfoServcie  insupplierInfoServcie;
	//查询供应商信息
	@RequestMapping("/findAllInsupplierinfo")
	public void findAllInsupplierinfo(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "searchValue", required = false) String searchValue, HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isNotEmpty(searchValue)) {
			map.put("searchValue", searchValue);
		}
		map.put("pageBean", pageBean);
		JSONArray jsonArray = insupplierInfoServcie.findAllInsupplierinfo(map);
		int total = insupplierInfoServcie.findAllInsupplierCount(map);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);

	}

	//主细表添加
	@RequestMapping("/addInsupplierinfo")
	public void addInsupplierinfo(@RequestBody Insupplierinfo insupplierinfo ,HttpServletRequest request ,HttpServletResponse response ) throws Exception {
		HttpSession session=request.getSession();

		UserInfo userInfo=(UserInfo)session.getAttribute("currentUserInfo");
		int result=insupplierInfoServcie.addInsupplierinfo(insupplierinfo,userInfo);
		JSONObject  jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);

		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);


	}

	
	
	//主细表删除
	@RequestMapping("/deleteInsupplierinfoByInsiid")
	public void deleteInsupplierinfoByInsiid(@RequestParam(value="insiid",required=false)String insiid,
											
	              HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		int result=insupplierInfoServcie.deleteInsupplierinfoByInsiid(insiid);
				
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
			
			
		}else {
			jsonObject.put("msg", false);
		}
		
		ResponseUtil.write(response, jsonObject);
		
	}
	
	@RequestMapping("/updateInsupplierinfo")
	public void updateInsupplierinfo(@RequestBody Insupplierinfo Insupplierinfo, HttpServletRequest request,HttpServletResponse response)
			throws Exception {
       HttpSession session=request.getSession();
		
		UserInfo userInfo=(UserInfo)session.getAttribute("currentUserInfo");
		int result = insupplierInfoServcie.updateInsupplierinfo(Insupplierinfo,userInfo);
		JSONObject jsonObject = new JSONObject();
		if (result > 0) {
			jsonObject.put("msg", true);

		} else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);

	}
	//验证名称唯一性
	@RequestMapping("/findIndInsinameNameExist")
	public void findIndInsinameNameExist(@RequestParam(value="insiname",required=false)String insiname,
			HttpServletResponse  response) throws Exception {
		String insinames=insupplierInfoServcie.findIndInsinameNameExist(insiname);
		
		JSONObject jsonObject=new JSONObject();
		
		if(insinames!=null){
			jsonObject.put("msg", true);
				
		}else { jsonObject.put("msg", false);
		
		
		}
		ResponseUtil.write(response, jsonObject);
	}
	//验证税号唯一性
	@RequestMapping("/findIndInsitaxnumNameExist")
	public void findIndInsitaxnumNameExist(@RequestParam(value="insitaxnum",required=false)String insitaxnum,
			HttpServletResponse  response) throws Exception {
		String insitaxnums=insupplierInfoServcie.findIndInsitaxnumNameExist(insitaxnum);
		
		JSONObject jsonObject=new JSONObject();
		
		if(insitaxnums!=null){
			jsonObject.put("msg", true);
				
		}else { jsonObject.put("msg", false);
		
		
		}
		ResponseUtil.write(response, jsonObject);
	}
	//验证电话号码唯一性
	@RequestMapping("/findIndInsiphoneNameExist")
	public void findIndInsiphoneNameExist(@RequestParam(value="insiphone",required=false)String insiphone,
			HttpServletResponse  response) throws Exception {
		String insiphones=insupplierInfoServcie.findIndInsiphoneNameExist(insiphone);
		
		JSONObject jsonObject=new JSONObject();
		
		if(insiphones!=null){
			jsonObject.put("msg", true);
				
		}else { jsonObject.put("msg", false);
		
		
		}
		ResponseUtil.write(response, jsonObject);
	}
	
}
