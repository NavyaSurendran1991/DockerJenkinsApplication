package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

import com.spring.beans.ApplicationInfo;

@Service
public class ApplicationInfoService {

	 @Value("${git.commit.id}")
	    private String commitId;
	 @Autowired
	  BuildProperties buildProperties;
	 
	 private static final String DESCRIPTION = "Application with  Jenkins and Docker";
	 
	 public ApplicationInfo getApplicationInfo() {
		 return new ApplicationInfo(buildProperties.getVersion(), DESCRIPTION, commitId);
	 }
}
