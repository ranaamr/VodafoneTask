package com.Base;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
   public static Logger logger = Logger.getLogger(TestBase.class);
   public String URL = "http://automationpractice.com/index.php";
	
	public TestBase()  {
		logger = Logger.getLogger("Open browser ");
	
			if (driver == null) {
                //set the path of chrome driver
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers\\chromedriver_1.exe");

				// Initialize browser
				driver = new ChromeDriver();

				// Open the URL
				logger.info("------------ Opening Browser ------------");
				logger.info("Open URL = " + URL);
				driver.get(URL);
				driver.manage().window().maximize();
			
			}
	}
}
