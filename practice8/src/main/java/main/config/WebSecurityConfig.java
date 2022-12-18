package main.config;

import main.CustomUserDetailsService;
import main.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan("main")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                        .antMatchers("/", "/registration").permitAll()
                        .antMatchers("/filter_show/**", "/show_all/**").hasAnyRole("USER", "ADMIN")
                        .antMatchers("/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                .and()
                        .formLogin()
                        .loginPage("/login")
                        .permitAll()
                .and()
                        .logout()
                        .permitAll();

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}