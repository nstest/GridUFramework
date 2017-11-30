package com.appium.GridUFramework;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.FileInputStream;
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
	
	
	@BeforeMethod
	public void setup() throws IOException, MalformedURLException {
		String path = System.getProperty("user.dir") + "/resources/app.properties";
		input = new FileInputStream(path);
		prop.load(input);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability(MobileCapabilityType.APP, prop.getProperty("appLocation"));
		
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		if(type.equals("iosApp")) {
//			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
//			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//			capabilities.setCapability(MobileCapabilityType.APP, "/Users/ssundresh/Desktop/UICatalog.app");
//
//		} else if(type.equals("safariBrowser")) {
//			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
//			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.1");
//			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
//			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//			capabilities.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);
//		}
	}

	//Start the Appium server using appium and node(Opening GUI version of Appium using code, an headless mode approach)
	@BeforeSuite
	public void startServer() {
		
		CommandLine command = new CommandLine(
				"/usr/local/bin/node");
		command.addArgument(
				"/usr/local/bin/appium",
				false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4723");
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




