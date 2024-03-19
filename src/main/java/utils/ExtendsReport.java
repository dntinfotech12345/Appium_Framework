package utils;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsReport {

    private static ExtentReports extent;

    public static ExtentReports getReporterObject() {

        String path = System.getProperty("user.dir") + "\\ExtentReports\\index.html";
      
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Appium Automation Test Results ");
        reporter.config().setReportName("Appium Test Execution Report");
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setReportName("DnT Appium Automation");
        reporter.config().setEncoding("utf-8");
        reporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        
        // Set the organization logo
        String organizationLogoPath = "path/to/your/logo.png"; // Provide the path to your logo image
        String organizationLogoHtml = "<img src='" + organizationLogoPath + "' alt='Organization Logo' style='height: 50px; width: auto;'>";
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Roshan Morkhade");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}

