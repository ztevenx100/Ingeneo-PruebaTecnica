package com.ingeneotest.empresa_gestion_logistica;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EmpresaGestionLogisticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaGestionLogisticaApplication.class, args);
		System.out.println("- Aplicativo iniciado");
	}

	@PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC")); // Or your desired time zone
    }

}
