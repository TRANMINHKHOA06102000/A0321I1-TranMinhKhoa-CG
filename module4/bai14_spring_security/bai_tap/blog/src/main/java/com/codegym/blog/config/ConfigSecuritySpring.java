package com.codegym.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSecuritySpring extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}12345").roles("USER")
                .and()
                .withUser("admin").password("{noop}12345").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/showCreateBlog**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .and()
                .authorizeRequests().antMatchers("/createBlog**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .and()
                .authorizeRequests().antMatchers("/view**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .and()
                .authorizeRequests().antMatchers("/delete**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .and()
                .authorizeRequests().antMatchers("/edit**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .and()
                .authorizeRequests().antMatchers("/listBlog**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .and()
                .authorizeRequests().antMatchers("/viewCategory**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/category**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/showCreateCategory**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/createCategory**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/editCategory**").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/deleteCategory**").hasRole("USER")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

    }
}
