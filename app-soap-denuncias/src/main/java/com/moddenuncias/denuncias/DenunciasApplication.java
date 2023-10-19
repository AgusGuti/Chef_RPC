package com.moddenuncias.denuncias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moddenuncias.denuncias.service.DenunciaService;

@SpringBootApplication
public class DenunciasApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(DenunciasApplication.class, args);
	}

}
