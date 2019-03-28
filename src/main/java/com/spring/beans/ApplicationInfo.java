package com.spring.beans;


public class ApplicationInfo {
	
	private String applicationVersion;
	private String description;
	private String lastCommitSHa;
	
	public ApplicationInfo(String applicationVersion, String description, String lastCommitSHa) {
		super();
		this.applicationVersion = applicationVersion;
		this.description = description;
		this.lastCommitSHa = lastCommitSHa;
		
	}
	public String getApplicationVersion() {
		return applicationVersion;
	}
	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLastCommitSHa() {
		return lastCommitSHa;
	}
	public void setLastCommitSHa(String lastCommitSHa) {
		this.lastCommitSHa = lastCommitSHa;
	}
	
	

}
