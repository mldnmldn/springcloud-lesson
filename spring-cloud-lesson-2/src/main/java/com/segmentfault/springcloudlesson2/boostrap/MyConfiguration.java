package com.segmentfault.springcloudlesson2.boostrap;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

@Configuration
public class MyConfiguration implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		
		ConfigurableEnvironment evEnvironment = applicationContext.getEnvironment();
		MutablePropertySources propertySources = evEnvironment.getPropertySources();
		propertySources.addFirst(createPropertySource());
	}
	
	@SuppressWarnings("rawtypes")
	private PropertySource createPropertySource() {
		 Map<String, Object> source = new HashMap<>();
	     source.put("name", "小马哥");
         PropertySource propertySource = new MapPropertySource("my-property-source", source);
		return propertySource;
	}

}
