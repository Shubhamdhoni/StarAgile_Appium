package page_Factory;

import java.net.URL;
import java.time.Duration;

import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SetUp {
	
protected AppiumDriver driver;
	
	@BeforeTest
	public void setUp() throws Throwable {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setAppPackage("com.google.android.deskclock");
		options.setAppActivity("com.android.deskclock.DeskClock");
		options.setPlatformName("Andriod");
		
		driver = new AndroidDriver(new URL(" http://172.26.64.1:4723/"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

}
