package SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerthandle01 {

	WebDriver driver;
	
	@BeforeTest()
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}
	
	@Test
	public void alertHandles() throws InterruptedException {
		driver.findElement(By.name("proceed")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Alert a = driver.switchTo().alert(); //targetLocator return type
		System.out.println("message displayed"+a.getText());
		Thread.sleep(3000);
	    a.accept();
	    
	    WebDriver.TargetLocator wt = driver.switchTo();
	    wt.defaultContent();
	    
	}
}
