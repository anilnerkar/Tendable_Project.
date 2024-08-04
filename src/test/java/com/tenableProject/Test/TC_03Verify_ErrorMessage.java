package com.tenableProject.Test;

import java.io.IOException;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tenableProject.Page.ContactUsPage;

public class TC_03Verify_ErrorMessage extends TestBase {

	@Test
	public void verify_ErrorMessage() throws InterruptedException, IOException {
		Logger log = Logger.getLogger("TendableProject");
		PropertyConfigurator.configure("log4j.properties");

		ContactUsPage contactpage = new ContactUsPage(driver);
		contactpage.clickOnContactUs();
		log.info("click on ContactUS");

		contactpage.clickOnMarketing();
		log.info("click on MarketingOptions");

		contactpage.enterFullName("anil nerkar");
		log.info("entered FullName");

		contactpage.enterOrgName("Tendable");
		log.info("enter Orgnisation name");

		contactpage.enterPhoneNo("12345");
		log.info("Phone No is Enterd");

		contactpage.enterEmail("abc@gmail.com");
		log.info("email Id is Entered");

		contactpage.enterMessage();
		log.info("Message field is Empty");

		contactpage.clickOnI_Agree();
		log.info("click on IAgree");

		contactpage.clickOnSubmit_Btn();
		log.info("click on Submit");
		captureScreenShot(driver, "Verify Error Message is Displayed");

		Assert.assertTrue(contactpage.isErrorMessageIsDisplayed());

	}

}
