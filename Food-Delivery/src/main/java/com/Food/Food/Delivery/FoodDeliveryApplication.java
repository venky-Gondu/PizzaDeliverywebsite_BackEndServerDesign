package com.Food.Food.Delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.Food.Food.Delivery.repo")
@EntityScan(basePackages = "com.Food.Food.Delivery.model")
@SpringBootApplication
public class FoodDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApplication.class, args);
	}

}
