package com.tenableProject.Page;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class ContactUsPage {

	WebDriver driver;
	WebDriverWait wait;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		// this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	private WebElement contactUs;

	@FindBy(xpath = "(//button[text()='Contact'])[1]")
	private WebElement marketing;

	@FindBy(id = "form-input-fullName")
	private WebElement nameField;

	@FindBy(id = "form-input-organisationName")
	private WebElement orgField;

	@FindBy(id = "form-input-cellPhone")
	private WebElement phoneNos;

	@FindBy(id = "form-input-email")
	private WebElement email;

	@FindBy(xpath = "(//select[@name='jobRole'])[1]")
	private WebElement jobRole;

	@FindBy(xpath = "(//textarea[@id='form-input-message'])[1]")
	private WebElement messageFiled;

	@FindBy(id = "form-input-consentAgreed-0")
	private WebElement i_Agreed;

	@FindBy(xpath = "(//button[@class='button'])[2]")
	private WebElement submit;

	public void clickOnContactUs() {
		contactUs.click();
	}

	public void clickOnMarketing() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", marketing);
	}

	public void enterFullName(String name) {

		nameField.sendKeys(name);
	}

	public void enterOrgName(String orgName) {
		orgField.sendKeys(orgName);
	}

	public void enterPhoneNo(String phoneNo) {
		phoneNos.sendKeys(phoneNo);

	}

	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}

	public void enterJobRole() {
		// jobRole.click();
	}

	public void enterMessage() {
		// messageFiled.sendKeys("");
	}

	public void clickOnI_Agree() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", i_Agreed);
	}

	public void clickOnSubmit_Btn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submit);

	}

	public boolean isErrorMessageIsDisplayed() {
		return messageFiled.isDisplayed();

	}

}
