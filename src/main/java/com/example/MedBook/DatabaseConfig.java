package com.example.MedBook;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by uuuu on 4/7/2018.
 */

@Configuration
public class DatabaseConfig {

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
}