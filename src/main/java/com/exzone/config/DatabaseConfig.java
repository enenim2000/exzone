package com.exzone.config;

import com.exzone.service.BaseRepositoryService;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        repositoryBaseClass = BaseRepositoryService.class,
        basePackages = {"com.exzone.model.dao", "com.exzone.repository.dao", "com.exzone.service.dao"}
)
public class DatabaseConfig{

}