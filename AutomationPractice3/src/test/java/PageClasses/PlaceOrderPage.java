package PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaceOrderPage {
	
	public WebDriver driver;
	public PlaceOrderPage(WebDriver driver)
	{	
		this.driver=driver;
		
	}

	
	By btnPlaceOrder= By.xpath("//button[text()='Place Order']");
	By ddCountry = By.xpath("//select[@style='width: 200px;']/option[text()='Select']");
	By chkbxtemrsandCondition= By.xpath("//input[@type='checkbox']");
	By btnProceed= By.xpath("//button[text()='Proceed']");
	
	public void clickOnPlaceOrder()
	{
		driver.findElement(btnPlaceOrder).click();
	}
	public String selectDDCountry(String country)
	{
		driver.findElement(ddCountry).click();
		WebElement country1= driver.findElement(By.xpath("//select[@style='width: 200px;']/option[text()='"+country +"']"));
		country1.click();
		return country;
	}
	public void clickTermsandCondition()
	{
		driver.findElement(chkbxtemrsandCondition).click();
	}
	public void clickOnproceed()
	{
		driver.findElement(btnProceed).click();
	}
}
