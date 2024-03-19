package DnT.Appium_Poc;
import org.testng.annotations.Test;

import pageObject.ViewsLongPress;
import utils.AndroidActions;
import utils.BaseTest;


public class ViewslongPressTest extends BaseTest {
	AndroidActions action;
	@Test(groups= {"Regression","Smoke"})
	public void verifyLongPressTest() throws InterruptedException {
		ViewsLongPress longpress =new ViewsLongPress(driver);
		
		longpress.clickOnViewsOption();
		longpress.clickOnExpandableOption();
		longpress.clickOnCustomAdapter();
		longpress.longPressOnPeople();
		
	}
}