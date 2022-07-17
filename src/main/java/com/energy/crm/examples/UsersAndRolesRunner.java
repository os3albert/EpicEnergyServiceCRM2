package com.energy.crm.examples;

import java.util.Arrays;
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
public class UsersAndRolesRunner implements ApplicationRunner{
	private PasswordEncoder encoder;
	private RoleRepository roleRepository;
	private UserRepository userRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Role role = new Role(null,ERole.ROLE_ADMIN);
		Set<Role> roles =  new HashSet<Role>();
		roleRepository.save(role);
		roles.add(role);
		
		User u = User.builder()
				.username("admin")
				.roles(roles)
				.password(  encoder.encode("admin")  )  
				.build();
	
		userRepository.save(u);
		
		roles =  new HashSet<Role>();
		role = new Role(null,ERole.ROLE_USER);
		roleRepository.save(role);
		roles.add(role);
		
		u = User.builder()
				.username("user")
				.roles(roles)
				.password(  encoder.encode("user")  )  
				.build();
		
		userRepository.save(u);
		
		System.out.println( userRepository.findAll());
		
	}

	

}
