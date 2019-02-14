package com.eshoppingzone.eshoppingzone;

import java.security.Principal;
import java.util.LinkedHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class EshoppingzoneApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(EshoppingzoneApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().antMatcher("/**").authorizeRequests().antMatchers("/**", "/login**").permitAll()
				.anyRequest().authenticated().and().logout().logoutSuccessUrl("/").clearAuthentication(true).permitAll();
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {

		return principal;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
