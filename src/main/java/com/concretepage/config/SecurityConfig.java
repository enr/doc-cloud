package com.concretepage.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/secure/**").access("hasRole('ROLE_ADMIN')").
		and().formLogin().  //login configuration
        loginPage("/customLogin.xhtml").
        loginProcessingUrl("/appLogin").
        usernameParameter("app_username").
        passwordParameter("app_password").
        defaultSuccessUrl("/secure/student.xhtml").	
		and().logout().    //logout configuration
		logoutUrl("/appLogout"). 
		logoutSuccessUrl("/customLogin.xhtml");

	} 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		//.jdbcAuthentication().dataSource(dataSource);
		.inMemoryAuthentication().
		withUser("concretepage").password("concrete123").roles("ADMIN");
	}	
}  
