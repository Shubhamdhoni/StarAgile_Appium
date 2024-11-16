package Demo.StarAgile_Appium;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import apk_download.SetUp_1;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

public class Assignment2 extends SetUp_1 {

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

    @Test(description = "Send app to background and verify its state")
    public void backgroundAndForegroundTest() {
        // Cast driver to AndroidDriver
        AndroidDriver androidDriver = (AndroidDriver) driver;

        // Check initial state (should be foreground)
        ApplicationState initialAppState = androidDriver.queryAppState("io.appium.android.apis");
        Assert.assertTrue(initialAppState == ApplicationState.RUNNING_IN_FOREGROUND, "App should initially be in the foreground.");
        System.out.println("Initial app state: The app is in the foreground.");

        // Send app to background for 5 seconds
        androidDriver.runAppInBackground(Duration.ofSeconds(5));

        // Check state again after returning to the foreground
        ApplicationState appStateAfterBackground = androidDriver.queryAppState("io.appium.android.apis");
        Assert.assertTrue(appStateAfterBackground == ApplicationState.RUNNING_IN_FOREGROUND, "App should return to the foreground after backgrounding.");
        System.out.println("App state after backgrounding: The app is back in the foreground.");
    }

 /*   @Test(description = "Uninstall the app")
    public void uninstallApp() {
        // Cast the driver to AndroidDriver
        AndroidDriver androidDriver = (AndroidDriver) driver;

        // Uninstall the app
        androidDriver.removeApp("io.appium.android.apis");
        System.out.println("App uninstalled successfully.");

        // Verify the app is uninstalled
        boolean isAppInstalled = androidDriver.isAppInstalled("io.appium.android.apis");
        Assert.assertFalse(isAppInstalled, "The app should be uninstalled.");
        System.out.println("Verified: The app has been uninstalled.");
    }
  
    @Test(description = "Install the app using installApp command", dependsOnMethods = "uninstallApp")
    public void installApp() {
        // Cast driver to AndroidDriver
        AndroidDriver androidDriver = (AndroidDriver) driver;

        // Install the app from the APK path
        androidDriver.installApp("C:\\Users\\Admin\\eclipse-workspace\\StarAgile_Appium\\apks\\ApiDemos-debug.apk");
        System.out.println("App installed successfully.");

        // Verify the app is installed
        boolean isAppInstalled = androidDriver.isAppInstalled("io.appium.android.apis");
        Assert.assertTrue(isAppInstalled, "The app should be installed.");
        System.out.println("Verified: The app has been successfully installed.");
    }
  */  
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver closed successfully.");
        }
    }
}
