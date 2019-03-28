package com.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.beans.ApplicationInfo;

@RestController
@RequestMapping(path="/healthcheck")
public class ApplicationInfoController {
	
	 @Value("${git.commit.id}")
	    private String commitId;
	 
	 @GetMapping
	    public ApplicationInfo getApplicationInfo() {
	       return new ApplicationInfo("1.0", "description", commitId);
	    }

}
