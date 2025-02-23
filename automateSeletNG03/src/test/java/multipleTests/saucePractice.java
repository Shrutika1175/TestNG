package multipleTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class saucePractice {

	WebDriver driver;



	@BeforeTest

	public void beforeTest() {

	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://www.saucedemo.com");

	}

	
	@Test(dataProvider="dp")

	public void validateLoginLogout(String un,String pwd) {

	    driver.findElement(By.id("user-name")).sendKeys(un);
	    driver.findElement(By.id("password")).sendKeys(pwd);
	    driver.findElement(By.id("login-button")).click();
	    
	    if(driver.getCurrentUrl().contains("inventory.html")) {
	    	driver.findElement(By.id("react-burger-menu-btn")).click();
	    	driver.findElement(By.linkText("Logout"));
	    }
	    else {
	    	WebElement wb3=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
	    	Assert.assertTrue(wb3.getText().contentEquals("Sorry, this user has been locked out."));
	    }
	    	
	}
	@DataProvider
	public Object[][] dps() {
		Object[][] data = new Object[2][6];
		  data[0][0]="standard_user";

		   data[0][1]="secret_sauce";

		   //second row

		   data[1][0]="locked_out_user";

		   data[1][1]="secret_sauce";

		   //Third row

		   data[2][0]="problem_user";

		   data[2][1]="secret_sauce";

		   //Fourth row

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
