package com.example.nayab;

import com.example.nayab.configuration.JwtTokenProvider;
import com.example.nayab.configuration.MyUserDetails;
import com.example.nayab.controller.authenticate.AuthenticationController;
import com.example.nayab.domain.user.Role;
import com.example.nayab.domain.user.User;
import com.example.nayab.service.authenticate.AuthenticationService;
import com.example.nayab.service.authenticate.AuthenticationServiceImpl;
import com.example.nayab.service.document.FileStorageServiceProperties;
import io.jsonwebtoken.Jwts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication()
@EnableConfigurationProperties({
		FileStorageServiceProperties.class
})
public class NayabApplication implements CommandLineRunner {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

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
