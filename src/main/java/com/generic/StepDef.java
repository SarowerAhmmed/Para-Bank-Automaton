package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.excel.read.ExcelManger;
import com.util.BaseConfig;
import com.util.HandleExamleTableData;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	WebDriver driver;
	SeleniumPageFactory pf;
	SoftAssert sa;
	BaseConfig conf;
	
//	@Before
//	public void getSetup() {
//		
//	}
//	@After
//	public void teardown() {
//		
//	}
	
	
	@Given("open browser")
	public void open_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("go to para bank application")
	public void go_to_para_bank_application() throws Exception {
		 conf = new BaseConfig();
		driver.navigate().to(conf.getConfig("URL"));
		// implicit = HTML load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// pageload timeout =GUI
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

	@When("put valid user name")
	public void put_valid_user_name() throws Exception {
		// driver.findElement(By.xpath("")).sendKeys("user");

		pf = new SeleniumPageFactory(driver);
		// Explicit= wait for user
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pf.getUserName()));

		pf.getUserName().sendKeys(conf.getConfig("Valid_User"));
	}

	@When("put valid password")
	public void put_valid_password() throws Exception {
		pf.getPassword().sendKeys(conf.getConfig("Valid_Password"));
	}

	@When("click login button")
	public void click_login_button() {
		// Explicit= wait for user
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pf.getLoginBtn()));

		pf.getLoginBtn().click();
	}

	@Then("login should pass and logout button should visible")
	public void login_should_pass_and_logout_button_should_visible() {
		pf = new SeleniumPageFactory(driver);
		// check visible = isDisplayed()
		// Soft assert
		sa = new SoftAssert();

		sa.assertTrue(pf.getLogoutbtn().isDisplayed());
		sa.assertAll();
		driver.quit();
	}

	@When("put invalid user name")
	public void put_invalid_user_name() throws Exception {
		pf = new SeleniumPageFactory(driver);
		pf.getUserName().sendKeys(conf.getConfig("InValid_User"));
	}

	@When("put invalid password")
	public void put_invalid_password() throws Exception {
		pf.getPassword().sendKeys(conf.getConfig("InValid_Password"));
	}

	@Then("login should fail and error msg contains An internal error has occurred and has been logged")
	public void login_should_fail_and_error_msg_contains_An_internal_error_has_occurred_and_has_been_logged() {

		sa = new SoftAssert();
		sa.assertTrue(pf.getErrorMsgWithinvalidCredential().isDisplayed());
		sa.assertAll();
		driver.quit();
	}

	@When("put null user name")
	public void put_null_user_name() {
		pf = new SeleniumPageFactory(driver);
		pf.getUserName().sendKeys("");
	}

	@When("put null password")
	public void put_null_password() {
		pf.getPassword().sendKeys("");
	}

	@Then("login should fail and error msg contains Please enter a username and password.")
	public void login_should_fail_and_error_msg_contains_Please_enter_a_username_and_password() {
		sa = new SoftAssert();
		sa.assertTrue(pf.getErrorMsgWithNullCredential().isDisplayed());
		sa.assertAll();
		driver.quit();
	}
	@When("put valid user name {string}")
	public void put_valid_user_name(String user) throws Exception {
		pf = new SeleniumPageFactory(driver);
		// Explicit= wait for user
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pf.getUserName()));
		// split & break user
		HandleExamleTableData obj = new HandleExamleTableData();
		int row=obj.getActualRow(user);
		int col =obj.getActualCol(user);
		//Apache POI read excel data based on row & col
		ExcelManger em = new ExcelManger();
		//actual user
		em.getReadExcelData(row,col);
		
		pf.getUserName().sendKeys(em.getReadExcelData(row,col));
	}

	@When("put valid password {string}")
	public void put_valid_password(String pass) {
		pf = new SeleniumPageFactory(driver);
		// Explicit= wait for user
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pf.getUserName()));

		pf.getUserName().sendKeys(pass);
	}



}
