package com.spring.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.beans.ApplicationInfo;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationInfoServiceTests {
	
	@Mock
	private transient ApplicationInfoService service;
	
	
	private ApplicationInfo applicationInfo;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		applicationInfo = new ApplicationInfo("1.0", "description", "sha12334");
	}
	
	@Test
	public void getApplicationDetailsTest() {
		
		when(service.getApplicationInfo()).thenReturn(applicationInfo);
		
		ApplicationInfo info = service.getApplicationInfo();
		
		assertEquals(applicationInfo.getApplicationVersion(), info.getApplicationVersion());
		assertEquals(applicationInfo.getDescription(), info.getDescription());
		assertEquals(applicationInfo.getLastCommitSHa(), info.getLastCommitSHa());
		
	}

}
