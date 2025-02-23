package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ohrmlogin {
	By username=By.name("username");

	   By password=By.name("password");

	   By loginBtn=By.xpath("//button[@type='submit']");

	   By forgotPwdLink=By.partialLinkText("Forgot your");

	   By OHRMLink=By.linkText("OrangeHRM, Inc");

	   By errorMsg=By.xpath("//div[@class='orangehrm-login-error']/div/div/p");

	   WebDriver driver;    

	   //Constructor

	   public Ohrmlogin(WebDriver driver) {

	       this.driver=driver;

	   }

	   //methods

	   public void setUsername(String un) {

	       driver.findElement(username).sendKeys(un);

	   }

	   public void setPassword(String pwd) {

	       driver.findElement(password).sendKeys(pwd);

	   }

	   public void clickLoginBtn() {

	       driver.findElement(loginBtn).click();

	   }

	   public void clickForgotPwdLink() {

	       driver.findElement(forgotPwdLink).click();

	   }

	public String getErrorMessage() {

	   return driver.findElement(errorMsg).getText();

	}

	public void clickOHRMLink() {

	   driver.findElement(OHRMLink).click();

	}

	

	
}
