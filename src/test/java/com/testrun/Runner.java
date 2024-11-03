package com.testrun;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "json:target/cucumber.json" }, // for report
features = { "./src/main/resources/ParaBankLogin.feature" }, //
glue = { "com.generic" }, tags = { "@Smoke" }, dryRun = false, // true only when no step def
strict = true, // only step def
monochrome = true)
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
