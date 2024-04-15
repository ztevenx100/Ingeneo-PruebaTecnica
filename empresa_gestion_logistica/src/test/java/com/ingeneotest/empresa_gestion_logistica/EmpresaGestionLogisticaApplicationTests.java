package com.ingeneotest.empresa_gestion_logistica;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

@SpringBootTest
class EmpresaGestionLogisticaApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	public void testLogin() {
		Playwright playwright = null;
		Browser browser = null;
		Page page = null;
		
		try {
			playwright = Playwright.create();
			browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
			);
			page = browser.newPage();

			page.navigate("http://localhost:8081");
			System.out.println(page.title());

			page.waitForLoadState(LoadState.NETWORKIDLE);

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			page.close();
			browser.close();
			playwright.close();
		}
	}

	@Test
	public void testCliente() {
		Playwright playwright = null;
		Browser browser = null;
		Page page = null;
		
		try {
			playwright = Playwright.create();
			browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
			);
			page = browser.newPage();

			page.navigate("http://localhost:8081");
			System.out.println(page.title());

			ElementHandle button = page.querySelector("#btnMenuOptions");
			button.hover();

			//page.navigate("http://localhost:8081/cliente");
			page.querySelector("a[href='/cliente']").click();

			page.click(".btn-adicionar");
			// LLenar formulrio
			Random random = new Random();
			int codigoNumerico = random.nextInt(900000000) + 100000000;
			long rndTelefono = random.nextLong(9000000000L) + 1000000000;

			page.fill("#id", ""+codigoNumerico);
			page.selectOption("#tipoId", "C");
			page.fill("#nombre", "Cliente 1");
			page.fill("#telefono", "" + rndTelefono);
			page.fill("#email", "cliente1@falso.com");
			page.fill("#direccion", "Calle 601 # 234 - 456");
			page.selectOption("#estado", "A");
			
			page.click(".btn-submit");
			page.click(".back-button");
			page.waitForTimeout(3000);
			
			// Construir el selector CSS para seleccionar la fila que contenga el ID "codigoNumerico" en la primera columna
			String boton = "table#tableCliente tr[data-id=\"" + codigoNumerico + "\"] .btn-editar";
			ElementHandle botonEditar = page.querySelector(boton);
			botonEditar.click();
			//page.waitForTimeout(3000);
			page.fill("#nombre", "Cliente 2");
			page.selectOption("#estado", "I");
			page.click(".btn-submit");
			page.click(".back-button");

			page.waitForTimeout(3000);
			
			boton = "table#tableCliente tr[data-id=\"" + codigoNumerico + "\"] .btn-eliminar";
			ElementHandle botonEliminar = page.querySelector(boton);
			botonEliminar.click();
			page.waitForTimeout(3000);

			page.pause();

			// Obtener la fila a partir de la celda seleccionada
			//ElementHandle fila = celda.parent();

			// Encuentra el botón dentro de la fila y haz clic en él
			//ElementHandle boton = fila.querySelector(".btn-editar");
			//boton.click();

			page.waitForTimeout(5000);

			page.waitForLoadState(LoadState.NETWORKIDLE);

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			page.close();
			browser.close();
			playwright.close();
		}
	}

}
