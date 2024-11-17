package com.testrun;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = { "json:target/cucumber.json" }, // for report
		features = { // which feature file to run
//				"./src/main/resources/ParaBankLogin.feature",
//				"./src/main/resources/ParaBankLoginInValidMultipleCredential.feature",
				"./src/main/resources/ParaBankLoginValidMultipleCredential.feature" }, //
		glue = { "com.generic" }, // automation code
		tags = { "@Smoke" }, // which scenario or what type of test to run
		dryRun = false, // feature file is correct or not
		strict = true, // steps def has any missing step there or not
		monochrome = true)// remove ? mark & make console easy to read
public class Runner extends AbstractTestNGCucumberTests {
// cucumber hook

	@Before
	public void setup() {

	}

	@BeforeTest
	public void setup2() {

	}

	@Test
	public void setup3() {

	}

	@AfterTest
	public void setup4() {

	}

}
