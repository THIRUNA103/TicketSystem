package com.naren.TicketBookingMysql.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests().antMatchers("/getAllTickets/**").hasAnyRole("admin","user").and().formLogin();
		http.csrf().disable().authorizeRequests().antMatchers("/create/**").hasAnyRole("admin").and().formLogin();
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Naren").password("{noop}password").roles("admin");
		auth.inMemoryAuthentication().withUser("Raj").password("{noop}password").roles("user");
	}
	
	

}
