package com.appium.GridUFramework;

import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author ssundresh
 *
 */
public abstract class AbstractAppTest extends Base {

	@Step("Perform the actions under Action Sheets UI Control")
	public void actionSheets() {

		driver.findElementByAccessibilityId("Action Sheets").click();
		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name='Okay / Cancel']").click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name='OK']")
		.click();
		driver.findElementByAccessibilityId("Other").click();
		driver.findElementByAccessibilityId("Safe Choice").click();
	}

	@Step("Navigate back one page")
	public void navigateBack() {
		// Navigate back to homepage after performing all the actions under
		// Action Sheets
		driver.navigate().back();

	}

	@Step("Click on Activity Indicators and verify if various activity indicators are present")
	public void activityIndicators() {
		driver.findElementByAccessibilityId("Activity Indicators").click();
		Assert.assertTrue(
				driver.findElementsByXPath(
						"//XCUIElementTypeActivityIndicator[@name='In progress']")
						.get(0).isDisplayed(),
				"GRAY Activity Indicator present");

		Assert.assertTrue(driver
				.findElementsByXPath(
						"//XCUIElementTypeActivityIndicator[@name='In progress']")
						.get(1).isDisplayed(), "TINTED Activity Indicator present");

	}

	@Step("Close the driver after all the tests are executed")
	public void tearDown() {
		driver.quit();
	}

}
