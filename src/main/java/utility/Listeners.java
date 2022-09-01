package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseTest implements ITestListener{

	public void onTestFailure (ITestResult result) {
		System.out.println("Test Fail"+result.getName());
		try {
			ScreenShot.takeSnap(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSuccess (ITestResult result) {
		System.out.println("Test passed"+result.getName());
	}
	public void onTestSkiped(ITestResult result) {
		System.out.println("Test Skipped"+result.getName());
	}
	public void onTestStart (ITestResult result) {
		System.out.println("Test Start"+result.getName());
	}

}
