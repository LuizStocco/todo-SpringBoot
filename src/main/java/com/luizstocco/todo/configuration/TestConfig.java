package com.luizstocco.todo.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luizstocco.todo.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbservice;
	@Bean
	public boolean instancia() throws ParseException {
		this.dbservice.instaciaBaseDeDados();
		return true;
	}
}
