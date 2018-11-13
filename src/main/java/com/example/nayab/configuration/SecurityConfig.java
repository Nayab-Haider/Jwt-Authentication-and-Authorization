package com.example.nayab.configuration;

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

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

//    @Override
//    public void init(WebSecurity web) throws Exception {
//
//        // Allow swagger to be accessed without authentication
//        web.ignoring().antMatchers("/v2/api-docs")//
//                .antMatchers("/swagger-resources/**")//
//                .antMatchers("/swagger-ui.html")//
//                .antMatchers("/configuration/**")//
//                .antMatchers("/webjars/**")//
//                .antMatchers("/public")
//
//                // Un-secure H2 Database (for testing purposes, H2 console shouldn't be unprotected in production)
//                .and()
//                .ignoring()
//                .antMatchers("/h2-console/**/**");;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Disable CSRF (cross site request forgery)
        http.csrf().disable();

        // No session will be created or used by spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Entry points
        http.authorizeRequests()//
                .antMatchers("/v1/login").permitAll()
                .antMatchers("/v1/signup").permitAll()
                .antMatchers("/h2-console/**/**").permitAll()
                .antMatchers("/swagger-ui.html","/v2/api-docs","/webjars/**","/swagger-resources/**","/swagger-ui.html#!/","/configuration/**","/configuration/ui").permitAll()
                // Disallow everything else..
                .anyRequest().authenticated();

        // If a user try to access a resource without having enough permissions
        http.exceptionHandling().accessDeniedPage("/login");

        // Apply JWT
        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
