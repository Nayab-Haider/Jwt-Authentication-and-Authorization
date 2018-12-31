package com.example.nayab;

import com.example.nayab.controller.authenticate.AuthenticationController;
import com.example.nayab.domain.user.Role;
import com.example.nayab.domain.user.User;
import com.example.nayab.service.authenticate.AuthenticationService;
import com.example.nayab.service.authenticate.AuthenticationServiceImpl;
import com.example.nayab.service.document.FileStorageServiceProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication()
@EnableConfigurationProperties({
		FileStorageServiceProperties.class
})
public class NayabApplication implements CommandLineRunner {

	@Autowired
	private AuthenticationService authenticationService;


	private static final Logger logger= LogManager.getLogger(AuthenticationController.class);

	public static void main(String[] args) {
		SpringApplication.run(NayabApplication.class,args);
		logger.info(" ------------------------------------------------------");
		logger.info("|               SERVER STARTED                        |");
		logger.info(" ------------------------------------------------------");
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

		authenticationService.signup(admin);

		User client = new User();
		client.setUsername("client");
		client.setPassword("client");
		client.setEmail("client@email.com");
		client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));

		authenticationService.signup(client);
	}

}
