package com.appium.GridUFramework;

import org.testng.annotations.Test;

public class AppTest extends Base
{

	@Test(groups={"regression"})
	public void actionSheets() {
		
		driver.findElementByAccessibilityId("Action Sheets").click();

		driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Okay / Cancel']").click();
		driver.findElementByXPath("//XCUIElementTypeButton[@name='OK']").click();

		driver.findElementByAccessibilityId("Other").click();
		driver.findElementByAccessibilityId("Safe Choice").click();

		//Navigate back to homepage after performing all the actions under Action Sheets
		driver.navigate().back();
		
	}
	
	


}
