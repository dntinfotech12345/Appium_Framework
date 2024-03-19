package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends AndroidActions  implements ITestListener {
	ExtentTest test;
	ExtentReports extent= ExtendsReport.getReporterObject();
	 @Override
	    public void onTestStart(ITestResult result) {
	        // Invoked each time a test method starts
		 test = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // Invoked each time a test method succeeds
	    	test.log(Status.PASS, "***-Test Passed=>"+result.getMethod().getMethodName()+"-***");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        // Invoked each time a test method fails
	    		test.fail(result.getThrowable());
	    		try {
					test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName()), result.getMethod().getMethodName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // Invoked each time a test method is skipped
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Invoked each time a test method fails but is within the success percentage
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        // Invoked before the test starts
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        // Invoked after the test finishes
	    	extent.flush();
	    }

}
