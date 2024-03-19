package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class ViewsLongPress {
	AndroidDriver driver;
	AndroidActions action = new AndroidActions();

	public ViewsLongPress(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Expandable Lists")
	private WebElement EXPAND_LIST_OPTION;
	
	@AndroidFindBy(accessibility = "1. Custom Adapter")
	private WebElement CUSTOM_ADAPTER;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
	private WebElement PEOPLE_NAME;
	
	@AndroidFindBy(accessibility = "Views")
	private WebElement VIEWS_OPTION;

	public void clickOnViewsOption() throws InterruptedException {
		Thread.sleep(2000);
		VIEWS_OPTION.click();

	}

	public void clickOnExpandableOption() throws InterruptedException {
		Thread.sleep(2000);
		EXPAND_LIST_OPTION.click();

	}

	public void clickOnCustomAdapter() throws InterruptedException {
		Thread.sleep(2000);
		CUSTOM_ADAPTER.click();

	}
	
	public void longPressOnPeople() {
		action.longPress(PEOPLE_NAME, 3000);

	}
	
}
