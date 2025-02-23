package com.startedwithtestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * open--precondition
 * login--test
 * 
 */
public class tcloginRediff {
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}
	
	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123go");
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(5000);
	}
	
	
}
