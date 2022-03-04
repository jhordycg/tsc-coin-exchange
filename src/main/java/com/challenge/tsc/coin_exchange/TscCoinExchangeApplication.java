package com.challenge.tsc.coin_exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
public class TscCoinExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TscCoinExchangeApplication.class, args);
    }

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean getRepositoryPopulate() {
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        factory.setResources(new Resource[]{new ClassPathResource("data.json")});
        return factory;
    }
}
