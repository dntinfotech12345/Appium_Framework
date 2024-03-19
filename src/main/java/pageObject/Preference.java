package pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preference {

	AndroidDriver driver;

	public Preference(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Preference")
	private WebElement preferenceOption;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")
	private WebElement preferenceDependenciseOption;

	@AndroidFindBy(id = "android:id/checkbox")
	private WebElement preferenceCheckBox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']")
	private WebElement wifiSettings;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='android:id/edit']")
	private WebElement wifiSettingsInputBox;

	@AndroidFindBy(id = "android:id/alertTitle")
	private WebElement alertTitle;

	@AndroidFindBy(className = "android.widget.Button")
	private List<WebElement> oKAlertButton;

	public void clickOnPreferenceOption() {
		preferenceOption.click();

	}

	public void clickOnPreferenceDependenciseOption() {
		preferenceDependenciseOption.click();

	}

	public void clickPreferenceCheckBox() throws InterruptedException {
		Thread.sleep(3000);
		preferenceCheckBox.click();

	}

	public void clickWifiSettings() throws InterruptedException {
		Thread.sleep(3000);
		wifiSettings.click();

	}

	public String getAlertText() {
		return alertTitle.getText();

	}

	public void sendWifiSettingsText(String text) {
		wifiSettingsInputBox.sendKeys(text);

	}

	public void clickOkAlert() {
		oKAlertButton.get(1).click();
		;

	}

}
