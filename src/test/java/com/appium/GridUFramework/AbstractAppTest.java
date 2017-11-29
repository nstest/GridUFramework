package com.appium.GridUFramework;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author ssundresh
 *
 */
public abstract class AbstractAppTest extends Base {

	@Step("Navigate back one page")
	public void navigateBack() {
		// Navigate back to homepage after performing all the actions under
		// Action Sheets
		driver.navigate().back();

	}

	@Step("Close the driver after all the tests are executed")
	public void tearDown() {
		driver.quit();
	}

}
