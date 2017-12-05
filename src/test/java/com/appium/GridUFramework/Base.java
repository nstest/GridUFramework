package com.appium.GridUFramework;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Base {

	static IOSDriver<IOSElement> driver = null;
	
	Properties prop = new Properties();
	InputStream input = null;
	
	
	@BeforeSuite
	public void setup() throws IOException, MalformedURLException {
		startServer();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String strPlatform = System.getProperty("platform");
		if(strPlatform.equalsIgnoreCase("iosApp")) {
			System.out.println("Performing validation on: " + System.getProperty("platform"));
			String path = System.getProperty("user.dir") + "/resources/app.properties";
			input = new FileInputStream(path);
			prop.load(input);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			capabilities.setCapability(MobileCapabilityType.APP, prop.getProperty("appLocation"));
		} else if(strPlatform.equalsIgnoreCase("iosSafari")) {
			System.out.println("Performing validation on: " + System.getProperty("platform"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("browserDevice"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("browserPlatform"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("browserPlatformVersion"));
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, prop.getProperty("browserName"));
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			capabilities.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver.get(prop.getProperty("testURL"));
		}
		
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//Start the Appium server using appium and node(Opening GUI version of Appium using code, an headless mode approach)
//	@BeforeSuite
	public void startServer() throws IOException {
		String path = System.getProperty("user.dir") + "/resources/app.properties";
		input = new FileInputStream(path);
		prop.load(input);
		
		CommandLine command = new CommandLine(prop.getProperty("nodePath"));
		command.addArgument(prop.getProperty("appiumPath"),
				false);
		command.addArgument("--address", false);
		command.addArgument(prop.getProperty("hostIP"));
		command.addArgument("--port", false);
		command.addArgument(prop.getProperty("portNumber"));
		command.addArgument("--full-reset", false);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(5000);
			System.out.println("Appium server started.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}




