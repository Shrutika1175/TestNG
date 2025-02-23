package PageSauce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SauceHomepg {

	By burgerBtn = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
	By logoutLink = By.linkText("Logout");
	By resetAppState =By.partialLinkText("Reset");
	By crossoutBurgerBtn =By.id("react-burger-cross-btn");
	
	By addToCart01Btn =By.id("add-to-cart-sauce-labs-bike-light");
	By cartIcon = By.xpath("//a[@class='shopping_cart_link']");
	By shoppingCartBadge = By.xpath("//span[@class='shopping_cart_badge']");
	By continueShoppingBtn =By.xpath("//button[@id='continue-shopping']");
	WebDriver driver;
	public SauceHomepg(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickburger() {
		driver.findElement(burgerBtn).click();
		
}
	public void clickAddToCart() {
		
		//If an item is already present in the cart,this if statement checks for it
		//if true-- it executes the statements that will reset the app state.
		if(driver.findElement(shoppingCartBadge).isDisplayed()) {
		driver.findElement(burgerBtn).click();
		driver.findElement(resetAppState).click();
		driver.findElement(crossoutBurgerBtn).click();
		
		//to reset the remove button to add to cart state
		driver.findElement(cartIcon).click();
		driver.findElement(continueShoppingBtn).click();
		}
		
		driver.findElement(addToCart01Btn).click();
		
	}
	public void validateHomePage() {
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
	}
	
	public void validateStateOfAddToCartBtn() {
		Assert.assertTrue(driver.findElement(addToCart01Btn).getText().contains("Remove"));
		}
	
	public void  validateStateOfCartIcon() {
		Assert.assertTrue(driver.findElement(shoppingCartBadge).isDisplayed());
	}
	
	public void clickLogout() {
		driver.findElement(logoutLink).click();
	}
}