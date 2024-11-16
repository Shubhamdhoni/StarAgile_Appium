package apk_download;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

//to run the program 
//step 1 : open CMD & enter [npx appium]
//step 2 : open android studio & start virtual machine
public class ApiDemos extends SetUp_1 {
	
	@Test
	public void LaunchApp() {
		System.out.println("App installed successfully");
	}
	
	@Test(description ="drag and drop")
	public void DragDrop(){
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) source).getId(),
				"endX", 647,
				"endY", 580)
				);
	}
	
	   @Test(description = "Check application launch status")
	    public void applicationLaunchStatus() {
	        // Get the application state
	        ApplicationState appState = ((AndroidDriver) driver).queryAppState("io.appium.android.apis");

	        // Check and print the application state based on constants
	        if (appState == ApplicationState.RUNNING_IN_FOREGROUND) {
	            System.out.println("The app is currently in the foreground.");
	        } else if (appState == ApplicationState.RUNNING_IN_BACKGROUND) {
	            System.out.println("The app is currently in the background.");
	        } else if (appState == ApplicationState.NOT_RUNNING) {
	            System.out.println("The app is not running.");
	        } else {
	            System.out.println("The app is in an unknown state.");
	        }

	        // Assert that the app should be in the foreground
	        Assert.assertEquals(appState, ApplicationState.RUNNING_IN_FOREGROUND, "App should be in the foreground.");
	    }
	
}
