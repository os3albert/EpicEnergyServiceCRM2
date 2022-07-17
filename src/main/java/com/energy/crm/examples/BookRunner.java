package com.energy.crm.examples;
 
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.energy.crm.auth.roles.ERole;
import com.energy.crm.auth.roles.Role;
import com.energy.crm.auth.roles.RoleRepository;
import com.energy.crm.auth.users.User;
import com.energy.crm.auth.users.UserRepository;

import lombok.AllArgsConstructor;



@Component
@AllArgsConstructor
public class BookRunner implements ApplicationRunner{
	private BookRepository repository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		 
		
		repository.save( Book.builder().author("Salgari").title("Sandokan").build()      );
		
	}

	

}
