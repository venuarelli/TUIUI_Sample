package jmeter;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4jExample {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Log4jExample.class);
		
		PropertyConfigurator.configure("resources\\log4j.properties");
		Logger.getRootLogger();
		
		logger.warn("warn");
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		logger.info("Openbrowser");
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		
		driver.close();
	}

}
