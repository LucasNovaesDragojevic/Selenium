package br.com.leilao.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage {

	private WebDriver driver;

	public LeiloesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	void visita() {
		driver.get("http://localhost:8080/leiloes");
	}
	
	NovoLeilaoPage novo() {
		driver.findElement(By.linkText("Novo Leilão")).click();
		return new NovoLeilaoPage(driver);
	}
	
	Boolean existe(String produto, Double valor, String usuario, Boolean usado) {
		return driver.getPageSource().contains(produto) &&
				driver.getPageSource().contains(String.valueOf(valor)) &&
				driver.getPageSource().contains(usuario) &&
				driver.getPageSource().contains(usado ? "Sim" : "Não");
	}

	DetalhesLeilaoPage detalhes(Integer posicao) {
		List<WebElement> elements = driver.findElements(By.linkText("exibir"));
		elements.get(posicao - 1).click();
		return new DetalhesLeilaoPage(driver);
	}
}
