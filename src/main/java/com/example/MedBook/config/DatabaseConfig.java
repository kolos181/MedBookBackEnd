package com.example.MedBook.config;

import com.example.MedBook.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by uuuu on 4/7/2018.
 */

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    private ApplicationContext appContext;

    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("usdjfuefcnakre")
                .password("50fc3935436965c7df94d3b83e4567a5691b699862fb8408b31cd553b6fe59db")
                .url("jdbc:postgresql://ec2-174-129-206-173.compute-1.amazonaws.com:5432/d32n9851o7g2up")
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
        return manager;
    }

    @Bean
    public LocalSessionFactoryBean hibernate5SessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource((DataSource) appContext.getBean("DataSource"));
        localSessionFactoryBean.setAnnotatedClasses(
                Patient.class
        );

//        Properties properties = new Properties();
//        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        //properties.put("hibernate.current_session_context_class","thread");
//        properties.put("hibernate.hbm2ddl.auto","update");
//        properties.put("hibernate.show_sql","true");

//        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }
}