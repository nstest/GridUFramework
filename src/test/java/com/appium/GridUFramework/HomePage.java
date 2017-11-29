package com.appium.GridUFramework;

import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends Base{
	
	@Step("Click on Action Sheets")
	public void clickActionSheets() {
		driver.findElementByAccessibilityId("Action Sheets").click();
	}
	
	@Step("Click on Activity Indicators")
	public void clickActivityIndicators() {
		driver.findElementByAccessibilityId("Activity Indicators").click();
	}
	
	

	
	
}
