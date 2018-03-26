package com.finra.demo.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * The type Finra configuration.
 */
@Configuration
public class FinraConfiguration {

    /**
     * Jdbc template jdbc template.
     *
     * @return the jdbc template
     */
    @Bean
    public JdbcTemplate jdbcTemplate(){

      return new JdbcTemplate(dataSource());

    }

    /**
     * Data source data source.
     *
     * @return the data source
     */
    @Bean
    @ConfigurationProperties(prefix="inputServiceDataSource.db")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
}
