package jmeter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Sikuli {

	public static void main(String[] args) throws InterruptedException, FindFailed 
	{
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		Screen scr = new Screen();
		
		scr.click("C:\\JMeter\\Capture.PNG");
		
		driver.close();
	}
}
