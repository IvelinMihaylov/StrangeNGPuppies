package com.strangengpuppies.strangengpuppies.configuration;


//import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.strangengpuppies.strangengpuppies.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//
//import javax.sql.DataSource;
//import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public DataSource securityDataSource() {
//        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
//
//        try {
//            securityDataSource.setDriverClass(env.getProperty("database.driver"));
//
//        } catch (PropertyVetoException e) {
//            throw new RuntimeException(e);
//        }
//
//        securityDataSource.setJdbcUrl(env.getProperty("database.url"));
//        securityDataSource.setUser(env.getProperty("database.username"));
//        securityDataSource.setPassword(env.getProperty("database.password"));
//
//        securityDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.initialPoolSize")));
//        securityDataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.minPoolSize")));
//        securityDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.maxPoolSize")));
//        securityDataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.maxIdleTime")));
//
//        return securityDataSource;
//    }
//
//    @Bean
//    public UserDetailsManager userDetailsManager() {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//        jdbcUserDetailsManager.setDataSource(securityDataSource());
//
//        return jdbcUserDetailsManager;
//    }
//
    @Bean
    public SessionFactory createFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bill.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Service.class)
                .addAnnotatedClass(Subscriber.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
}
