package com.demo.spring.boot.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.demo.spring.boot.web.model.Role;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		// for the authorize
		.authorizeRequests()
		.antMatchers("/auth/**", "/public/**").permitAll()
        .antMatchers("/users/**").hasAuthority(Role.ADMIN.toString())
        .anyRequest().fullyAuthenticated() // for all authenticated User ( that means : all users can access with any role)
        // for the login form
        .and()
		.formLogin()
		.loginPage("/auth/login")
		.failureUrl("/auth/login?error=true")
		.defaultSuccessUrl("/user/list")
		.usernameParameter("username")
		.permitAll()
		// for the logout
		.and()
		.logout()
		.logoutUrl("/auth/logout").deleteCookies("remember-me")
		.logoutSuccessUrl("/auth/login")
		.permitAll()
		.and().
		rememberMe();
	}

	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
