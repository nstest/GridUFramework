package com.appium.GridUFramework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AppTest extends AbstractAppTest
{

	HomePage homePage = new HomePage();
	ActionSheets actionSheets = new ActionSheets();
	ActivityIndicators activityIndicators = new ActivityIndicators();
	
	@Test(groups={"regression"})
	public void testActionSheets() {
		homePage.clickActionSheets();
		actionSheets.clicOkayOrCancel();
		actionSheets.clickOK();
		actionSheets.clickOther();
		actionSheets.clickSafeChoice();
		navigateBack();
	}
	
	@Test(groups={"regression"})
	public void testactivityIndicators() {
		homePage.clickActivityIndicators();
		activityIndicators.verifyGrayIndicator();
		activityIndicators.verifyTintedIndicator();
		navigateBack();
	}
	
	@AfterTest 
	public void closeDriver() {
		tearDown();
	}


}
