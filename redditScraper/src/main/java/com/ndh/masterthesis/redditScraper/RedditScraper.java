package com.ndh.masterthesis.redditScraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Martin Beyer
 *
 */
@EnableFeignClients
@SpringBootApplication
public class RedditScraper {

	public static void main(String[] args) {
		SpringApplication.run(RedditScraper.class, args);
	}

}