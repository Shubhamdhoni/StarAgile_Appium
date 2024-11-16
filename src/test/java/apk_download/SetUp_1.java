package apk_download;

import java.net.URL;
import java.time.Duration;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SetUp_1 {
	
protected AppiumDriver driver;
	
	@BeforeTest
	public void setUp() throws Throwable {
		
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setPlatformName("Android");
		options.setApp("C:\\Users\\Admin\\eclipse-workspace\\StarAgile_Appium\\apks\\ApiDemos-debug.apk");
		
		driver = new AndroidDriver(new URL("http://192.168.68.150:4723/"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

}
