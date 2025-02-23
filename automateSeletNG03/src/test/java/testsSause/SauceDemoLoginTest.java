package testsSause;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSauce.SauceHomepg;
import PageSauce.Sauceloginpg;

public class SauceDemoLoginTest {

	WebDriver driver;
	Sauceloginpg loginpg;
	SauceHomepg logout;
	
	@BeforeTest
	public void beforeTest() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
		loginpg = new Sauceloginpg(driver);
		logout = new SauceHomepg(driver);
	}
	@Test
	public void validateloginwithValidData() {
		loginpg.setUsername("standard_user");
		loginpg.setPassword("secret_sauce");
		loginpg.login();
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
		logout.clickburger();
		logout.clickLogout();
		
		
	}
	
	
}
