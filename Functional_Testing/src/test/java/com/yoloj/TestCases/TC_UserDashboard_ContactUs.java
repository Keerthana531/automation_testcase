package com.yoloj.TestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.ContactUs_PageObject;
import com.yoloj.PageObjects.LoginPageObject;
import com.yoloj.PageObjects.UserRegister_PageObject;

public class TC_UserDashboard_ContactUs extends BaseClass{
	
	@Test
	public void homePage_Contact() throws IOException, InterruptedException{
		
		logger.info("url opened");
		
		ContactUs_PageObject hcp = new ContactUs_PageObject(driver);
		UserRegister_PageObject up = new UserRegister_PageObject(driver);
		LoginPageObject lp = new LoginPageObject(driver);
		
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Desktop\\ContactUs_TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet2");
		
		//getting the row count
		int size = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(size);
		
		//getting the data through looping
		for(int j=1; j<=size; j++){
			
			DataFormatter formatter = new DataFormatter();
			String uname = formatter.formatCellValue(sheet.getRow(j).getCell(0));
			String email =formatter.formatCellValue( sheet.getRow(j).getCell(1));
            String query = formatter.formatCellValue(sheet.getRow(j).getCell(2));
			
			
			System.out.println(uname+" "+email+" "+query);
			
			hcp.clickLogin();
			Thread.sleep(1000);
			lp.setEmail("darman@gmail.com");
			lp.setPassword("darman@123");
			lp.clickButton();
			
			Thread.sleep(1000);
			hcp.clickContact();
			
			Thread.sleep(1000);
			hcp.setName(uname);
			
			Thread.sleep(1000);
			hcp.setEmail(email);
			
//			String status = hcp.getStatus();
//			switch (status) {
//			case "0":
//				hcp.clickSubmit();
//				Thread.sleep(1000);
//				String msg = hcp.getMessage();
//				System.out.println(msg);
//				sheet.getRow(j).createCell(3).setCellValue(msg);
//				Thread.sleep(1000);
//				up.gotoHome();
//				break;
//
//			case "-1":
//				Thread.sleep(1000);
//				sheet.getRow(j).createCell(3).setCellValue("Fail");
//				up.gotoHome();
//				break;
//			}
			Thread.sleep(1000);
			hcp.clickSubmit();
			
			Thread.sleep(1000);
			String msg = hcp.getMessage();
			System.out.println(msg);
			sheet.getRow(j).createCell(3).setCellValue(msg);
			
			Thread.sleep(1000);
			up.gotoHome();
		
		}
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\hp\\Desktop\\UserDashboard.xlsx");
		wb.write(fos);
		wb.close();
	}

}
