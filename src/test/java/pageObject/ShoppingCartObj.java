package pageObject;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class ShoppingCartObj {

	WebDriver driver =null; 
	
	By cartPageTitleLoc = By.xpath("//div[@class='a-row']/h1");
	By productNameInCartLoc = By.xpath("(//span[@class='a-list-item']//span[@class='a-truncate-cut'])[1]");
	By productPriceInCartLoc = By.xpath("//p[@class='a-spacing-mini']/span");
	
	public ShoppingCartObj(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void validateProductDetailInCartPage(Hashtable <String, String> productDetail) {
		
		String cartPageTitle = driver.findElement(cartPageTitleLoc).getText();
		String acutalProductName = driver.findElement(productNameInCartLoc).getText();
		String actualProductPrice =  driver.findElement(productPriceInCartLoc).getText();
		
		Assertion softAssert = new SoftAssert();
		Assert.assertEquals(cartPageTitle, "Shopping Cart");
		
		softAssert.assertEquals(acutalProductName, productDetail.get("productName"));
		Assert.assertEquals(actualProductPrice, productDetail.get("productPrice"));
	}
	
}
