package com.deep.framework.main;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class App {

	WebDriver driver;

	@Test(priority = 0)
	public void loadUrl() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"\\C:\\Users\\deepak.pruthi\\eclipse-workspace\\autoGithub\\src\\ChromeDriver\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com");
		

		String baseUrl = "https://www.youtube.com";
		String videoLink = "https://youtu.be/5FUdrBq-WFo";

		driver.get(baseUrl);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab
		driver.get(videoLink);

	}

}
