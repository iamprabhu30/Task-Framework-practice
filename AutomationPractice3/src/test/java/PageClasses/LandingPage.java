package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{	
		this.driver=driver;
		
	}

	
	By search = By.xpath("//input[@type='search']");
	By productName =By.cssSelector("h4.product-name");
	By linkTopDeals =By.linkText("Top Deals");
	By addToCart=By.xpath("//button[text()='ADD TO CART']");
	By addShoppingIcon= By.xpath("//a[@class='cart-icon']");
	By proceedToCheckOut= By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	public void SearchText(String shortname)
	{
		driver.findElement(search).sendKeys(shortname);
	}
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	public void TopDealsLink()
	{
		driver.findElement(linkTopDeals).click();
	}
	public void clickonAddToCart()
	{
		driver.findElement(addToCart).click();
		driver.findElement(addShoppingIcon).click();
		driver.findElement(proceedToCheckOut).click();
	}
}