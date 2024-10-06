package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
	public WebDriver driver;
	public OfferPage(WebDriver driver)
	{	
		this.driver=driver;
		
	}

	
	By search= By.xpath("//input[@type='search']");
	By productName=By.xpath("//tbody/tr/td[1]");
	
	public void SearchText(String shortname)
	{
		driver.findElement(search).sendKeys(shortname);
	}
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
}
