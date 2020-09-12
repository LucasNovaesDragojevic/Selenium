package br.com.leilao.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlteraUsuarioPage {

	private WebDriver driver;

	AlteraUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}

	void altera(String nome, String email) {
		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));
		
		txtNome.clear();
		txtEmail.clear();
		
		txtNome.sendKeys(nome);
		txtEmail.sendKeys(email);
		
		driver.findElement(By.id("btnSalvar")).click();
	}
}
