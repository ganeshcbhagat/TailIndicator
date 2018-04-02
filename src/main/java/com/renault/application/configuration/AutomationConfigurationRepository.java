package com.renault.application.configuration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomationConfigurationRepository extends CrudRepository<AutomationConfiguration, Long>{

	public Iterable<AutomationConfiguration> findByName(String name);
	
}
