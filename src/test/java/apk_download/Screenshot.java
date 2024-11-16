package apk_download;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import io.appium.java_client.AppiumBy;

public class Screenshot extends SetUp_1 {

    @Test
    public void screenshot() {
        try {
            // Click on the element with accessibility ID "Views"
            driver.findElement(AppiumBy.accessibilityId("Views")).click();
            
            // Capture screenshot
            takeScreenshot("screenshot_views_page");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during the test execution.");
        }
    }

    // Method to take a screenshot and save it to a specific path
    public void takeScreenshot(String fileName) {
        // Define the path where the screenshot will be saved
        String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save screenshot.");
        }
    }
}
