package baseTest;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class SauceTest extends BaseClass {
	@Test(priority = 3)
	public void Test() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	@Test(priority = 2)
	public void verifyDiaplayLogin() {
		WebElement confirm = driver.findElement(By.id("login-button"));
		Assert.assertNotNull(confirm);
		
	}
	
	@Test(priority = 1)
	public void thirdTest() {
		WebElement displayed = driver.findElement(By.xpath("//img[@class='bot_column1']"));
		displayed.isDisplayed();
		
	}
	
	

}

