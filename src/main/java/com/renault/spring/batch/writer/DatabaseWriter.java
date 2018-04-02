package com.renault.spring.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.renault.application.configuration.AutomationConfiguration;
import com.renault.spring.service.AutomationConfigurationService;

@Component
public class DatabaseWriter implements ItemWriter<AutomationConfiguration> {

	@Autowired
	private AutomationConfigurationService automationConfigurationService;
	
	@Override
	public void write(List<? extends AutomationConfiguration> automationConfigurationList) throws Exception {
		if(automationConfigurationList!=null && automationConfigurationList.size()>=1) {
			automationConfigurationService.saveAll(automationConfigurationList);
		}
		
	}

}
