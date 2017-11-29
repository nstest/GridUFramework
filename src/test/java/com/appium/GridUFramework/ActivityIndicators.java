package com.appium.GridUFramework;

import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class ActivityIndicators extends Base {

	@Step("Verify if the Gray Activity Indicator is present")
	public void verifyGrayIndicator() {
		Assert.assertTrue(
				driver.findElementsByXPath(
						"//XCUIElementTypeActivityIndicator[@name='In progress']")
						.get(0).isDisplayed(),
				"GRAY Activity Indicator present");
	}

	@Step("Verify if the Tinted Activity Indicator is present")
	public void verifyTintedIndicator() {
		Assert.assertTrue(driver
				.findElementsByXPath(
						"//XCUIElementTypeActivityIndicator[@name='In progress']")
						.get(1).isDisplayed(), "TINTED Activity Indicator present");


	}


}
