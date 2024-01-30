package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class AddingToFavorites {
	
	public static final By explorePodcast = By.xpath("//android.widget.TextView[@text='Explore popular podcasts']");
	public static final By clickOnStar = By.xpath("(//android.widget.ImageView[@resource-id='com.streema.podcast:id/podcast_add'])[1]");
	public static final By clickMyPodcast = By.xpath("(//android.widget.ImageView[@resource-id='com.streema.podcast:id/icon'])[1]");
	public static final By favoriteItem = By.xpath("//android.widget.ImageView[@content-desc='Crime Junkie']");
	public static final By edit = By.xpath("//android.widget.TextView[@text='EDIT']");
	public static final By selectPodcast = By.xpath("//android.view.View[@content-desc='Delete favorite']");
	public static final By delete = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
	
	private AppiumDriver driver;
	
	public AddingToFavorites(AppiumDriver appiumDriver) {
		this.driver=appiumDriver;
	}
	
//	public void clickExplorePodcast() {
//		WebElement clickExplorePodcast = driver.findElement(explorePodcast);
//		clickExplorePodcast.click();
//	}
//	
//	public void selectFavorite() {
//		driver.findElement(clickOnStar).click();
//	}
//	
//	public void clickOnMyPodcast() {
//		driver.findElement(clickMyPodcast).click();
//	}
	
	public WebElement checkFavoriteItem() {
		return driver.findElement(favoriteItem);
	}
	
	public void AddFavorites() {
		WebElement clickExplorePodcast = driver.findElement(explorePodcast);
		clickExplorePodcast.click();
		driver.findElement(clickOnStar).click();
		driver.findElement(clickMyPodcast).click();
	}

//	public void clickOnEdit() {
//		driver.findElement(edit).click();
//	}
//	
//	public void selectThePodcast() {
//		driver.findElement(selectPodcast).click();
//	}
//	
//	public void conformDelete() {
//		driver.findElement(delete).click();
//	}
	
	public void removeFavorites() {
		driver.findElement(edit).click();
		driver.findElement(selectPodcast).click();
		driver.findElement(delete).click();
	}
}
