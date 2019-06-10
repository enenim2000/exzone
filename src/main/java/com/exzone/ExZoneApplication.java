package com.exzone;

import com.exzone.util.PasswordEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class ExZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExZoneApplication.class, args);
	}

	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new PasswordEncoder();
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(10); //reload messages every 10 seconds
		return messageSource;
	}

}

