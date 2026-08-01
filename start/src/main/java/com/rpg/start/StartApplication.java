package com.rpg.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;





@SpringBootApplication

@ComponentScan(basePackages = "com.rpg")
@EntityScan(basePackages = {
	"com.rpg.modules.user.entity",

})
@EnableJpaRepositories({
	"com.rpg.modules.user.repository",

})


public class StartApplication {


	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

}
