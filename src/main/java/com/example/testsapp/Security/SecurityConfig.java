package com.example.testsapp.Security;

import com.example.testsapp.Security.jwt.JwtConfig;
import com.example.testsapp.Security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private static final String ALERTS_ENDPOINT = "/Alerts/**";
    private static final String GROUP_ENDPOINT = "/Groups/**";
    private static final String REGISTRATION_ENDPOINT = "/Users/**";
    private static final String ADMIN_ENDPOINT = "/Admin/**";
    private static final String LOGIN_ENDPOINT = "/Auth/**";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                    .antMatchers(LOGIN_ENDPOINT).permitAll()
                    .antMatchers(ALERTS_ENDPOINT).permitAll()
                    .antMatchers(REGISTRATION_ENDPOINT).permitAll()
                    .antMatchers(GROUP_ENDPOINT).permitAll()
                    .antMatchers(ADMIN_ENDPOINT).hasRole("Admin")
                    .antMatchers(HttpMethod.OPTIONS, "**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .apply(new JwtConfig(jwtTokenProvider));
    }

}
