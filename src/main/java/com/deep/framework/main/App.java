package com.deep.framework.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class App {

WebDriver driver;

	@Test(priority = 0)
	public void loadUrl() throws InterruptedException {

		By logIn = By.xpath("//button[contains(text(),'Log In')]");

		By emailId = By.xpath("//input[@class='form-control'][@id='inputEmail3']");

		By passwords = By.xpath("//input[@class='form-control'][@id='inputPassword3']");

		System.setProperty("webdriver.chrome.driver",
				"\\C:\\Users\\deepak.pruthi\\eclipse-workspace\\autoGithub\\src\\ChromeDriver\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("http://automationpractice.com/index.php");
		driver.get("https://featuretest.truenorthlogic.com");
		Thread.sleep(2000);
		driver.findElement(emailId).sendKeys("ushamsi@truenorthlogic.com");
		driver.findElement(passwords).sendKeys("F8j9FkZX2");
		driver.findElement(logIn).click();
		Thread.sleep(7000);

	}

	}

