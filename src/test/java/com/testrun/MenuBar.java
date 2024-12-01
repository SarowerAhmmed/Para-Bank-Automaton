package com.testrun;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		
		for(int i=0;i<menuBar.size();i++) {
			
			System.out.println(menuBar.get(i).getText());
			
		}
	
	}

}
