package com.appium.GridUFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends Base{

	@Step("Enter Email Address and click on Next")
	public void enterEmail() {
		driver.findElement(By.id("identifierId")).sendKeys("santhoshmaddy@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']/div[2]")).click();
		
	}
	
	@Step("Print the Headers")
	public void printHeadingText() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileIdentifier")));
		
		Assert.assertTrue(driver.findElement(By.id("headingText")).isDisplayed(), "Heading Text is displayed");
		Assert.assertTrue(driver.findElement(By.id("profileIdentifier")).isDisplayed(), "Profile Identifier is displayed");
	}
}
