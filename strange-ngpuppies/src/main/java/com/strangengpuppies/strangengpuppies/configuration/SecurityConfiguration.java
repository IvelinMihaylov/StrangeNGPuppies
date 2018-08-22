package com.strangengpuppies.strangengpuppies.configuration;


import com.strangengpuppies.strangengpuppies.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource securityDataSource;

    @Autowired
    @Qualifier("userDetailsService")
    private final UserDetailsService userDetailsService = new MyUserDetailsService();

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.inMemoryAuthentication().withUser("marto").password(passwordEncoder().encode("user1"))
                .authorities("ROLE_USER");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        configureGlobal(auth);
    }

//    private void configureDatabaseAuth(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(securityDataSource);
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/authenticateUser")
                    .permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                    .permitAll()
                .and().csrf()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
