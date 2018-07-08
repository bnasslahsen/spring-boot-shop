package fr.training.spring.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "fr.training.spring.shop" }, lazyInit = true)
@EntityScan(basePackages = { "fr.training.spring.shop.domain" })
public class SpringBootApp {

	/**
	 * Entry point for spring-boot based app
	 *
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(SpringBootApp.class, args);
	}
}
