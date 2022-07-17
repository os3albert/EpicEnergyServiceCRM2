package com.energy.crm.clienti.indirizzi.comuni;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ComuneRunner implements ApplicationRunner {
	
	@Autowired
	ComuneRepository comuneRepository;
	
	@Autowired
	@Qualifier("comune")
	ObjectProvider<ComuneImp> objectProvider;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 20; i++) {
			comuneRepository.save(objectProvider.getObject());
		}
		

	}

}
