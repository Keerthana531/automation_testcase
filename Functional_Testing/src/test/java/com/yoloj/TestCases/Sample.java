package com.yoloj.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.LoginPageObject;

public class Sample extends BaseClass {
	@Test
	public void sample() throws InterruptedException {
		driver.get(readconfig.getLoginURL());
		
		LoginPageObject l = new LoginPageObject(driver);
		
		l.setEmail("ass@s");
		l.setPassword("asdad");
		l.clickButton();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[1]")).getText());
		System.out.println(l.getEmailErrorMsg());
		System.out.println(driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[2]/div/div[1]")).getText());
	}

}
