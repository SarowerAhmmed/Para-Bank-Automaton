package com.testrun;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class MenuBar {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.costco.com/");
		driver.manage().window().maximize();
		// implicit wait = HTML page load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//List<String> myList = new ArrayList<>();
		List<WebElement> menuBar =driver.findElements(By.xpath("//*[@class='MuiBox-root mui-1nzpdry']//a"));
	
		System.out.println("menu bar total name = "+menuBar.size() );
		
		
		
		List<String> myList = new ArrayList<>();
		
		for(int i=0;i<menuBar.size();i++) {//start
			
			System.out.println(menuBar.get(i).getText());
			myList.add(menuBar.get(i).getText());
			
		}//end
	
		System.out.println("All value in my list = "+myList);//all value store in new list
		
		SoftAssert sf =new SoftAssert();
		sf.assertTrue(myList.contains("Pharmacy"));
		sf.assertTrue(myList.contains("City"));
		
		driver.quit();
		sf.assertAll();
	}

}
