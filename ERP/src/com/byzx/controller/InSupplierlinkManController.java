package com.byzx.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.byzx.service.InSupplierlinkManService;
import com.byzx.util.ResponseUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/inSupplierlinkMan")
public class InSupplierlinkManController {
	
	
	@Autowired
   private   InSupplierlinkManService   inSupplierlinkManService;
	
	
	@RequestMapping("/findInSupplierlinkMan")
	public void findInSupplierlinkMan(@RequestParam(value="insiid",required=false)String insiid,
			HttpServletResponse response) throws Exception {

		JSONArray  jsonArray=inSupplierlinkManService.findInSupplierlinkMan(insiid);
		
		ResponseUtil.write(response, jsonArray);
		
		
	}
	
}
