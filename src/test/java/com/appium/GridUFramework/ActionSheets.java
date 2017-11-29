package com.appium.GridUFramework;

import ru.yandex.qatools.allure.annotations.Step;

public class ActionSheets extends Base{
	
	public void clicOkayOrCancel() {
		driver.findElementByXPath(
				"//XCUIElementTypeStaticText[@name='Okay / Cancel']").click();
	}
	
	@Step("Click on Ok")
	public void clickOK() {
		driver.findElementByXPath("//XCUIElementTypeButton[@name='OK']")
		.click();
	}
	
	@Step("Click on Other")
	public void clickOther() {
		driver.findElementByAccessibilityId("Other").click();
	}

	@Step("Click on Safe Choice")
	public void clickSafeChoice() {
		driver.findElementByAccessibilityId("Safe Choice").click();
	}

}
