package com.amit.security;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	//	loadInMemoryAuth(auth);
	//	loadJDBCAuth(auth);
		loadHibernateAuth(auth);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin*").hasAuthority("admin").
		antMatchers("/user*").hasAnyAuthority("user", "admin").antMatchers("/").permitAll().and().
		formLogin().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	}
	
	private void loadInMemoryAuth(AuthenticationManagerBuilder auth) throws Exception
	{
		PasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
        withUser("user").password(encoder.encode("user")).authorities("user").and().
        withUser("admin").password(encoder.encode("admin")).authorities("admin");
	}
	
	private void loadJDBCAuth(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.jdbcAuthentication().dataSource(dataSource).rolePrefix("").
		passwordEncoder(encoder)
				.usersByUsernameQuery("select user_name, password, enabled from user_details where user_name = ?")
				.authoritiesByUsernameQuery("select user_name, role from user_details where user_name = ?");
	}
	
	private void loadHibernateAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
