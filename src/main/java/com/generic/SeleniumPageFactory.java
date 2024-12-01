package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageFactory {
	
	
	public SeleniumPageFactory(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	//login page
	
	@FindBy(xpath="//*[@name='username']")
	private WebElement UserName;
	@FindBy(xpath="//*[@name='password']")
	private WebElement Password;
	@FindBy(xpath="//*[@type='submit']")
	private WebElement loginBtn;
	@FindBy(xpath="//*[text()='Log Out']")
	private WebElement logOutBtn;
	@FindBy(xpath="//*[text()='An internal error has occurred and has been logged.']")
	private WebElement errorMsgWithinvalidCredential;
	@FindBy(xpath="//*[text()='Please enter a username and password.']")
	private WebElement errorMsgWithNullCredential;
	
	@FindBy(css="input. oxd-input oxd-input--active")
	private WebElement userlocatorwithCSS;
	
	public WebElement getUserName() {
		return UserName;
	}
	public WebElement getPassword() {
		return Password;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getLogoutbtn() {
		return logOutBtn;
	}
	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	public WebElement getErrorMsgWithinvalidCredential() {
		return errorMsgWithinvalidCredential;
	}
	public WebElement getErrorMsgWithNullCredential() {
		return errorMsgWithNullCredential;
	}
	
	
	

}
