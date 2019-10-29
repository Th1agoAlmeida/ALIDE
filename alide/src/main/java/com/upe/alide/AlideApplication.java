package com.upe.alide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlideApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlideApplication.class, args);
		start();
	}
	
	public static void start() {
		System.out.println("--------------------------------");
		System.out.println("--- Inicializado com Sucesso ---");
		System.out.println("--------------------------------");
	}

}
