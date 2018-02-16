package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.hibernate.criterion.Restrictions.and;





@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    //WebSecruityConfigurerAdapter: http portocol to close off routes
    @Autowired
    private SSUserDetailsService userDetailsService;
//    These people have access from our database

    @Autowired
    private UserRepository userRepository;

//    Overriding Spring security and passing in Service to look for userrepository database
//    Get results of current user and what thier rights are

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUserDetailsService(userRepository);
    }

    //    HttpSecurity: tells us which routes people are allowed to acesses includes methods to restict or alllow access
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .authorizerequest user must be authorized to access these requests
                .authorizeRequests()
//                .antmatchers: if you have a route you want to block off
//                .permitall: dont need access pages everyone one can acees this route example:register
                .antMatchers("/","/h2-console/**","/register/","/login","/","/summary","/education","/css/**","/image/**","/js/**"
                ,"/image/**").permitAll()







//                .access("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
                .antMatchers("/refrence","/add**","/update**").access("hasAuthority('APPLICANT')")
                .antMatchers("/login","/").access("hasAuthority('EMPLOYER')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(
                        new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").permitAll().permitAll()
                .and()
                .httpBasic();

        http
                .csrf().disable();

        http
                .headers().frameOptions().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception{
        auth.inMemoryAuthentication().
                withUser("user").password("password").authorities("APPLICANT").
                and().
                withUser("bishnu").password("begreat").authorities("EMPLOYER");

//        Database Authentication must come after in memory authentication
        auth
                .userDetailsService(userDetailsServiceBean());

    }




}


