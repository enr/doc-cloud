package com.concretepage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.concretepage.service.DocService;
import com.concretepage.service.bean.DocServiceBean;

@Configuration
public class SpringConfiguration {
	@Bean(name="docservice")
	public DocService getDocService()
	{
		return new DocServiceBean();
	}
}
