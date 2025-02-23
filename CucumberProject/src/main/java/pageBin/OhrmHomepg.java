package pageBin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OhrmHomepg {

	By profileImage = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/img");
	By logoutLink = By.linkText("Logout");
	
	WebDriver driver;
	
	public OhrmHomepg(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void logout() {
		driver.findElement(profileImage).click();
		driver.findElement(logoutLink).click();
	}
}
