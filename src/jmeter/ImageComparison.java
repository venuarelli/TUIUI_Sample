package jmeter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparison {

	public static void main(String args[]) throws IOException {
		System.setProperty("webdriver.chrome.driver", "resources\\binary\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\Venu.Aarelli\\Desktop\\gmail.png"));

		WebElement logoImageElement = driver.findElement(By.className("gb_g"));

		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);

		ImageIO.write(logoImageScreenshot.getImage(), "PNG", new File("jmeter\\Screenshots\\image.png"));

		BufferedImage actualImage = logoImageScreenshot.getImage();

		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		if (diff.hasDiff() == true) {
			System.out.println("Images are Not Same");
		} else {
			System.out.println("Images are Same");
		}

		driver.quit();

	}
}
