package com.offcn.company;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "c3p0")
    public ComboPooledDataSource dataSource(){
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
    }
}
