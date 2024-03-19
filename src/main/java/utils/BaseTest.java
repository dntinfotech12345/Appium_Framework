package utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AppiumDriverLocalService service;
	public static AndroidDriver driver;

	@BeforeClass(alwaysRun=true)
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\hp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Roshan");
		options.setApp(
				"C:\\Users\\hp\\eclipse-workspace\\Appium_Poc\\src\\test\\java\\resources\\APKFiles\\resources\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		service.stop();
	}

	public List<HashMap<String, String>> getJsonData(String jsonFilePatH) throws IOException {

		// convertJson file content to json string

		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir")
						+jsonFilePatH),
				StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}

	
	
}
