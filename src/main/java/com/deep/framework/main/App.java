package com.deep.framework.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class App {

	WebDriver driver;

	@Test(priority = 0)
	public void loadUrl() {

		System.setProperty("webdriver.chrome.driver",
				"\\C:\\Users\\deepak.pruthi\\eclipse-workspace\\autoGithub\\src\\ChromeDriver\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://www.gmail.com";

		driver.get(baseUrl);

	}

	@Test(priority = 1)
	public void newTAb() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		// CTRL+Z is now pressed (receiving application should see a "key down" event.)
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//switch to new tab
		driver.switchTo().window(browserTabs .get(1));
	}

	@Test(priority = 2)
	public void loadVideo() throws AWTException {
		String videoLink = "https://youtu.be/5FUdrBq-WFo";

		driver.get(videoLink);

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_K);

		String time = driver.findElement(By.xpath("//span[@class='ytp-time-duration']")).getText();
		System.out.println(time);

	}

}
