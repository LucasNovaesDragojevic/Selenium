import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\GeckoDriver\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");
		
		WebElement campoTexto = driver.findElement(By.name("q"));
		
		campoTexto.sendKeys("pudim");
		
		campoTexto.submit();
	}

}
