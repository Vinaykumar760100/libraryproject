package com.libraryproject.security;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//create a bean class for authentication
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetais admin=User.withusername
	}

}
