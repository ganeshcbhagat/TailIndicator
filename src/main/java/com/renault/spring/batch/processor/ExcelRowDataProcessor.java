package com.renault.spring.batch.processor;

import org.dozer.DozerBeanMapper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.renault.application.configuration.AutomationConfiguration;
import com.renault.spring.model.ExcelRow;

@Component
public class ExcelRowDataProcessor implements ItemProcessor<ExcelRow, AutomationConfiguration> {

	@Override
	public AutomationConfiguration process(ExcelRow excelRow) throws Exception {
		if (excelRow != null) {
			DozerBeanMapper mapper = new DozerBeanMapper();
			AutomationConfiguration automationConfiguration = mapper.map(excelRow, AutomationConfiguration.class);
			return automationConfiguration;
		}
		return null;
	}

}
