package br.com.leilao.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoLeilaoPage {

	private WebDriver driver;

	NovoLeilaoPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	void preenche(String nome, Double valor, String usuario, Boolean usado) {
		WebElement txtNome = driver.findElement(By.name("leilao.nome"));
		WebElement txtValor = driver.findElement(By.name("leilao.valorInicial"));
		
		txtNome.sendKeys(nome);
		txtValor.sendKeys(String.valueOf(valor));
		
		Select selectUsuario = new Select(driver.findElement(By.name("leilao.usuario.id")));
		selectUsuario.selectByVisibleText(usuario);
		
		if (usado) {
			WebElement checkBoxUsado = driver.findElement(By.name("leilao.usado"));
			checkBoxUsado.click();
		}
		
		txtNome.submit();
	}
	
	Boolean exibeMensagemDeCampoObrigatorio(String mensagem) {
		return driver.getPageSource().contains(mensagem);
	}
}
