package com.finra.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Finra application.
 */
@SpringBootApplication(scanBasePackages = "com.finra.demo")
public class FinraApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(FinraApplication.class, args);
	}
}
