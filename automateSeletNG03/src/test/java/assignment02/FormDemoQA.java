package assignment02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormDemoQA {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN);
	}
	@Test
	public void name() {
		driver.findElement(By.id("firstName")).sendKeys("Fiona");
		driver.findElement(By.id("lastName")).sendKeys("Apples");
		driver.findElement(By.xpath("//input[@id='gender-radio-2']")).click();
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("nothingsgonnachange@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys("9623451782");
		driver.findElement(By.id("dateOfBithInput")).sendKeys("11 Nov 2011");
		driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[2]"))
		.sendKeys("Maths");
		driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[2]"))
		.sendKeys("English");
	}
	
	
}
