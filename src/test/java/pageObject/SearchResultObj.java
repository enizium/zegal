package pageObject;

import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultObj {
	WebDriver driver = null;
	
	public SearchResultObj (WebDriver driver) {
		this.driver = driver;
	}

	By searchResultFor =  By.xpath("//span[@class='a-color-state a-text-bold']");
	By firstResultName = By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]");
	By firstResultPrice = By.xpath("(//span[@class='a-offscreen'])[1]");
	
	
	public void validateSearchResultFor(String expectedResultFor) {
		String actualSearchResultFor = driver.findElement(searchResultFor).getText();
		actualSearchResultFor =  actualSearchResultFor.replace("\"", "");
		assertEquals(actualSearchResultFor, expectedResultFor);
	}
	
	public Hashtable<String, String> selectFirstProduct() {
		Hashtable<String, String> productDetail = new Hashtable<String, String>();
		String productName = driver.findElement(firstResultName).getText();
		
		WebElement element= driver.findElement(firstResultPrice) ;
		String productPrice=element.getAttribute("innerText");
		
		productDetail.put("productName", productName);
		productDetail.put("productPrice", productPrice);
		
		driver.findElement(firstResultName).click();
		
		return productDetail;
		
	}
}
