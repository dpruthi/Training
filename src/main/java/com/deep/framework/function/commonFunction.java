package com.deep.framework.function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunction {

	WebDriver driver;
	WebDriverWait wait;

	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

	public void clickElementByJSExecutor(WebElement element) {
		try {

			jsExecutor.executeScript("arguments[0].click();", element);

		} catch (TimeoutException e) {
			System.out.println("TimeoutException when searching element by locator: " + element.toString());
			StackTraceElement[] ele = e.getStackTrace();
			for (int i = 0; i < ele.length; i++) {
				if (ele[i].toString().contains("com")) {
					System.out.println(ele[i].toString());
				}
			}
		}
	}

	public boolean explicitWait(By locator) {
		try {
			wait = new WebDriverWait(driver, 7200);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	public boolean explicitWait(WebElement element) {
		try {
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	public Actions ac;

	public void move(WebElement element) {
		explicitWait(element);
		ac = new Actions(driver);
		ac.moveToElement(element).build().perform();

	}

	public void isselected(WebElement element) {
		if (element.isSelected() == true) {
			System.out.println("Checkbox is already selected");
		} else {
			element.click();
		}
	}

}
