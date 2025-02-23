package abhaViaAadhaar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AadhaarValidation {
	WebDriver driver;
@BeforeTest
public void beforeTest() {
	driver = new ChromeDriver();
	driver.get("https://abdmv3.lite.mybahmni.in/bahmni/home/index.html#/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.id("username")).sendKeys("superman");
	driver.findElement(By.id("password")).sendKeys("Admin123");
	driver.findElement(By.className("confirm")).click();
	
}
	@Test
	public void selectClinic() {
		driver.findElement(By.className("confirm")).click();
}
	@Test
	public void selectRegistrationform() {
		driver.findElement(By.className("fa-user")).click();
		driver.findElement(By.className("nav-link")).click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//*[@id=\"view-content\"]/div[3]/div/div/form/div[2]/div/div/section[5]/extra-patient-identifiers/section/div[1]/article[1]/div[3]/div/span[3]/button"))
		.click();
		
	}
	
	public void fillAadhaarconsent() {
		WebElement ifm = driver.findElement(By.id("extension-popup"));
		driver.switchTo().frame(ifm);
		driver.findElement(By.id("aadhaar")).sendKeys("123456789012");
		driver.findElement(By.className("identifier-ui")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.className("concent-screen")).sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN);
		
	}
}