package com.nykaa.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    @Bean(name = "fooDataSource")
    @ConfigurationProperties(prefix = "datasource.foo")
    public HikariDataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/sys?useSSL=false")
                .username("nidhi")
                .password("N@google1")
                .type(HikariDataSource.class).build();
    }

  /*  @Bean(name = "fooEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean fooEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("fooDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.buddhi.multidatasource.foo.model")
                .persistenceUnit("fooDb")
                .build();
    }*/

  /*  @Bean(name = "replicaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder,
            @Qualifier("replicaDataSource") DataSource replicaDataSource) {
        return builder
                .dataSource(replicaDataSource)
                .packages("com.nykaa.app.entity")
                .persistenceUnit("replicaPU")
                .build();
    }*/
}
