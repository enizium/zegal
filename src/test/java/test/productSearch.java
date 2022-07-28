package test;

import java.util.Hashtable;

import org.testng.annotations.Test;

import pageObject.HomepageObj;
import pageObject.ProductDetailObj;
import pageObject.SearchResultObj;
import pageObject.ShoppingCartObj;
import setup.BaseClass;

public class productSearch  extends BaseClass  {
	
	 String projectPath = System.getProperty("user.dir");
	 Hashtable <String, String> productDetail;
	 
	 String product = "Gaming Mouse";
	 @Test
	 public void amazonProductSearch() {
		 HomepageObj homepageObj= new HomepageObj(driver);
		 homepageObj.searchTextbox(product);
		 homepageObj.clickSearchBtn();
		 
		 SearchResultObj searchResultObj = new SearchResultObj(driver);
		 searchResultObj.validateSearchResultFor(product);
		 productDetail = searchResultObj.selectFirstProduct();
		 
		 ProductDetailObj productDetailObj = new ProductDetailObj(driver);
		 productDetailObj.validateInProductDetailPage(productDetail);
		 productDetailObj.clickAddToCartButton();
		 productDetailObj.valdiateAddToCartSuccessfulMsg();
		 
		 homepageObj.clickcartIcon();
		 
		 ShoppingCartObj shoppingCartObj = new ShoppingCartObj(driver);
		 shoppingCartObj.validateProductDetailInCartPage(productDetail);
		 
		 
	 }

}
