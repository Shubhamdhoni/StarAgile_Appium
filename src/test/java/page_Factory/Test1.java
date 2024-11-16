package page_Factory;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Test1 extends SetUp {
	
	@Test	
	public void sampleTest() {
		System.out.println("Clock session ID :"+ driver.getSessionId());
		driver.findElement(AppiumBy.id("com.google.android.deskclock:id/fab")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Bangalore, Karnataka, India\")")).click();
		
		Message message = new Message(driver);
		message.setSearchBox("Bangalore");
	}
}
