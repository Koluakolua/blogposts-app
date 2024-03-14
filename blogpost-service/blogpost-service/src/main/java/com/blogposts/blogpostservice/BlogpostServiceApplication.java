package com.blogposts.blogpostservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BlogpostServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogpostServiceApplication.class, args);
	}

}
