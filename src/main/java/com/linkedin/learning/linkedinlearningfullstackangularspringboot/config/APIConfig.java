package com.linkedin.learning.linkedinlearningfullstackangularspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class APIConfig {
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objMapper = new ObjectMapper();
		
		objMapper.registerModule(new JavaTimeModule());
		return objMapper;
	}
	
	@Bean
	public ObjectWriter objectWriter(ObjectMapper objectMapper) {
		return objectMapper.writerWithDefaultPrettyPrinter();
	}
}
