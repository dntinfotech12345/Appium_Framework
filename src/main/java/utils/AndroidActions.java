package utils;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;


public class AndroidActions extends BaseTest{

	public void longPress(WebElement ele, int duration) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", duration));

	}

	public void ScrollTOTextInView(String text) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
	}
	
	public String getScreenShotPath(String TestCaceName) throws IOException {
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"\\ExtentReports"+TestCaceName+".png";
		FileUtils.copyFile(source, new File(destFile));
		return destFile;
	}

}
