package AutomationTesting.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports GetReportObject()
	{   String Path= System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter Reporter = new ExtentSparkReporter(Path);
		Reporter.config().setReportName("WebAutomationResults");
		Reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Tester", "Gopi Nath K");
		return extent;
	}

}
