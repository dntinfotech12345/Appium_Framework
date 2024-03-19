package DnT.Appium_Poc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.AssertJUnit;

import pageObject.Preference;
import utils.BaseTest;

public class validatePreferenceAlert extends BaseTest {

	@Test(dataProvider ="getData" , groups= {"Regression"})
	public void verifyPreferanceAlertTest(HashMap<String,String>input) throws InterruptedException {

		Preference preference = new Preference(driver);
		preference.clickOnPreferenceOption();
		preference.clickOnPreferenceDependenciseOption();
		preference.clickPreferenceCheckBox();
		preference.clickWifiSettings();
		String actualText = preference.getAlertText();
		Assert.assertEquals(actualText, input.get("expectText"));
		preference.sendWifiSettingsText(input.get("wifiText"));
		preference.clickOkAlert();

	}

	//
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData("//src//test//java//resources//TestData//preferance.json");
		return new Object [][] {{data.get(0)}};
	}
}