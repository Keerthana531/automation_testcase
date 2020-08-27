package com.yoloj.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.LoginPageObject;

public class TC_Login_Retest extends BaseClass {
  
	@Test
	public void loginTestCase() {
		try {
			
		//loading the login Webpage
		driver.get(readconfig.getLoginURL());
		
		//get instance of LoginPageObjectModel
		LoginPageObject loginPage = new LoginPageObject(driver);
		
		//initialization of Excel file
		FileInputStream fis=setFileInput(readconfig.getLoginDataExcel());
		
		//Workbook
		XSSFWorkbook book=new XSSFWorkbook(fis);
		
		//sheet
		XSSFSheet sheet=book.getSheetAt(0);
		
		//getting the values from cells
		int total=sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		//looping through the cells to get the data
		for(int i=1 ; i<=total ;i++) {
			//variable initialization
			String email=""; String password="";
			String email_errorMsg = ""; String password_errorMsg=""; String finalerror = "";
			
			//getting and asssigning the data
			email = sheet.getRow(i).getCell(0).getStringCellValue();
			password = sheet.getRow(i).getCell(1).getStringCellValue();
			
			//passing the data 
			loginPage.setEmail(email);
			loginPage.setPassword(password);
			loginPage.clickButton();
			
			Thread.sleep(1000);
			if(driver.findElements(By.xpath(loginPage.errorMsgForlogin)).size() != 0) {
				finalerror = loginPage.getErrorMsg();
				System.out.println(finalerror);
			}
			
			//Checking whether the element is Displayed or not
			if(driver.findElements(By.id(loginPage.emailErrorAll)).size() != 0) {
				email_errorMsg = loginPage.getEmailErrorMsg();}
			
			else if (driver.findElements(By.id(loginPage.passwordErrorAll)).size() != 0) {
				password_errorMsg = loginPage.getPasswordErrorMsg();}
			
			
			
			//checking whether the variable is empty or not
			if(email_errorMsg.length() !=0 || password_errorMsg.length() != 0){
					sheet.getRow(i).getCell(3).setCellValue(email_errorMsg+" "+password_errorMsg);
			}			
			else if(finalerror.length() != 0 ){ 
				sheet.getRow(i).getCell(3).setCellValue(finalerror); 
			}
			else{
				sheet.getRow(i).getCell(3).setCellValue("Success");
			}
			
			//loading the webpage for reseting the text field
			driver.get(readconfig.getLoginURL());
		
		}
		
		//saving the updated file
		FileOutputStream fos=setFileOutput(readconfig.getLoginDataExcel());
		book.write(fos);
		
		//closing the Excel file
		fos.close();
		fis.close();
	  }
	
	catch (Exception e) {
		System.out.println("Error Message"+e.getMessage());
	}	
}}
