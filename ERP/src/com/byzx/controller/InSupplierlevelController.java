package com.byzx.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.byzx.service.InSupplierlevelService;
import com.byzx.util.ResponseUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/insupplierlevel")
public class InSupplierlevelController {
	
	
	@Autowired
	private   InSupplierlevelService   inSupplierlevelService;
	
	@RequestMapping("/findInSupplierlevel")
	public void findInSupplierlevel(@RequestParam(value="inslid",required=false)String inslid,
			HttpServletResponse response) throws Exception {
		

		JSONArray  jsonArray=inSupplierlevelService.findInSupplierlevel(inslid);
		
		ResponseUtil.write(response, jsonArray);
		
		
	}

}
