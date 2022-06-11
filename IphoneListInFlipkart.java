package org.project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.test.amazon.pompages.PomFlipkartIphone;
import org.test.home.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IphoneListInFlipkart extends BaseClass {
	@BeforeMethod
	private void beforeMethod() {
		chromeLaunch();
		impWait(10);

	}

	@AfterMethod
	private void afterMethod() {
		System.out.println("Task Completed");
		quit();

	}

	@Test
	private void test() {
		urlLaunch("https://www.flipkart.com/");
		System.out.println("=====Iphone List ===========");
		PomFlipkartIphone p = new PomFlipkartIphone();
		sendKeys(p.getSearch(), "iphone");
		click(p.getCloseBtn());
		click(p.getSearchBt());
		List<WebElement> iphoneList = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		System.out.println("Total = " + iphoneList.size());
		int count = 1;
		String l = null;
		for (int i = 0; i < iphoneList.size(); i++) {
			WebElement list = iphoneList.get(i);
			l = getAttributeText(list);
			System.out.println(count + ". " + l);
			count++;
		}

		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println("====== Price List ===========");
		System.out.println("Total = " + priceList.size());

		int count1 = 1;
		String y = null;
		for (int i = 0; i < priceList.size(); i++) {
			WebElement x = priceList.get(i);
			y = getAttributeText(x);
			if (y.contains(",")) {
				y = y.replace(",", "");
			}

			if (y.contains("₹")) {
				y = y.substring(1);
				System.out.println(count1 + ". " + y);
			}
			count1++;
		}

		int cou = 1;
		System.out.println("=========List and Price===============");
		for (int i = 0; i < iphoneList.size(); i++) {
			WebElement list = iphoneList.get(i);
			l = getAttributeText(list);

			WebElement x = priceList.get(i);
			y = getAttributeText(x);

			if (y.contains(",")) {
				y = y.replace(",", "");
			}
			if (y.contains("₹")) {
				y = y.substring(1);
			}

			Map<String, String> m = new LinkedHashMap();
			m.put(l, y);
			System.out.println(cou + ". " + m);
			cou++;

		}

	}

}
