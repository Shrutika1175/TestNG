package PageSauce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SauceCartpg {

	WebDriver driver;
	By carttitle = By.xpath("//span[@class='title']");
	By removeBtn = By.xpath("//button[@name='remove-sauce-labs-']");
	By checkoutBtm = By.id("//buttom[@id='checkout']");
	
	public void checkout() {
		driver.findElement(checkoutBtm).click();
	}
	
	public void validateCartpage() {
		Assert.assertTrue(driver.findElement(carttitle).getText().contains("Your Cart"));
	}
}
