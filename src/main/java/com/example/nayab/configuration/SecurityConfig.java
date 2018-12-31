package com.example.nayab.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private static  final Logger log = LogManager.getLogger(SecurityConfig.class);

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        log.info("Entering into SecurityConfig inside constructor");
        return authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Entering into SecurityConfig inside method configure");
        http.cors().and().csrf().disable().authorizeRequests()//
                .antMatchers("/v1/auth/login").permitAll()
                .antMatchers("/v1/auth/signup").permitAll()
                .antMatchers("/v1/auth/forgotpassword/*").permitAll()
                .antMatchers("/v1/auth/resetpassword").permitAll()
                .antMatchers("/v1/auth/download/**").permitAll()
                .antMatchers("/h2-console/**/**").permitAll()
                .antMatchers("/swagger-ui.html","/v2/api-docs","/webjars/**","/swagger-resources/**","/swagger-ui.html#!/","/configuration/**","/configuration/ui").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(12);
    }

}
