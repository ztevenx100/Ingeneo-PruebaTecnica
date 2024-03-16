package com.ingeneotest.empresa_gestion_logistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ingeneotest.empresa_gestion_logistica.models.Cliente;

@SpringBootApplication
public class EmpresaGestionLogisticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaGestionLogisticaApplication.class, args);
		System.out.println("- Aplicativo iniciado");

		Cliente vo = new Cliente("1010","C","Pedro","3013013011","pc@gmail.com", null);
		System.out.println(vo.toString());

	}

}
