package com.appium.GridUFramework;

import ru.yandex.qatools.allure.annotations.Step;

public class AlertViews extends Base{
	
	
	
	@Step("Click on Text Entry")
	public void clickTextEntry() {
		driver.findElementByXPath("//XCUIElementTypeStaticText[@value='Text Entry']").click();
	}
	
	@Step("Enter a Short Message")
	public void enterShortMessage() {
		driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("A Short Message");
	}
	
	@Step("Click on OK")
	public void clickOK() {
		driver.findElementByName("OK").click();
	}

}
