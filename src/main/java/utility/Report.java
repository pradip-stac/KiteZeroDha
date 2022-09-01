package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {

	public static ExtentReports generateReport () {
		ExtentSparkReporter htmlreportor = new ExtentSparkReporter("ProjectReport.htlm");
		ExtentReports reports = new ExtentReports ();
		reports.attachReporter(htmlreportor);
		reports.setSystemInfo("suite", "Regression");
		reports.setSystemInfo("TestedBy", "Pradip");
		return reports;
	
	
	
	
	
	
	
	
	}
}
