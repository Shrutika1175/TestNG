package dummypack;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dumone {


	WebDriver driver;
	
	@BeforeTest
	public void openApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void loginPg() {
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("document.getElementById('user-name').value='user';");
	js1.executeScript("document.getElementById('password').value='paswrd';");
	driver.findElement(By.id("login-button")).click();
	}
}
