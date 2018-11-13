package com.example.nayab;

import com.example.nayab.domain.User;
import com.example.nayab.model.Role;
import com.example.nayab.service.Restaurants.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class NayabApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(NayabApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... params) throws Exception {
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setEmail("admin@email.com");
		admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

		userService.signup(admin);

		User client = new User();
		client.setUsername("client");
		client.setPassword("client");
		client.setEmail("client@email.com");
		client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));

		userService.signup(client);
	}
}
