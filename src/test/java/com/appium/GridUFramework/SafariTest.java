package com.appium.GridUFramework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SafariTest extends AbstractAppTest{
	
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	
	@Test(groups={"regression"})
	public void login() {
		
		loginPage.enterEmail();
		loginPage.printHeadingText();
	}
	
	@AfterTest 
	public void closeDriver() {
		tearDown();
	}

}
