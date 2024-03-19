package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class UserScrolling {
	AndroidDriver driver;
	AndroidActions action = new AndroidActions();

	public UserScrolling(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Views")
	private WebElement ViewsOption;

	public void clickOnViewsOption() throws InterruptedException {
		Thread.sleep(3000);
		ViewsOption.click();

	}

	public void ScrollElemnetUptoWebView(String text) throws InterruptedException {
		Thread.sleep(3000);
		action.ScrollTOTextInView(text);

	}

}
