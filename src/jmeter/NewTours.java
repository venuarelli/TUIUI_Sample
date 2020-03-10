package jmeter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours {
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "resources\\binary\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("")).findElement(By.xpath(""));
		
		String main = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while(itr.hasNext()) {
			String childWindow1 = itr.next();
			String childWindow2 = itr.next();
			
			driver.switchTo().window(childWindow1);
			driver.close();
			driver.switchTo().defaultContent();
		}
		
		for(String window : windows) {
			driver.switchTo().window(window);
		}
		
		
		
		Iterator<String> itr1 = windows.iterator();
		while(itr.hasNext()) {
			driver.switchTo().window(itr1.next());
			
		}
		
		ArrayList<String> l=new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(l.get(1));
		
		//driver.close();
	}
}