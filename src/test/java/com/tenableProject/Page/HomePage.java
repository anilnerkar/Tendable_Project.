package com.tenableProject.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Our Story ']")
	private WebElement ourStoryMenu;

	@FindBy(xpath = "//a[text()='Our Solution ']")
	private WebElement ourSolutionMenu;

	@FindBy(xpath = "//a[text()='Why Tendable? ']")
	private WebElement whyTendableMenu;

	@FindBy(xpath = "//a[text()='Request A Demo']")
	private WebElement requestDemoButton;

	public boolean isMenuPresent() {
		return ourStoryMenu.isDisplayed() && ourSolutionMenu.isDisplayed() && whyTendableMenu.isDisplayed();
	}

	public boolean isRequestDemoButtonPresent() {
		return requestDemoButton.isDisplayed();
	}

}
