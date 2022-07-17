package com.energy.crm.clienti.indirizzi.comuni;

import org.aspectj.lang.annotation.control.CodeGenerationHint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

@Configuration
public class ComuneConfig {
	
	@Bean("comune")
	@Scope("prototype")
	public ComuneImp getComune() {
		
		return ComuneImp.builder()
				.indirizziList(null)
				.nomeComune(Faker.instance().address().cityName())
				.build();
		
	}
}
