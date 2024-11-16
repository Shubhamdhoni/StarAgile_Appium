package Demo.StarAgile_Appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.ApplicationState;

public class Youtube {

    private AppiumDriver driver;

    @BeforeTest
    public void setUp() {
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setAppPackage("com.google.android.youtube");
            options.setAppActivity("com.google.android.youtube.HomeActivity");  // Alternative activity
            options.setPlatformName("Android");
            options.setAdbExecTimeout(Duration.ofSeconds(60));

            driver = new AndroidDriver(new URL("http://192.168.68.150:4723"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("URL is malformed. Please check the Appium server URL.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during setup.");
        }
    }

    @Test
    public void launchYouTube() {
        try {
            System.out.println("YouTube app launched successfully.");
            takeScreenshot("YouTube_Launch"); // Capture screenshot after launch
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during the test.");
        }
    }

    // Method to capture a screenshot and save it to a specified path
    public void takeScreenshot(String youtube) {
        // Define the directory path to save the screenshot
        String dirPath = System.getProperty("user.dir") + "/screenshots/";
        File directory = new File(dirPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = dirPath + youtube + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Save the screenshot to the defined path
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save screenshot.");
        }
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver closed successfully.");
        }
    }
}
