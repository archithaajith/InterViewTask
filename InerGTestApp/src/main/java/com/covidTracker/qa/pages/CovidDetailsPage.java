package com.covidTracker.qa.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.covidTracker.qa.base.BaseTest;

public class CovidDetailsPage extends BaseTest {
	@FindBy(xpath = "//body/div[@id='root']/div[@class='container']/div[3]/div[1]/div[1]/div[1]")
	private WebElement lineChart;

	@FindBy(xpath = "//*[name()='svg']//*[local-name()='rect']")
	List<WebElement> lineChartPoints;
	
//	@FindBy(xpath="//body/div[@id='root']/div[@class='container']/div[3]/div[1]/div[1]/div[1]")
//	private WebElement tooltip;


	public CovidDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public void scrollToLineChart() {
		scrollToElement(lineChart);
	}

	public boolean validateLineChartDisplayed() {
		return lineChart.isDisplayed();

	}

	public void printChartValues() {
		printLineChartValues(lineChartPoints);
	}
}