package tuiui;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TUIUILogin {
	
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://d1gxv4jdsl1mr6.cloudfront.net/");
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()=' User Sign in']")).click(); 
	
	driver.findElement(By.xpath("//input[@formcontrolname='Username']")).sendKeys("mohd.waseem@atmecs.com");
	driver.findElement(By.xpath("//input[@formcontrolname='Password']")).sendKeys("Atmecs@123");
	
	driver.findElement(By.xpath("//button[@type='submit']")).submit();
	
	Thread.sleep(10000);
	driver.findElement(By.id("Workbenches")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.id("Datasources")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.linkText("PENDING")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.linkText("APPROVED")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.linkText("REJECTED")).click(); 
	
	
	
	Thread.sleep(10000);
	driver.findElement(By.id("data_request_btn")).click();
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@type='submit']")).submit();
	
	String text = driver.findElement(By.xpath("(//div[@class='ng-star-inserted'])[12]")).getText();
	String expected = "At least one must be selected";
	
	Assert.assertEquals(text, expected);
	
	Thread.sleep(10000);
	
	driver.findElement(By.xpath("//button[@type='button']")).click();
	
	Thread.sleep(5000);
	driver.findElement(By.linkText("Logout")).click();
	
	driver.close();
}
}
