package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class AddingToListenLater {
	public static final By listenLater = By.xpath("//android.widget.TextView[@text='Listen Later']/following-sibling::android.widget.Button");
	public static final By findEpisode = By.xpath("//android.widget.TextView[@text='Find great episodes']");
	public static final By selectEpisode = By.xpath("(//android.widget.TextView[@resource-id='com.streema.podcast:id/suggestion_name'])[1]");
	public static final By clickOnEpisode = By.xpath("(//android.widget.TextView[@resource-id='com.streema.podcast:id/podcast_name'])[1]");
	public static final By clickOnPlusIcon = By.xpath("(//android.widget.ImageView[@resource-id='com.streema.podcast:id/episode_item_options_download'])[1]");
	public static final By clickOnAddedToListenLater = By.xpath("(//android.widget.ImageView[@resource-id='com.streema.podcast:id/episode_item_options_download'])[1]");
	public static final By playEpisode = By.xpath("//android.widget.TextView[@resource-id='com.streema.podcast:id/episode_item_title']");
	public static final By clickOnPlayingEpisode = By.xpath("//android.widget.TextView[@resource-id='com.streema.podcast:id/fragment_player_name']");
//	public static final By a = By.xpath("");
//	public static final By a = By.xpath("");
//	public static final By a = By.xpath("");
	private AppiumDriver driver;
	
	public AddingToListenLater(AppiumDriver appiumDriver) {
		this.driver = appiumDriver; 
	}
	
	public WebElement addedPodcast() {
		return driver.findElement(playEpisode);
	}
	
	public void addToListenLater() {
		driver.findElement(listenLater).click();
		driver.findElement(findEpisode).click();
		driver.findElement(selectEpisode).click();
		driver.findElement(clickOnEpisode).click();
		driver.findElement(clickOnPlusIcon).click();
		driver.findElement(clickOnAddedToListenLater).click();
		
	}
	
	public void playEpisode() {
		driver.findElement(playEpisode).click();
		driver.findElement(clickOnPlayingEpisode).click();	
	}

}
