package jmeter;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementScreenshot {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		WebElement logo = driver.findElement(By.id("hplogo"));
		
		WebElement logo1 = driver.findElement(By.linkText("About"));
		
		File srcFile = logo.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("Screenshots/logo1.png"));
		
		File srcFile1 = logo1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile1, new File("Screenshots/logo.png"));
		
		
	}

}
