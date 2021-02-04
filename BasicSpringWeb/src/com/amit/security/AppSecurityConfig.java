package com.amit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		loadInMemoryAuth(auth);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin*").hasRole("admin").
		antMatchers("/user*").hasAnyRole("admin", "user").antMatchers("/").permitAll().and().
		formLogin().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	}
	
	private void loadInMemoryAuth(AuthenticationManagerBuilder auth) throws Exception
	{
		PasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
        withUser("user").password(encoder.encode("user")).roles("user").and().
        withUser("admin").password(encoder.encode("admin")).roles("admin");
	}
}
