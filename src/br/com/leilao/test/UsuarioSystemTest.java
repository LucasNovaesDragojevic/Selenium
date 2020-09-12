package br.com.leilao.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuarioSystemTest {

	private WebDriver driver;
	private UsuariosPage usuariosPage;

	@BeforeClass
	public static void iniciaClasse() {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
	}
	
	@Before
	public void iniciaMetodo() {
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/apenas-teste/limpa");
		usuariosPage = new UsuariosPage(driver);
	}
	
	@After
	public void terminaMetodo() {
		driver.get("http://localhost:8080/apenas-teste/limpa");
		driver.close();
	}
	
	@Test
	public void deveAdicionarUmUsuario() {
		usuariosPage.visita();
		usuariosPage.novo().cadastra("Jandira", "jandira@email.com");
		assertTrue(usuariosPage.existeNaListagem("Jandira", "jandira@email.com"));
	}
	
	@Test
	public void deveExigirNomeDeUsuario() {
		usuariosPage.visita();
		usuariosPage.novo().cadastra("", "jandira@email.com");
		assertTrue(usuariosPage.existeMensagemCampoFaltante("Nome obrigatorio!"));
	}
	
	@Test
	public void deveExigirEmailDeUsuario() {
		usuariosPage.visita();
		usuariosPage.novo().cadastra("Jandira", "");
		assertTrue(usuariosPage.existeMensagemCampoFaltante("E-mail obrigatorio!"));
	}
	
	@Test
	public void deveExcluirUsuario() {
		usuariosPage.visita();
		usuariosPage.novo().cadastra("Jandira", "jandira@email.com");
		usuariosPage.deletaUsuariosNaPosicao(1);
	}
	
	@Test 
	public void deveEditarUsuario() {
		usuariosPage.visita();
		usuariosPage.novo().cadastra("Jandira", "jandira@email.com");
		usuariosPage.editaPorPosicao(1).altera("Jucimara", "jucimara@email.com");
		assertTrue(usuariosPage.existeNaListagem("Jucimara", "jucimara@email.com"));
	}
}
