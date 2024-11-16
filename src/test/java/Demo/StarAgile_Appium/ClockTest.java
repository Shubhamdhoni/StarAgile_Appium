package Demo.StarAgile_Appium;

import java.net.URL;
import java.time.Duration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ClockTest {
	
	private AppiumDriver driver;
	
	@BeforeTest
	public void setUp() throws Throwable {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setAppPackage("com.google.android.deskclock");
		options.setAppActivity("com.android.deskclock.DeskClock");
		options.setPlatformName("Andriod");
		
		driver = new AndroidDriver(new URL(" http://172.26.64.1:4723/"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@Test	
	public void sampleTest() {
		System.out.println("Clock session ID :"+ driver.getSessionId());
		driver.findElement(AppiumBy.id("com.google.android.deskclock:id/fab")).click();
		driver.findElement(AppiumBy.id("com.google.android.deskclock:id/open_search_view_edit_text")).sendKeys("Bangalore");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Bangalore, Karnataka, India\")")).click();
}
}