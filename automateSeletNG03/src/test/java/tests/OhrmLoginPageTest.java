package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.OhrmHomepg;
import pages.Ohrmlogin;

public class OhrmLoginPageTest {
Ohrmlogin loginPage;
OhrmHomepg homePage;

WebDriver driver;
@BeforeTest
public void beforeTest() {
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	loginPage =new Ohrmlogin(driver); //driver chrome wala pass kiya
	
}
@Test(priority=2)
public void validateLoginWithValidCredentials() throws InterruptedException {
	loginPage.setUsername("Admin");
	loginPage.setPassword("admin123");
	loginPage.clickLoginBtn();
	Thread.sleep(2000);
	Assert.assertTrue(driver.getCurrentUrl().contains("dashboard/index"));
	homePage = new OhrmHomepg(driver);
	homePage.logout();
	
}

@Test(priority=1)
public void validateLoginWithInvalidCredentials() throws InterruptedException {
	loginPage.setUsername("Admin");
	loginPage.setPassword("admin123");
	loginPage.clickLoginBtn();
	String errorMsg= loginPage.getErrorMessage();
	Assert.assertTrue(errorMsg.equalsIgnoreCase("invalid credentials"));
}

@Test(priority=3)
public void validateForgotPwd() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
	loginPage.clickForgotPwdLink();
	Thread.sleep(2000);
	Assert.assertTrue(false);
}
}
