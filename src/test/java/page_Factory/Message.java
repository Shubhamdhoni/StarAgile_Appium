package page_Factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;

public class Message {
	 AppiumDriver driver;
	
	public Message(AppiumDriver driver) {
		PageFactory.initElements(driver , this);
		this.driver= driver;
	}
	
	@AndroidBy(id ="com.google.android.deskclock:id/open_search_view_edit_text")
	private WebElement searchBox;
	
	public void setSearchBox(String text) {
		searchBox.sendKeys(text);;
	}

}
