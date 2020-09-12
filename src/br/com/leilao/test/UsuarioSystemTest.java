package br.com.leilao.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuarioSystemTest {

	private WebDriver driver;

	@BeforeClass
	public static void iniciaClasse() {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
	}
	
	@Before
	public void iniciaMetodo() {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/usuarios");
		driver.findElement(By.linkText("Novo Usuário")).click();
	}
	
	@After
	public void terminaMetodo() {
		driver.close();
	}
	
	@Test
	public void deveAdicionarUmUsuario() {
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));
		
		nome.sendKeys("Jandira");
		email.sendKeys("jandira@email.com");
		
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		boolean achouNome = driver.getPageSource().contains("Jandira");
		boolean achouEmail = driver.getPageSource().contains("jandira@email.com");

		assertTrue(achouNome);
		assertTrue(achouEmail);
	}
	
	@Test
	public void deveExigirNomeDeUsuario() {
		WebElement email = driver.findElement(By.name("usuario.email"));
		
		email.sendKeys("jandira@email.com");
		
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		boolean exigiNome = driver.getPageSource().contains("Nome obrigatorio!");
		boolean achouEmail = driver.getPageSource().contains("jandira@email.com");

		assertTrue(exigiNome);
		assertTrue(achouEmail);
	}
	
	@Test
	public void deveExigirEmailDeUsuario() {
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		
		nome.sendKeys("Jandira");
		
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		boolean exigiEmail = driver.getPageSource().contains("E-mail obrigatorio!");
		boolean achouNome = driver.getPageSource().contains("Jandira");

		assertTrue(exigiEmail);
		assertTrue(achouNome);
	}
}
