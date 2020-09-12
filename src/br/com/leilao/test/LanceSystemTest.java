package br.com.leilao.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSystemTest {

	private WebDriver driver;
	private LeiloesPage leiloesPage;

	@BeforeClass
	public static void iniciaClasse() {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
	}
	
	@Before
	public void iniciaMetodo() {
		driver = new ChromeDriver();
		leiloesPage = new LeiloesPage(driver);
		
		UsuariosPage usuariosPage = new UsuariosPage(driver);
		usuariosPage.visita();
		usuariosPage.novo().cadastra("Matilda", "matilda@email.com");
		usuariosPage.novo().cadastra("Tobias", "tobias@email.com");
		
		LeiloesPage leiloesPage = new LeiloesPage(driver);
		leiloesPage.visita();
		leiloesPage.novo().preenche("RTX 2060", 2000.00, "Matilda", true);
	}
	
	@After
	public void terminaMetodo() {
		driver.get("http://localhost:8080/apenas-teste/limpa");
		driver.close();
	}
	
	@Test
	public void deveFazerUmLance() {
		DetalhesLeilaoPage detalhesLeilaoPage = leiloesPage.detalhes(1);
		detalhesLeilaoPage.lance("Tobias", 2010.00);
		assertTrue(detalhesLeilaoPage.existeLance("Tobias", 2010.00));
	}
}
