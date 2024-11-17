package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter {
	// JavascriptExecutor = interface (helping selenium)

	public void getColor(WebDriver driver,WebElement elem) {//P=2
		JavascriptExecutor obj = (JavascriptExecutor) driver;// object =type casting
		obj.executeScript("arguments[0].style.border='4px solid red'", elem);
		//always red color
	}
	//OOPs =Polymorphism==> overloading
	public void getColor(WebDriver driver,WebElement elem,String colorName) {//P=3
		JavascriptExecutor obj = (JavascriptExecutor) driver;// object =type casting
		obj.executeScript("arguments[0].style.border='4px solid "+colorName+"'", elem);
		// custom color
	}
// same method = change P = number>>data type>>position
}
