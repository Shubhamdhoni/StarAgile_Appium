package Demo.StarAgile_Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumTest {
	
	private AppiumDriver driver;
	
	@BeforeClass
	public void bsetUp() throws MalformedURLException {
		
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("PlatformName", "Andriod");
//		cap.setCapability("deviceName", "DhoniPixel");
//		cap.setCapability("automationName", "uiAutomator2");
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("DhoniPixel");
		options.setAppPackage("com.google.android.apps.messaging");
		options.setAppActivity("com.google.android.apps.messaging.ui.ConversationListActivity");
		
		driver = new AndroidDriver(new URL(" http://172.26.64.1:4723/"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void sampleTest() {
		System.out.println("Message App open");
	}

	

}
