package com.startedwithtestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tcloginOhrm {

	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void loadurl() {
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void loginOhrm() {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("document.getElementsByName('username')[0].value='Admin';");
		je.executeScript("document.getElementsByName('password')[0].value='admin123';");
		driver.findElement(By.cssSelector("body")).sendKeys("Keys.PAGE_DOWN");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
	}
}
