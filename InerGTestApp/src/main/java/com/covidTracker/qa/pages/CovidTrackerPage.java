package com.covidTracker.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.covidTracker.qa.base.BaseTest;

public class CovidTrackerPage extends BaseTest {
	// pagefactory
	// @FinBy
	@FindBy(xpath = "//select[@class='data-filter-input']")
	private WebElement stateDropdown;

	@FindBy(xpath = "//h1[normalize-space()='COVID-19 Tracker - India']")
	private WebElement titleText;

	@FindBy(xpath = "//div[@class='leaflet-container leaflet-touch leaflet-retina leaflet-fade-anim leaflet-grab leaflet-touch-drag leaflet-touch-zoom']")
	private WebElement image;
	

	public CovidTrackerPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectState(String state) {
		selectStateByVisibleText(stateDropdown, state);
	}

	public String validateTitleText() {
		return titleText.getText();
	}

	public String getSelectedState() {
		return getSelectedOption(stateDropdown);
	}

	public boolean validateImage() {
		return image.isDisplayed();
	}

}
