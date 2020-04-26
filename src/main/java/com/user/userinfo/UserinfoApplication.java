package com.user.userinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication/*(scanBasePackages={
		"com.user.userinfo.service.ResourceService"})*/
@ComponentScan("com.user.userinfo.service.*")
@ComponentScan("com.user.userinfo.web")
@ComponentScan("com.user.userinfo.service.ResourceService")

@EnableJpaRepositories
public class UserinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserinfoApplication.class, args);
	}

}
