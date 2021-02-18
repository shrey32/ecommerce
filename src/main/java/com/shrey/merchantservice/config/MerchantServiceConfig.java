package com.shrey.merchantservice.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shrey.merchantservice.model.Merchant;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = {
		"com.shrey.merchantservice.repository" })
public class MerchantServiceConfig {

	@Autowired
	Environment environment;

	@Bean("dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
		dataSource.setJdbcUrl(environment.getProperty("spring.datasource.url"));

		dataSource.setMaximumPoolSize(1);
		dataSource.setMaxLifetime(0);
		dataSource.setPoolName("H2DB_HIKARICP_CONNECTION_POOL");

		return dataSource;
	}

	@Bean("entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") DataSource dataSource,
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource).packages(Merchant.class).persistenceUnit("H2DB").build();

	}

	@Bean("transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

}
