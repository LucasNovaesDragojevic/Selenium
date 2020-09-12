package br.com.leilao.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesSystemTest {

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
		usuariosPage.novo().cadastra("Ruberval", "ruberval@email.com");
	}
	
	@After
	public void terminaMetodo() {
		driver.get(new UrlAplicacao().getUrlBase() + "/apenas-teste/limpa");
		driver.close();
	}
	
	@Test
	public void deveCadastrarUmLeilao() {
		leiloesPage.visita();
		leiloesPage.novo().preenche("RTX 2060", 2500.00, "Ruberval", true);
		assertTrue(leiloesPage.existe("RTX 2060", 2500.00, "Ruberval", true));
	}
	
	@Test
	public void deveExigirCamposFaltantes() {
		leiloesPage.visita();
		NovoLeilaoPage novoLeilaoPage = leiloesPage.novo();
		novoLeilaoPage.preenche("", 0.0, "Ruberval", true);
		assertTrue(novoLeilaoPage.exibeMensagemDeCampoObrigatorio("Nome obrigatorio!"));
		assertTrue(novoLeilaoPage.exibeMensagemDeCampoObrigatorio("Valor inicial deve ser maior que zero!"));
	}
}
