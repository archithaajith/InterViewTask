package com.covidTracker.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.covidTracker.qa.base.BaseTest;
import com.covidTracker.qa.pages.CovidDetailsPage;
import com.covidTracker.qa.pages.CovidTrackerPage;

public class CovidTrackerPageTest extends BaseTest {
	CovidTrackerPage covidTrackerPage;
	CovidDetailsPage covidDetailsPage;

	public CovidTrackerPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		covidTrackerPage = new CovidTrackerPage();
		covidDetailsPage = new CovidDetailsPage();
	}

	@Test(priority = 1)
	public void validateTitleText() {
		String title = "COVID-19 Tracker - India";
		String titleText = covidTrackerPage.validateTitleText();
		Assert.assertEquals(titleText, title);
	}

	@Test(priority = 2)
	public void testSelectStateAndPrintLineChartValues() {
		String state = "Goa";
		covidTrackerPage.selectState(state);
		String selectedState = covidTrackerPage.getSelectedState();
		Assert.assertEquals(selectedState, state);
	}
	@Test(priority=3)
	public void printLineChartValues()
	{
		String state = "Goa";
		covidTrackerPage.selectState(state);
		covidDetailsPage.scrollToLineChart();
		covidDetailsPage.validateLineChartDisplayed();
		covidDetailsPage.printChartValues();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
