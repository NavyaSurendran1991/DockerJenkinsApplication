package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.beans.ApplicationInfo;
import com.spring.service.ApplicationInfoService;

@RestController
@RequestMapping(path="/healthcheck")
public class ApplicationInfoController {
	
	@Autowired
	private ApplicationInfoService applicationInfoService;
	
	
	 
	 @GetMapping
	    public ApplicationInfo getApplicationInfo() {
		 return applicationInfoService.getApplicationInfo();
	    }

}
