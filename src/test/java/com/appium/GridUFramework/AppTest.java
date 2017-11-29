package com.appium.GridUFramework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AppTest extends AbstractAppTest
{

	@Test(groups={"regression"})
	public void testActionSheets() {
		actionSheets();
		navigateBack();
	}
	
	@Test(groups={"regression"})
	public void testactivityIndicators() {
		activityIndicators();
		navigateBack();
	}
	
	@AfterTest 
	public void closeDriver() {
		tearDown();
	}


}
