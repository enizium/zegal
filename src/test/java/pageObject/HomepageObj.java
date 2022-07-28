package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomepageObj {
	
	WebDriver driver =null;
	
	public HomepageObj(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchTextboxLoc = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchBtnLoc = By.id("nav-search-submit-button");
	By cartIconLoc = By.id("nav-cart-count");
	
	public void searchTextbox(String product) {
		driver.findElement(searchTextboxLoc).sendKeys(product);
	}
	
	public void clickSearchBtn() {
		driver.findElement(searchBtnLoc).click();
	}
	
	public void clickcartIcon() {
		driver.findElement(cartIconLoc).click();
	}
}
