package com.example.observer_coin.config;

import com.example.observer_coin.domain.Customer;
import com.example.observer_coin.domain.CustomerRepository;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.function.client.WebClient;

import javax.sql.DataSource;
import java.time.Duration;
import java.util.Arrays;

@Slf4j
@Configuration
public class ProjectConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }





}
