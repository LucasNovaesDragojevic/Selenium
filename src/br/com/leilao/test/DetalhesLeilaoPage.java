package br.com.leilao.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalhesLeilaoPage {

	private WebDriver driver;

	DetalhesLeilaoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	void lance(String usuario, Double valor) {
		WebElement txtValor = driver.findElement(By.name("lance.valor"));
		Select selectUsuario = new Select(driver.findElement(By.name("lance.usuario.id")));
		selectUsuario.selectByVisibleText(usuario);
		txtValor.sendKeys(String.valueOf(valor));
		driver.findElement(By.id("btnDarLance")).click();
	}
	
	Boolean existeLance(String usuario, Double valor) {
		Boolean temUsuario = new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("lancesDados")), usuario));
		if (temUsuario) 
			return driver.getPageSource().contains(String.valueOf(valor));
		return false;
	}
}
