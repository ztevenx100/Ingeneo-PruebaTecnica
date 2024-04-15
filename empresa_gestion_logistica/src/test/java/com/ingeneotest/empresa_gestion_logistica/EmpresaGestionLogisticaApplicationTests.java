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
	public void testCompleteCliente() {
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
			page.onceDialog(dialog ->dialog.accept());
			botonEliminar.click();
			page.waitForTimeout(3000);

			//page.pause();

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

	@Test
	public void testCompleteProducto() {
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
			page.querySelector("a[href='/producto']").click();

			page.click(".btn-adicionar");
			// LLenar formulrio
			Random random = new Random();
			long rndValor = random.nextLong(90000L) + 1000;
			
			String idValue = page.querySelector("#id").inputValue();
			page.selectOption("#tipo", "T");
			page.fill("#nombre", "Producto 1");
			page.fill("#cantidad", "1000");
			page.fill("#valorUnitario", "" + rndValor);
			page.selectOption("#estado", "A");
			
			page.click(".btn-submit");
			page.click(".back-button");
			page.waitForTimeout(3000);
			
			// Construir el selector CSS para seleccionar la fila que contenga el ID "idValue" en la primera columna
			String boton = "table#tableProducto tr[data-id=\"" + idValue + "\"] .btn-editar";
			ElementHandle botonEditar = page.querySelector(boton);
			botonEditar.click();
			//page.waitForTimeout(3000);
			page.fill("#nombre", "Producto 2");
			page.selectOption("#estado", "I");
			page.click(".btn-submit");
			page.click(".back-button");

			page.waitForTimeout(3000);
			
			boton = "table#tableProducto tr[data-id=\"" + idValue + "\"] .btn-eliminar";
			ElementHandle botonEliminar = page.querySelector(boton);
			page.onceDialog(dialog ->dialog.accept());
			botonEliminar.click();
			page.waitForTimeout(3000);

			//page.pause();

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

	@Test
	public void testCompleteAlmacen() {
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
			page.querySelector("a[href='/almacen']").click();

			page.click(".btn-adicionar");
			// LLenar formulrio
			Random random = new Random();
			long rndValor = random.nextLong(100L) + 1;
			
			String idValue = page.querySelector("#id").inputValue();
			page.selectOption("#tipo", "T");
			page.fill("#nombre", "Almacen 1");
			page.fill("#descripcion", "Descripcion de almacen");
			page.fill("#direccion", "Calle 10 # 10 - " + rndValor);
			page.selectOption("#estado", "A");
			
			page.click(".btn-submit");
			page.click(".back-button");
			page.waitForTimeout(3000);
			
			// Construir el selector CSS para seleccionar la fila que contenga el ID "idValue" en la primera columna
			String boton = "table#tableAlmacen tr[data-id=\"" + idValue + "\"] .btn-editar";
			ElementHandle botonEditar = page.querySelector(boton);
			botonEditar.click();
			//page.waitForTimeout(3000);
			page.fill("#nombre", "Almacen 2");
			page.selectOption("#estado", "I");
			page.click(".btn-submit");
			page.click(".back-button");

			page.waitForTimeout(3000);
			
			boton = "table#tableAlmacen tr[data-id=\"" + idValue + "\"] .btn-eliminar";
			ElementHandle botonEliminar = page.querySelector(boton);
			page.onceDialog(dialog ->dialog.accept());
			botonEliminar.click();
			page.waitForTimeout(3000);

			//page.pause();

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
