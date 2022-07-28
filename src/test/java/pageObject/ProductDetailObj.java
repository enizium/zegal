package pageObject;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailObj {
	
	WebDriver driver;
	
	public ProductDetailObj(WebDriver driver) {
		this.driver = driver;
	}
	
	By productNameLoc = By.id("productTitle");
	By productPriceLoc = By.xpath("(//div[@id='apex_desktop']//span[@class='a-offscreen'])[1]");

	By addToCartBtnLoc = By.id("add-to-cart-button");
	By addedToCartMsgLoc = By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']");
				

	public void validateInProductDetailPage(Hashtable <String, String> productDetail) {
		
		String acutalProductName = driver.findElement(productNameLoc).getText();
		WebElement element= driver.findElement(productPriceLoc) ;
		String actualProductPrice=element.getAttribute("innerText");
		
		assertEquals(acutalProductName, productDetail.get("productName"));
		assertEquals(actualProductPrice, productDetail.get("productPrice"));
	}
	
	public void clickAddToCartButton() {
		driver.findElement(addToCartBtnLoc).click();
	}
	
	public void valdiateAddToCartSuccessfulMsg() {
		String successMsg = driver.findElement(addedToCartMsgLoc).getText();
		assertEquals(successMsg, "Added to Cart");
	}
	
}
