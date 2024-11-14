package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailsService 	userDetailsService;
	
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.userDetailsService(userDetailsService);
   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
	   http.csrf().disable();
	 /*http.authorizeRequests()
	    .antMatchers("/admin/**").permitAll()
	    .anyRequest().authenticated();*/
	   
	  http
       .authorizeRequests()
           .antMatchers("/product/**")
           .authenticated()
           .and()
       .authorizeRequests()
           .antMatchers("/admin/**").hasAnyRole("ADMIN")
           .anyRequest().authenticated()
           .and()
       .formLogin()
           .permitAll()
           .and()
   		.logout()
   		.invalidateHttpSession(true)
   		.clearAuthentication(true)
   		//.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
   		.logoutSuccessUrl("/performlogout")
   		.permitAll();
	   
   }
  /* @Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
	}*/
   @Bean
   public BCryptPasswordEncoder encoder() {
	   return new BCryptPasswordEncoder();
   }
   
}
