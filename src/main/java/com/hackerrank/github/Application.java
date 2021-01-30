package com.hackerrank.github;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.hackerrank.github")
@EnableJpaRepositories(
		  basePackages = "com.hackerrank.github.repository", repositoryImplementationPostfix = "CustomImpl")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @PostConstruct
    private void setTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    
    @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
