package com.byzx.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.byzx.service.InSupplierAreaService;
import com.byzx.util.ResponseUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/inSupplierArea")
public class InSupplierAreaController {
	
	@Autowired
	private InSupplierAreaService   inSupplierAreaService;
	
	
	@RequestMapping("/findInSupplierArea")
	public void findInSupplierArea(@RequestParam(value="insaid",required=false)String insaid ,
			HttpServletResponse response ) throws Exception {
			
			
		
		JSONArray  jsonArray=inSupplierAreaService.findInSupplierArea(insaid);
		
		ResponseUtil.write(response, jsonArray);
		
		
		
	}
	

}
