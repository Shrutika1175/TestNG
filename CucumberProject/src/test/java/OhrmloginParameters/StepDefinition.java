package OhrmloginParameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver;
	@Given("login page is open")
	public void login_page_is_open() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 
	}
	@When("Valid {string} and {string} is entered")
	public void valid_and_is_entered(String username, String password) {
	  driver.findElement(By.name("username")).sendKeys("username");
	  driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@When("login button is clicked")
	public void login_button_is_clicked() {
		driver.findElement(By.xpath("")).click();
	}
	
	
	@Then("home page should be displayed")
	public void home_page_should_be_displayed() {
	}

}

