package testSuit01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tcsuitlink {

	
		WebDriver driver = new ChromeDriver();
		
		@BeforeTest
		public void openurl() {
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
	}
		
   @Test	
	public void validateabout() {
		driver.findElement(By.linkText("About")).click();
		Assert.assertTrue(driver.getTitle().contains("About"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	}
	@Test
	public void validatebusiness() {
		driver.findElement(By.linkText("Business")).click();
		Assert.assertTrue(driver.getTitle().contains("Business"));
	}

	@AfterMethod
	public void gobackagain() {
		driver.navigate().back();
	}
	
	@AfterTest

	   public void afterTest() {

	       driver.close();

	       System.out.println("Done..");

	   }
}
