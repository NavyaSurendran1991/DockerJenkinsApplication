package com.spring.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.spring.beans.ApplicationInfo;
import com.spring.service.ApplicationInfoService;
import com.spring.utils.TestUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationInfoController.class)
public class ApplicationInfoControllerTests {
	
	@Autowired
	private transient MockMvc mvc;
	
	@MockBean
	private transient ApplicationInfoService applicationInfoService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getApplicationDetailsTest() throws Exception {
		ApplicationInfo applicationInfo = new ApplicationInfo("1.0", "description", "sha12334");
		
		when(applicationInfoService.getApplicationInfo()).thenReturn(applicationInfo);
		
		mvc.perform(get("/healthcheck"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.applicationVersion", is("1.0")))
        .andExpect(jsonPath("$.description", is("description")))
        .andExpect(jsonPath("$.lastCommitSHa", is("sha12334")));
		
		 verify(applicationInfoService, times(1)).getApplicationInfo();
	     verifyNoMoreInteractions(applicationInfoService);

		
	}

}
