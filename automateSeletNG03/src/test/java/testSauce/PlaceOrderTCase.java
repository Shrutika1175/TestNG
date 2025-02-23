package testSauce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageSauce.SauceHomepg;
import PageSauce.Sauceloginpg;

public class PlaceOrderTCase {

	WebDriver driver;
	
	@BeforeTest
	public void beforetest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@Test
	public void LoginhappyPath() {
		Sauceloginpg log1 = new Sauceloginpg(driver);
		log1.setUsername("Strandard_user");
		log1.setPassword("secret_sauce");
		log1.login();
		SauceHomepg homepg1 = new SauceHomepg(driver);
		homepg1.validateHomePage();
		
	}
	
	public void addNcheckout() {
		SauceHomepg homepg2 = new SauceHomepg(driver);
		homepg2.clickAddToCart();
		
		homepg2.validateStateOfAddToCartBtn();
		homepg2.validateStateOfCartIcon();
		
		
		
	}
}
