package com.tenableProject.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MyTendableReport-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Report//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Machine:", "test");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("browser:", readConfig.getChromepath());
		reports.setSystemInfo("user name:", "Anil Nerkar");

		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("Tendable");
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("On Start method invoked....");
	}

	public void onFinish(ITestContext Result) {
		System.out.println("On Finished method invoked....");
		reports.flush();
	}

	public void onTestFailure(ITestResult Result) {
		System.out.println("Name of test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));

		String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + Result.getName() + ".png";

		File screenShotFile = new File(screenShotPath);

		if (screenShotFile.exists()) {
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));

		}

		// test.addScreenCaptureFromPath(null)

	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of test method skipped:" + Result.getName());

		test = reports.createTest(Result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(), ExtentColor.YELLOW));
	}

	public void onTestStart(ITestResult Result) {
		System.out.println("Name of test method started:" + Result.getName());

	}

	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of test method sucessfully executed:" + Result.getName());

		test = reports.createTest(Result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

}
