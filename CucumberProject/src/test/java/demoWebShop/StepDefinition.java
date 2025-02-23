package demoWebShop;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 


public class StepDefinition {
	WebDriver driver;
	@Given("The registration page should be open")
	public void the_registration_page_should_be_open() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/register");
	    
	}
	@When("User enters the input fields of the form and clicks on register button")
	public void user_enters_the_input_fields_of_the_form_and_clicks_on_register_button() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.id("gender-male")).click();
	    driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("Kiran");
	    driver.findElement(By.id("lastName")).sendKeys("Kolada");
	    driver.findElement(By.id("Email")).sendKeys("Kiran@gmail.com");
	    
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN);
	    Thread.sleep(3000);
	    driver.findElement(By.id("Password")).sendKeys("saldlw124");
	    driver.findElement(By.id("ConfirmPassword")).sendKeys("saldlw124");
	    driver.findElement(By.id("register-button")).click();
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
	    
	}
	@Then("Display a message of registation successful")
	public void display_a_message_of_registation_successful() {
	  Assert.assertTrue(driver.getCurrentUrl().contains("registerresult/1"));
	}



}
