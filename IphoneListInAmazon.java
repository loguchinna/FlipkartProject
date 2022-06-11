package org.project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.amazon.pompages.PomLoginPageAmazon;
import org.test.amazon.pompages.PomOrderPlacing;
import org.test.home.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IphoneListInAmazon extends BaseClass {

	@BeforeMethod
	private void beforeMethod() {
		chromeLaunch();
		impWait(10);

	}

	@AfterMethod
	private void afterMethod() {
		System.out.println("Task Completed");
		//quit();

	}

	@Test(enabled = false)
	private void test1() {
		System.out.println("==== Account SignUp ====");
		urlLaunch("https://www.amazon.in/");
		PomLoginPageAmazon l = new PomLoginPageAmazon();

		Assert.assertTrue(getCurrentUrl().contains("ama"), "Verify URL By HardAssert");

		moveToElement(l.getHello());
		click(l.getSignin1());
		sendKeys(l.getPhoneno(), "7639598337");
		click(l.getContinueBtn());
		sendKeys(l.getPassword(), "boss79593");
		click(l.getSignin2Btn());

	}

	@Test
	private void test2() {
		System.out.println("======Iphone List=====");
		urlLaunch("https://www.amazon.in/");
		Assert.assertTrue(getCurrentUrl().contains("ama"), "Verify URL By HardAssert");
		PomOrderPlacing c = new PomOrderPlacing();

		sendKeys(c.getSearch(), "iphone");
		click(c.getSearchBtn());

		List<WebElement> iphoneList = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("size"+iphoneList.size());
		int count=1;
		for (int i = 0; i < iphoneList.size(); i++) {
			WebElement list = iphoneList.get(i);
			scrollDown(list);
			System.out.println(count+". "+getAttributeText(list));
			count++;			
		}

	
		
		System.out.println("=======Iphone List Price==========");
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println("size"+price.size());
		int count1=1;
		for(int i=0;i<price.size();i++) {
			WebElement x = price.get(i);
			scrollDown(x);
			String y = getAttributeText(x);
			
			System.out.println(count1+". "+getAttributeText(x));
			count1++;			
		}
		
		
		System.out.println("Maximum Price is ");
		
//		for(int j=0;j<price.size();j++) {
//			do {
//				int i=0;
//				WebElement a = price.get(j);
//				WebElement b = price.get(i);
//				String x = getAttributeText(a);
//				String y = getAttributeText(b);
//
//				
//			//	x<y;			
//				i++;
//			}while(j<price.size());
//		}
		
		
	}
}
