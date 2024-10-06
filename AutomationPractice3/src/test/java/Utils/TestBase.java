package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	
	public WebDriver driver;
	public final static int TIMEOUT = 10;
	public WebDriver WebDriverManager() throws IOException
	{

		
				ChromeOptions options= new ChromeOptions();
				Proxy proxy = new Proxy();
				proxy.setSslProxy("http://127.0.0.1:9000");
				options.setProxy(proxy);
				
				
		FileInputStream fileInputStream =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String Url=properties.getProperty("QAurl");
		
		
		if (driver ==null)
		{
			if(properties.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
				driver.manage().window().maximize();
				driver.navigate().to(Url);
				
			}
			if(properties.getProperty("browser").equalsIgnoreCase("edge"))
			{
				driver=new EdgeDriver();
				driver.manage().window().maximize();
				driver.get(Url);
				
			}
			
		}
		return driver;
	}

}
