package PageSauce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceOverviewPg {

	By FinishButton = By.xpath("button[@id='finish']");
	WebDriver driver;
	
	public SauceOverviewPg(WebDriver driver) {
		this.driver=driver;
	}
	
	public void finish() {
		driver.findElement(FinishButton).click();
	}
}
