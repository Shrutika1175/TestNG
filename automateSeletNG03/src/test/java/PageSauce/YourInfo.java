package PageSauce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourInfo {

	WebDriver driver;
	By firstName = By.xpath("//input[@id='first-name']");
	By lastName = By.xpath("//input[@id='last-name']");
	By pincode = By.xpath("//input[@id='pin-code']");
	By continueBtn = By.xpath("//input[@id='continue']");
	By infoTitle = By.xpath("span[@class='title']");
	public YourInfo(WebDriver driver) {
		this.driver= driver;
		
	}
	
	public void setFirstname(String fn) {
		driver.findElement(firstName).sendKeys(fn);
	}
	
	public void setLastname(String ln) {
		driver.findElement(lastName).sendKeys(ln);
	}
	
	public void setPincode(String pc) {
		driver.findElement(pincode).sendKeys(pc);
	}
	
	public void ValidateAfterCheckoutYourInfo() {
		driver.findElement(infoTitle).getText().contains("Checkout: Your Information");
	}
	
}
