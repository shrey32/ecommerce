package com.shrey.merchantservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * @author Shrey
 *
 */
@SpringBootApplication
@EnableScheduling
public class MerchantServiceApp {

	public static void main(String[] args) {
		new SpringApplication(MerchantServiceApp.class).run(args);
	}

}
