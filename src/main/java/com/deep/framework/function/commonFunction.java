package com.deep.framework.function;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class commonFunction {

	
	WebDriver driver;
	WebDriver wait;
	
	
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
	
	
    	
    	
}

