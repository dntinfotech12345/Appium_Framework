package DnT.Appium_Poc;
import org.testng.annotations.Test;

import pageObject.UserScrolling;
import utils.BaseTest;


public class verifyUserScrollingAction extends BaseTest {


	@Test(groups= {"Smoke"})
	public void verifyLongPressTest() throws InterruptedException {
		
		UserScrolling user = new UserScrolling(driver);
		user.clickOnViewsOption();
		user.ScrollElemnetUptoWebView("WebView");

	}

}
