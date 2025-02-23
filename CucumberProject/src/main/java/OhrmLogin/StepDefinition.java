package OhrmLogin;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageBin.OhrmHomepg;
import pageBin.OhrmLoginPageClass;

public class StepDefinition {
	OhrmLoginPageClass loginpg;
	OhrmHomepg homepg;
	WebDriver driver;
	
	@Given("login page is open")
	public void login_page_is_open() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@When("Valid username and password is entered")
	public void valid_username_and_password_is_entered() {
		loginpg = new OhrmLoginPageClass(driver);
        loginpg.setUsername("Admin");
        loginpg.setPassword("admin123");
	   
	}
	@When("login button is clicked")
	public void login_button_is_clicked() {
		loginpg.clickLoginBtn();
	}
	@Then("home page should be displayed")
	public void home_page_should_be_displayed() {
	    homepg =new OhrmHomepg(driver);
	    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard/index"));
	}


}
