package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OhrmLoginPageClass {
	By username=By.name("username");

	   
	   @FindBy(name="username")
	   WebElement name;
	   
	   @FindBy(name="password")
	   WebElement password;
	   
	   @FindBy(xpath="//button[@type='submit']")
	   WebElement loginBtn;
	   
	   @FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")
	   WebElement forgotPwdLink;

	   @FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[2]/a")
	   WebElement OHRMlink;
	   
	   @FindBy(xpath="//div[@class='orangehrm-login-error']/div/div/p")
	   WebElement errorMsg;
	   
	   WebDriver driver;    

	   //Constructor

	   public OhrmLoginPageClass(WebDriver driver) {

	       this.driver=driver;
	       PageFactory.initElements(driver, this);

	   }

	   //methods

	   public void setUsername(String un) {

	       name.sendKeys(un);

	   }

	   public void setPassword(String pwd) {

	      password.sendKeys(pwd);

	   }

	   public void clickLoginBtn() {

	       loginBtn.click();

	   }

	   public void clickForgotPwdLink() {

	       

	       forgotPwdLink.click();
	   }

	public String getErrorMessage() {

	   return errorMsg.getText();

	}

	public void clickOHRMLink() {

		OHRMlink.click();

	}

	

	
}
