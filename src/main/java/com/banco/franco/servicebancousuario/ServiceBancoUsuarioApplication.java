package com.banco.franco.servicebancousuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
public class ServiceBancoUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBancoUsuarioApplication.class, args);
	}

	@Bean
	public RestTemplate getresttemplate() {
		return new RestTemplate();
	}
}
