package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericHelper {
	
	public WebDriver driver;
	
	public GenericHelper(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void SwitchToHandle() throws InterruptedException
	{
		Set<String> s1= driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		String Pwindow=i1.next();
		String Cwindow=i1.next();
		Thread.sleep(2000);
		driver.switchTo().window(Cwindow);
	}
}
