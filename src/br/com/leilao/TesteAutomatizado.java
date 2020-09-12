package br.com.leilao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
		testeFirefox();
		
		testeChrome();
	}

	private static void testeChrome() {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		WebElement campoTexto = driver.findElement(By.name("q"));
		
		campoTexto.sendKeys("pudim");
		
		campoTexto.submit();
	}

	private static void testeFirefox() {
		System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");
		
		WebElement campoTexto = driver.findElement(By.name("q"));
		
		campoTexto.sendKeys("pudim");
		
		campoTexto.submit();
		
		driver.get("http://www.bing.com");
		
		campoTexto = driver.findElement(By.name("q"));
		
		campoTexto.sendKeys("pudim");
		
		campoTexto.submit();
	}

}
