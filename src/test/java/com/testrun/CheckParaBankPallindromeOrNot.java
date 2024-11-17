package com.testrun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class CheckParaBankPallindromeOrNot {
	String reverseTitle ="";
	public void getPallindrome(){
		//open browser
		WebDriver driver = new ChromeDriver();
		//go to application
		driver.get("https://para.testar.org/parabank/about.htm;jsessionid=FB240F858FA900BA96DEE5A980656F85");
		driver.manage().window().maximize();
		// get or read parabank name (99%)
//		String titleName =driver.findElement(By.xpath("//*[@title='ParaBank']")).getText();
//		System.out.println("My title = "+titleName);
		//Problem = null
		//Why =getText() return any text but no black color in HTML
		String mytitle =driver.findElement(By.xpath("//*[@title='ParaBank']")).getAttribute("title");
		System.out.println("My title = "+mytitle);
		
		//now can check pallindrome = reverse + condition
	
		System.out.println("Before reverse = "+mytitle);
		for(int i=mytitle.length()-1;i>=0;i--) {//negative loop reverse
			System.out.println(mytitle.charAt(i));//each letter
			reverseTitle =reverseTitle + mytitle.charAt(i);//store
			//afteRreverse += beforeReverse.charAt(i);//store
		}//loop end
		
		System.out.println("After reverse = "+reverseTitle);
		
		//pallindrom = before reverse string(beforeReverse) = after reverse (afteRreverse)
		//java condition
		//automation validation =assertion(soft)
		if(mytitle.equals(reverseTitle)) {//false
			System.out.println("this is pallindrome");//condition =true
			
		}else {
			System.out.println("this is not pallindrome");//condition =false
		}
	
		//validation
		System.out.println("Condition return = "+mytitle.equals(reverseTitle));
		SoftAssert sf = new SoftAssert();
		//sf.assertTrue(! mytitle.equals(reverseTitle));
		sf.assertFalse(mytitle.equals(reverseTitle));
		
		
		driver.quit();
		
		sf.assertAll();
	}
	
	public static void main(String[] args) {
		
		CheckParaBankPallindromeOrNot obj = new CheckParaBankPallindromeOrNot();
		obj.getPallindrome();
	}

}
