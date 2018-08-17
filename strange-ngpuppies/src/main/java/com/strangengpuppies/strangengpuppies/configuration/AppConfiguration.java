package com.strangengpuppies.strangengpuppies.configuration;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {
    @Autowired
    private Environment env;

    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource securityDataSoure = new ComboPooledDataSource();

        try {
            securityDataSoure.setDriverClass(env.getProperty("database.driver"));

        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        securityDataSoure.setJdbcUrl(env.getProperty("database.url"));
        securityDataSoure.setUser(env.getProperty("database.username"));
        securityDataSoure.setPassword(env.getProperty("database.password"));

        securityDataSoure.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.initialPoolSize")));
        securityDataSoure.setMinPoolSize(Integer.parseInt(env.getProperty("connection.minPoolSize")));
        securityDataSoure.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.maxPoolSize")));
        securityDataSoure.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.maxIdleTime")));

        return securityDataSoure;
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(securityDataSource());

        return jdbcUserDetailsManager;
    }
}
