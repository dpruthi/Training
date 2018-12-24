package com.deep.framework.main;

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
		
		
	}

	}



