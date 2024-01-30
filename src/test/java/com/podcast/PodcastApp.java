package com.podcast;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.Capabilities;
import com.page.AddingToFavorites;
import com.page.AddingToListenLater;
import com.page.HomePage;

public class PodcastApp extends Capabilities{

	private HomePage homePage;
	private AddingToFavorites addingToFavorites;
	private AddingToListenLater addingToListenLater;
	
	@BeforeTest
	public void pagesInitilization() {
		homePage = new HomePage(driver);
		addingToFavorites = new AddingToFavorites(driver);
		addingToListenLater = new AddingToListenLater(driver);
	}
	
	@Test(priority = 1,description = "Starting page in Podcast App")
	public void welcomePage() {
		test = extent.createTest("Welcome Page");
		homePage.clickContinue();
		test.log(Status.INFO, "Verifiying if Podacst is displayed");
		boolean istitleDisplayed = homePage.checkTitle().isDisplayed();
		Assert.assertTrue(istitleDisplayed, "My Podcast Title should be displayed");
		test.log(istitleDisplayed ? Status.PASS : Status.FAIL, istitleDisplayed ? "My Podcast is displayed" : "My Podacst is not displayed");
	}
	
	@Test(priority = 2, description = "Adding podcasts to favorites")
	public void addingFavorites() {
		test = extent.createTest("Adding podcast to favorite");
		addingToFavorites.removeFavorites();
//		test.log(Status.INFO, "Verify Podcast is removed");
//		boolean isPodcastRemoved= addingToFavorites.checkFavoriteItem().is;
//		Assert.assertFalse(isPodcastRemoved, "Podcast should be removed");
//		test.log(isPodcastRemoved ? Status.PASS : Status.FAIL, isPodcastRemoved ? "Podcast is not removed" : "Podacst is  removed");
		test.log(Status.INFO, "Verify Podcast is added");
		addingToFavorites.AddFavorites();
		boolean isPodcastAdded= addingToFavorites.checkFavoriteItem().isDisplayed();
		Assert.assertTrue(isPodcastAdded,"Favorite Podcast should be added");
		test.log(isPodcastAdded ? Status.PASS : Status.FAIL, isPodcastAdded ? "Podcast is Added" : "Podacst is not added");

	}
	
	@Test(priority = 3, description = "Adding podcats to listen later")
	public void AddingListenLater() throws InterruptedException {
		test = extent.createTest("Adding podcast to Listen Later");
		test.log(Status.INFO, "Verify podcast is added to Listen Later");
		addingToListenLater.addToListenLater();
		boolean isEpisodeAdded = addingToListenLater.addedPodcast().isDisplayed();
		Assert.assertTrue(isEpisodeAdded, "Episode should be added to listen later");
		test.log(isEpisodeAdded ? Status.PASS : Status.FAIL, isEpisodeAdded ? "Episode is added" : "Episode is not added");
		addingToListenLater.playEpisode();
		Thread.sleep(20000);
	}
	
	
}
