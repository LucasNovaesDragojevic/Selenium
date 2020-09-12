package br.com.leilao.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPage {

	private WebDriver driver;

	UsuariosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	void visita() {
		driver.get("http://localhost:8080/usuarios");
	}
	
	NovoUsuarioPage novo() {
		driver.findElement(By.linkText("Novo Usuário")).click();
		return new NovoUsuarioPage(driver);
	}
	
	Boolean existeNaListagem(String nome, String email) {
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(email);
	}
	
	Boolean existeMensagemCampoFaltante(String mensagem) {
		return driver.getPageSource().contains(mensagem);
	}
	
	void deletaUsuariosNaPosicao(Integer posicao) {
		driver.findElements(By.tagName("button")).get(posicao - 1).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	AlteraUsuarioPage editaPorPosicao(Integer posicao) {
		driver.findElements(By.linkText("editar")).get(posicao - 1).click();
		return new AlteraUsuarioPage(driver);
	}
}
