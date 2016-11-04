package com.concretepage.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://192.168.180.183:3306/doccloud?profileSQL=true");
        driverManagerDataSource.setUsername("root");
        // driverManagerDataSource.setPassword("password");
        return driverManagerDataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/secure/**").access("hasRole('ROLE_ADMIN')").and().formLogin().  // login configuration
                loginPage("/customLogin.xhtml").loginProcessingUrl("/appLogin").usernameParameter("app_username").passwordParameter("app_password").defaultSuccessUrl("/secure/student.xhtml").and().logout().    // logout
                                                                                                                                                                                                                  // configuration
                logoutUrl("/appLogout").logoutSuccessUrl("/customLogin.xhtml");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password, enabled from Utente where username=?").authoritiesByUsernameQuery("select username, role from Ruolo where username=?");

    }
}
