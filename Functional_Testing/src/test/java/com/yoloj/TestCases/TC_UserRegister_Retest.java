package com.yoloj.TestCases;

import org.testng.annotations.Test;

import com.yoloj.PageObjects.UserRegister_PageObject;

public class TC_UserRegister_Retest extends BaseClass {
	
	@Test
	public void userRegister() throws InterruptedException{
		
		driver.get("http://localhost:3000/");
		
		logger.info("URL is opened");
		up = new UserRegister_PageObject(driver);
		
		Thread.sleep(2000);
		up.ClickRegisterbtn();
		logger.info("User clicked the Register button");
		Thread.sleep(2000);
		
		up.setName("Rohini");
		logger.info("User entered the name");
		Thread.sleep(2000);
		
		up.setEmail("rohini123@gmail.com");
		logger.info("User entered the mail");
		Thread.sleep(2000);
		
		up.setPassword("Rohini@1234");
		logger.info("User entered the password");
		Thread.sleep(2000);
		
		up.setConfirmPassword("Rohini@1234");
		logger.info("User confirmed the password");
		Thread.sleep(2000);
		
		up.setPhone("9812435678");
		logger.info("User entered the number");
		Thread.sleep(2000);
		
//		up.createAccount();
//		logger.info("User clicked the create account");
//		
//		Thread.sleep(3000);
		
//		up.gotoLogin();
//		Thread.sleep(3000);
		
		up.gotoHome();
		Thread.sleep(2000);
	}

}
