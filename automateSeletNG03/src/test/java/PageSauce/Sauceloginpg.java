package PageSauce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sauceloginpg {

	By username = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	WebDriver driver;
	
	public Sauceloginpg(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setUsername(String un) {
		driver.findElement(username).sendKeys(un);
	}
	public void setPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void login() {
		driver.findElement(loginButton).click();
	}
}
