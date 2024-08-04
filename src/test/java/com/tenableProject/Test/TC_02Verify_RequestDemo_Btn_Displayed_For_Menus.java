package com.tenableProject.Test;

import java.io.IOException;

import org.apache.log4j.xml.Log4jEntityResolver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tenableProject.Page.HomePage;

public class TC_02Verify_RequestDemo_Btn_Displayed_For_Menus extends TestBase {

	@Test
	public void verify_RequestDemo_Btn_Displyayed() {
		
		HomePage homepage = new HomePage(driver);
		homepage.isRequestDemoButtonPresent();

		String ActualTitle = driver.getTitle();
		System.out.println("Title :" + ActualTitle);

		String ExpectedTitle = "Quality Improvement App | Health and Social Care | Tendable";
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Title is Mis-mached");

		Assert.assertTrue(homepage.isRequestDemoButtonPresent());
		log.info("Test case is passed");
		
		try {
			captureScreenShot(driver, "verify Request Demo Btn Displayed For Top Menus");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
