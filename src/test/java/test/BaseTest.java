package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BaseTest {
	WebDriver driver;
	String browserName;

	@Test
	public void browserSet() throws IOException {
		
		FileInputStream obj=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/res/data.properties");
		
		Properties prop=new Properties();
		
		prop.load(obj);
		
		//browserName=prop.getProperty("browser"); // to run  from properties file 
	browserName=System.getProperty("browser"); //to run it from cmd
		String url=prop.getProperty("url");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");

		driver=new ChromeDriver();
		driver.get(url);
		}
		
		else {
			
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");

			driver= new FirefoxDriver();
			driver.get(url);
		}
	
	
	}
	
	
	
	

}
