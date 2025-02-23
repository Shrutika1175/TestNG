package testSuit01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataTcSauceLogin {

	WebDriver driver;
	
	@BeforeTest
	public void runSauce() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Test(dataProvider="dp")
	public void validateLoginTC(String user1, String paswrd1) { //passing two parameters
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		
		
		WebElement weu = driver.findElement(By.id("user-name"));
		WebElement wep = driver.findElement(By.id("password"));
		
		js1.executeScript("arguments[0].value=user1", weu);
		js1.executeScript("arguments[0].value=paswrd1",wep);
		driver.findElement(By.id("login-button")).click();
		
	    if(driver.getCurrentUrl().contains("inventory.html")) {
	        driver.findElement(By.id("react-burger-menu-btn")).click();
	        driver.findElement(By.linkText("Logout")).click();
	    }
	    else {
	        String ErrorMsg=driver.findElement
	(By.xpath("//div[@class='error-message-container error']/h3")).getText();              
            Assert.assertTrue(ErrorMsg.contains("Sorry, this user has been locked out."));
	    }
	}
	@DataProvider
	public Object[][] dp(){    //we have got Object return type
		Object[][] data=new Object[6][2];

		   //first row

		   data[0][0]="standard_user"; 
		   
		   data[0][1]="secret_sauce";
		   
		  data[1][0]="locked_out_user";
		  
		  data[1][1]="secret_sauce";
		  
		  data[2][0]="problem_user";
		  
		  data[2][1]="secret_sauce";
		  
		  data[3][0]="performance_glitch_user";

		   data[3][1]="secret_sauce";

		   //Fifth row

		   data[4][0]="error_user";

		   data[4][1]="secret_sauce";

		   //Sixth row

		   data[5][0]="visual_user";

		   data[5][1]="secret_sauce";

     return data;
	}
	
}
