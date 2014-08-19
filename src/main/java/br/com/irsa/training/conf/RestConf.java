package br.com.irsa.training.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class RestConf {

	@Bean
	public ObjectMapper getMapper(){
		ObjectMapper mapper = new ObjectMapper();
		  mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		  return mapper;
	}
	
}
