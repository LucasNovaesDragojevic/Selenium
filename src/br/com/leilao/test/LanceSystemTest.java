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
		
		new CriadorCenarios(driver).umUsuario("Matilda", "matilda@email.com")
									.umUsuario("Tobias", "tobias@email.com")
									.umLeilao( "Matilda", "RTX 2060", 2000.00, true);
	}
	
	@After
	public void terminaMetodo() {
		driver.get(new UrlAplicacao().getUrlBase() + "/apenas-teste/limpa");
		driver.close();
	}
	
	@Test
	public void deveFazerUmLance() {
		DetalhesLeilaoPage detalhesLeilaoPage = leiloesPage.detalhes(1);
		detalhesLeilaoPage.lance("Tobias", 2010.00);
		assertTrue(detalhesLeilaoPage.existeLance("Tobias", 2010.00));
	}
}
