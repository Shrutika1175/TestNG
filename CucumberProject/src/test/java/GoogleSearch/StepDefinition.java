package GoogleSearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver;
	
	@Given("google search page is open")
	public void google_search_page_is_open() {
	   driver =new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("");
	}
	@When("Query is entered in search")
	public void query_is_entered_in_search() {
	    
	}
	@When("enter key is pressed")
	public void enter_key_is_pressed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the searched results appear on screen")
	public void the_searched_results_appear_on_screen() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
