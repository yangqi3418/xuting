package com.byzx.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.byzx.service.WorkBookDetailService;
import com.byzx.util.ResponseUtil;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/workBookDetail")
public class WorkBookDetailController {
	
	@Autowired
	private WorkBookDetailService  workBookDetailService;
	

	@RequestMapping("/findAllworkBookDetail")
	public void findAllWorkBookDetail(@RequestParam(value="wid",required=false)String wid,
			HttpServletResponse response ) throws Exception {
			
		
		JSONArray  jsonArray=workBookDetailService.findAllWorkBookDetail(wid);
		
		ResponseUtil.write(response, jsonArray);
		
		
		
	}
	
	
	
	
}
