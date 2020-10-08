package com.yoloj.TestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.UserRegister_PageObject;

public class TC_UserRegister_Retest extends BaseClass {
	
	@Test
	public void userRegister() throws InterruptedException, IOException{
		
		try{
		
		// getting the application url
		
		logger.info("URL is opened");
		
		//initializing the instance of page object
		up = new UserRegister_PageObject(driver);
		Thread.sleep(2000);
		
//		driver.get("http://3.94.90.131:3000/register");
//		logger.info("Getting the register page");
		// getting the path from base class
		//String path = "C:\\Users\\hp\\Desktop\\User_Register_Test_Data.xlsx";
		FileInputStream fis = new FileInputStream(userRegisterPath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		//getting the row count
		int size = sheet.getLastRowNum() -  sheet.getFirstRowNum();
		System.out.println(size);
		
		//getting the data through looping
		for(int i=1; i<=size; i++){
			DataFormatter formatter = new DataFormatter();
			String msg = "";
			String name = formatter.formatCellValue(sheet.getRow(i).getCell(0));
			String email = formatter.formatCellValue(sheet.getRow(i).getCell(1));
			String password = formatter.formatCellValue(sheet.getRow(i).getCell(2));
			String ConfirmPass = formatter.formatCellValue(sheet.getRow(i).getCell(3));
			String code = formatter.formatCellValue(sheet.getRow(i).getCell(4));
			String phone = formatter.formatCellValue(sheet.getRow(i).getCell(5));
			
			System.out.println(name+" "+email+" "+password+" "+ConfirmPass+" "+code+" "+phone);
			// user clicking the register button
			Thread.sleep(2000);
			up.ClickRegisterbtn();
			logger.info("User clicked the Register button");
			Thread.sleep(1000);
			//user setting the name
			up.setName(name);
			logger.info("User entered the name");
			Thread.sleep(1000);
			
			//user setting the mail
			up.setEmail(email);
			logger.info("User entered the mail");
			Thread.sleep(1000);
			
			//user setting the password
			up.setPassword(password);
			logger.info("User entered the password");
			Thread.sleep(1000);
			
			//user setting the confirm password
			up.setConfirmPassword(ConfirmPass);
			logger.info("User confirmed the password");
			Thread.sleep(1000);
			
			//user selecting the code from drop down
			driver.findElement(By.id("demo-simple-select")).click();
			Thread.sleep(1000);
			List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]/li"));
			//System.out.println(list.size());
			
			for(int j=0; j<list.size(); j++){
				if(list.get(j).getText().equals(code)){
					System.out.println(list.get(j).getText());
					list.get(j).click();
					break;
					
				}
			}
			logger.info("user selected the code");
			//user setting the phone number
			up.setPhone(phone);
			logger.info("User entered the number");
			Thread.sleep(1000);
			
			//user selecting the create account
			Actions action = new Actions(driver);
			action.moveToElement(up.crtbutton()).click().perform();
//			up.createAccount();
			logger.info("User clicked the create account");	
			Thread.sleep(2000);
			//user capturing the error message
			
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			
			
			if(driver.findElements(By.className("MuiSnackbarContent-message")).size()!=0){
				//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("MuiSnackbarContent-message"))));
				msg = up.getExistmsg();
				System.out.println(msg);
			}


			//user navigating to home page
			up.gotoHome();
			logger.info("User is on the home page");
//			driver.get("http://3.94.90.131:3000/register");
//			logger.info("Resetting the value");
			//driver.navigate().refresh();
			Thread.sleep(2000);
			
			if(msg.length()!=0){
				sheet.getRow(i).createCell(6).setCellValue(msg);	
			}
			else{
				sheet.getRow(i).createCell(6).setCellValue("Success");
			}
		
		}
		
		FileOutputStream fos = new FileOutputStream(userRegisterPath);
		wb.write(fos);
		wb.close();
	
	}
	catch(Exception e){
		System.out.println("Error Message"+e.getMessage());
	}
	}
}

		
	
/*

String name_errormsg="";
String mail_errormsg = "";
String pass_errormsg = "";
String confirmpass_errormsg = "";
String phone_errormsg = "";
		Thread.sleep(4000);
		
//		String msg = up.getErrormsg();
//		System.out.println(msg);
		
//		up.gotoLogin();
//		Thread.sleep(3000);
		
//		name_errormsg = up.getNameError();
//		
//		mail_errormsg = up.getEmailError();
//		
//		pass_errormsg = up.getPasswordError();
//		
//		confirmpass_errormsg = up.getConfirmPassError();
//		
//		phone_errormsg = up.getPhoneError();

//WebElement countrycode = driver.findElement(By.id("demo-simple-select"));
//Select s1 = new Select(countrycode);
//Thread.sleep(2000);
//s1.selectByVisibleText(code);
//Thread.sleep(2000);
//logger.info("Counter code selected");



//@DataProvider(name="LoginData")
//String [][] getData() throws IOException
//{
//String path = System.getProperty("user.dir")+"/src/test/java/com/yoloj/testData/User_Register_Test_Data.xlsx";
//
//int rowCount = XLUtils.getRowCount(path, "Sheet1");
////int colCount = XLUtils.getCellCount(path, "Sheet1", 2);
//int colCount = 6;
//
//System.out.println(rowCount);
//
//String logindata[][]=new String[rowCount][colCount];
//for(int i=1;i<rowCount-2;i++){
//	for(int j=0;j<colCount;j++){
//		
////		String name = XLUtils.getCellData(path, "Sheet1", i, j);
////		String email = XLUtils.getCellData(path, "Sheet1", i, j);
////		String password = XLUtils.getCellData(path, "Sheet1", i, j);
////		String ConfirmPass = XLUtils.getCellData(path, "Sheet1", i, j);
////		String code = XLUtils.getCellData(path, "Sheet1", i, j);
////		String phone = XLUtils.getCellData(path, "Sheet1", i, j);
////		
////		System.out.println(name+" "+email+" "+password+" "+ConfirmPass+" "+code+" "+phone);
////		
//		
//		logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
//		
//	}
//}
//return logindata;

//if(driver.getPageSource().contentEquals("Error")){
//	captureScreen(driver, "TC_UserRegister_Retest");
//	Thread.sleep(2000);
//	driver.navigate().refresh();
//
//}
//else if(up.homeLink().isDisplayed()){
//		up.gotoHome();
//		logger.info("User is on the home page");
//		Thread.sleep(2000);
//}

if(driver.findElements(By.id("name-helper-text")).size()!=0){
	name_errormsg = up.getNameError();
	System.out.println(name_errormsg);
}
if(driver.findElements(By.id("email-helper-text")).size()!=0){
	mail_errormsg = up.getEmailError();
	System.out.println(mail_errormsg);
}
if(driver.findElements(By.id("password-helper-text")).size()!=0){
	pass_errormsg = up.getPasswordError();
	System.out.println(pass_errormsg);
	
}
if(driver.findElements(By.id("confirm_password-helper-text")).size()!=0){
	confirmpass_errormsg = up.getConfirmPassError();
	System.out.println(confirmpass_errormsg);
	
}
if(driver.findElements(By.id("phone_number-helper-text")).size()!=0){
	phone_errormsg = up.getPhoneError();
	System.out.println(phone_errormsg);
}
*/
