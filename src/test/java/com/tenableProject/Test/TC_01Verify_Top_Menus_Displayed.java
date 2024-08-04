package com.tenableProject.Test;


import java.io.IOException;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.tenableProject.Page.HomePage;


public class TC_01Verify_Top_Menus_Displayed extends TestBase{

	@Test
	public void verify_Top_Level_Menus() throws IOException {
		Logger  log=  Logger.getLogger("TenableProject");
		PropertyConfigurator.configure("log4j.properties");
		
		HomePage homepage = new HomePage(driver);
		
		Assert.assertTrue(homepage.isMenuPresent());
		Assert.assertTrue(homepage.isRequestDemoButtonPresent());
	
		captureScreenShot(driver,"Verify Top Menus Displayed");
		
	}
	
	
	
	
	
}
