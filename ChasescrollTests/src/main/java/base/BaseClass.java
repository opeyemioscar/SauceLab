package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver; 
	public WebDriverWait wait;
	@BeforeTest
	public void build() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/v1/");
		
	}
	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
