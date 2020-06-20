package com.hospital.frontdesk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class HospitalFrontdeskSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override  
    public void configure(HttpSecurity httpSecurity) throws Exception {  
		httpSecurity  
            .authorizeRequests()  
            .anyRequest().authenticated()  
            .and()
            .formLogin()
            .and()            
            .httpBasic();  
    }  
	
    @Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
        auth.inMemoryAuthentication()  
            .withUser("740072")  
            .password("{noop}BeHappy")  
            .roles("USER");  
    } 
	

}
