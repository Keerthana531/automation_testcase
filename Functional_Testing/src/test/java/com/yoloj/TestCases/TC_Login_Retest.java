package com.yoloj.TestCases;

import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TC_Login_Retest extends BaseClass {
  
	@Test
	public void loginTestCase() {
		//loading the login Webpage
		driver.get(readconfig.getLoginURL());
		
		//initialization of Excel file
		File file = new File("C:\\Users\\Arun\\Desktop\\LoginData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
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
			String email_errorMsg = ""; String password_errorMsg="";
			
			//getting and asssigning the data
			email = sheet.getRow(i).getCell(0).getStringCellValue();
			password = sheet.getRow(i).getCell(1).getStringCellValue();
			
			//passing the data 
			driver.findElement(By.id("email")).sendKeys(email+Keys.TAB+password);
				
			//Checking whether the element is Displayed or not
			if(driver.findElements(By.id("email-helper-text")).size() != 0) {
				email_errorMsg=driver.findElement(By.id("email-helper-text")).getText();}
			else if (driver.findElements(By.id("password-helper-text")).size() != 0) {
				password_errorMsg=driver.findElement(By.id("password-helper-text")).getText();}
			
			//loading the webpage for reseting the text field
			driver.get("http://localhost:3000/login");
			
			//checking whether the variable is empty or not
			if(email_errorMsg.length() !=0 || password_errorMsg.length() != 0) {
				//writing in the cell
				sheet.getRow(i).getCell(3).setCellValue(email_errorMsg+" "+password_errorMsg);}
			else { sheet.getRow(i).getCell(3).setCellValue("Success"); }
		
		}
		FileOutputStream fos = new FileOutputStream(file);
		//saving the updated file
		book.write(fos);
		
		//closing the Excel file
		fos.close();
		fis.close();
	  }

	}
	
}
