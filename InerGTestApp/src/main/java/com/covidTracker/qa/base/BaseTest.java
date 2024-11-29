package com.covidTracker.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.covidTracker.qa.util.TestUtil;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;

	public BaseTest() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\covidTracker\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Downloads\\chromedriver\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Downloads\\geckodriver-v0.35.0-win-aarch64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
	}

	public void selectStateByVisibleText(WebElement dropdownElement, String state) {
		Select select = new Select(dropdownElement);
		select.selectByVisibleText(state);
	}

	public String getSelectedOption(WebElement dropdownElement) {
		Select select = new Select(dropdownElement);
		return select.getFirstSelectedOption().getText();
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0]. scrollIntoView(true);", element);
	}

	public void printLineChartValues(List<WebElement> lineChartPoints) {
		Actions actions = new Actions(driver);
		for (WebElement point : lineChartPoints) {
			actions.moveToElement(point).perform();
			String x = point.getDomAttribute("x");
			String y = point.getDomAttribute("y");
			String width = point.getDomAttribute("width");
			String height = point.getDomAttribute("height");
			System.out.println("x: " + x + ", y: " + y + ", width: " + width + ", height: " + height);
		}
	}
}
//public void printLineChartValues(List<WebElement> lineChartPoints) {
//	Actions actions = new Actions(driver);
//	  for (int i = 0; i < lineChartPoints.size(); i++) {
//          WebElement svgElement = lineChartPoints.get(i);
//          actions.moveToElement(svgElement).perform();
//          try {
//              Thread.sleep(2000);  // 
//          } catch (InterruptedException e) {
//              e.printStackTrace();
//          }
//	  }
//}
//}
//public void printLineChartValues(List<WebElement> lineChartPoints, WebElement tooltip) {
//Actions actions = new Actions(driver);
//for (WebElement point : lineChartPoints) {
//	actions.moveToElement(point).perform();
//	String toolTipText = tooltip.getDomAttribute("value");
//	System.out.println("Tooltip value :"+toolTipText);
//}
//  public void printLineChartValues(List<WebElement> lineChartPoints) {
//    	Actions actions = new Actions(driver);
//    	for (WebElement point : lineChartPoints) {
//    		System.out.println(lineChartPoints);
//    		actions.moveToElement(point).perform();
//    		String toolTipText = point.getDomAttribute("value");
//    		System.out.println("Tooltip value :"+toolTipText);
//        }
//}
//
//}
//	
