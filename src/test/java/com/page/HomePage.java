package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class HomePage {
	
	public static final By cancelIcon = By.xpath("//android.widget.ImageView[@resource-id='com.streema.podcast:id/close_button']");
	public static final By selectType = By.xpath("(//android.widget.ImageView[@resource-id='com.streema.podcast:id/item_onboarding_grid_image'])[1]");
	public static final By clickContinue = By.xpath("//android.widget.Button[@resource-id='com.streema.podcast:id/regularButton']");
	public static final By title = By.xpath("(//android.widget.TextView[@text='My Podcasts'])[1]");
	
	private AppiumDriver driver;
	
	public HomePage(AppiumDriver appiumDriver) {
		this.driver = appiumDriver;
	}

//	public void clickCancelIcon() {
//		WebElement cancelIcon1 = driver.findElement(cancelIcon);
//		cancelIcon1.click();
//	}
//	
//	public void selectType() {
//		driver.findElement(selectType).click();
//	}
	
	public void clickContinue() {
		WebElement cancelIcon1 = driver.findElement(cancelIcon);
		cancelIcon1.click();
		driver.findElement(selectType).click();
		driver.findElement(clickContinue).click();
	}
	
	public WebElement checkTitle() {
		return driver.findElement(title);
	}
	
	

}
