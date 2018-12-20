package com.deep.framework.function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class commonFunction {

	
	WebDriver driver;
	
	
JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
	
	public void clickElementByJSExecutor(WebElement element) {
        try {
            waitForElementToDisplay(element);
            jsExecutor.executeScript("arguments[0].click();", element);
            waitForJSandJQueryToLoad();
        } catch (TimeoutException e) {
            log.error("TimeoutException when searching element by locator: " + element.toString());
            StackTraceElement[] ele = e.getStackTrace();
            for (int i = 0; i < ele.length; i++) {
                if (ele[i].toString().contains("com")) {
                    log.error(ele[i].toString());
                }
            }
        }
    }
	
	
	public void maximizeBrowserWindow() {
    	try{
    	driver.manage().window().maximize();
    	waitForJSandJQueryToLoad();
    	}
    	catch(TimeoutException e){
    		log.info("Inside Timeout Exception");
    	}
    	
    	public void waitForElementToDisplay(WebElement we) {
            wait.until((ExpectedCondition<Boolean>) driver -> {
                try {
                    return (we != null && we.isDisplayed() && we.isEnabled());
                } catch (Exception e) {
                    return false;
                }
            });
        }
    	
    	public boolean waitForJSandJQueryToLoad() {

            ExpectedCondition<Boolean> jQueryLoad = (driver) -> {
                try {
                    return (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
                } catch (Exception e) {
                    return true;
                }
            };

            ExpectedCondition<Boolean> jsLoad = (driver) -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                    .equals("complete");

            return wait.until(jQueryLoad) && wait.until(jsLoad);
        }
}

