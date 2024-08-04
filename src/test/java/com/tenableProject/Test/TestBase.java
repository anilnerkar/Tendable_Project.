package com.tenableProject.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.log4j.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v124.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.tenableProject.utilities.ReadConfig;

public class TestBase {

	ReadConfig readconfig = new ReadConfig();

	public static WebDriver driver;
	Logger log = Logger.getLogger("TenableProject");

	public String url = readconfig.getApplicationURL();

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(url);
		log.info("url is Open");

		driver.manage().window().maximize();
		log.info("Browser is Maximized");

		PropertyConfigurator.configure("log4j.properties");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		log.info("Browser is closed");

	}

	public void captureScreenShot(WebDriver driver, String testName) throws IOException {

		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

		FileUtils.copyFile(src, dest);
	}

}