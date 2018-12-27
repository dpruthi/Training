package com.deep.framework.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class locator {

	@FindBy(xpath="//button//span[text()='Sign in']")

    WebElement signInBtn;
	
	@FindBy(xpath="//div[@class='vdE7Oc f3GIQ']//p[text()='Use another account']")

    WebElement useAnotherAccount;

	@FindBy(id="identifierId")

    WebElement email;
	
	@FindBy(xpath="//div[text()='Enter your password']")

    WebElement passsword;
	
	@FindBy(xpath="//span[@class][text()='Next']")

    WebElement next;
	
}
