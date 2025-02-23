package UI_takingScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingScreenShotEx {

	public static void main(String args[]) throws IOException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		
		try {
			driver.findElement(By.name("qs")).sendKeys("selenium");
			
		}
		catch(Exception e) {
			
			TakesScreenshot ts =(TakesScreenshot) driver;
			File tempFile = ts.getScreenshotAs(OutputType.FILE);
			File desFile = new File("C:\\Users\\DELL\\eclipse-workspace\\seleniumTestNG\\automateSeletNG03\\src\\test\\resources\\ScreenShots");
			
			FileUtils.copyFile(tempFile, desFile);
			System.out.println("done...");
		}
	}
}
