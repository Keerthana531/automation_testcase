package com.yoloj.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.LoginPageObject;
import com.yoloj.PageObjects.UserDashboard_PageObject;


public class TC_UserDashboard extends BaseClass{
	
	@Test
	public void userTest() throws InterruptedException, IOException{
		
		logger.info("url opened");
		
		LoginPageObject lp = new LoginPageObject(driver);
		
		UserDashboard_PageObject ud = new UserDashboard_PageObject(driver);
		
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\Desktop\\UserDashboard.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		//getting the row count
		int size = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(size);
		
		//getting the data through looping
		for(int j=1; j<=size; j++){
			
			DataFormatter formatter = new DataFormatter();
			String uname = formatter.formatCellValue(sheet.getRow(j).getCell(0));
			String password =formatter.formatCellValue( sheet.getRow(j).getCell(1));
            String option = formatter.formatCellValue(sheet.getRow(j).getCell(2));
			String name = formatter.formatCellValue(sheet.getRow(j).getCell(3));
			String mail =formatter.formatCellValue( sheet.getRow(j).getCell(4));
			String code =formatter.formatCellValue( sheet.getRow(j).getCell(5));
			String phone = formatter.formatCellValue(sheet.getRow(j).getCell(6));
			
			System.out.println(uname+" "+password+" "+option+" "+name+" "+mail+" "+code+" "+phone);
			Thread.sleep(1000);
			ud.clickLogin();
			Thread.sleep(1000);
			lp.setEmail(uname);
			Thread.sleep(1000);
			lp.setPassword(password);
			Thread.sleep(1000);
			lp.clickButton();
			Thread.sleep(3000);
			
			ud.clickWelcome();
			Thread.sleep(3000);
			
			String opt[] = option.split(",");
			for(String Option:opt){
				System.out.println(Option);
				if(Option.equals("Name")){
					ud.getNameEdit();
					Thread.sleep(1000);
					ud.clearName();
					Thread.sleep(1000);
					ud.setName(name);
					Thread.sleep(1000);
					
				}
				else if(Option.equals("Email")){
					ud.getMailEdit();
					Thread.sleep(1000);
					ud.clearMail();
					Thread.sleep(1000);
					ud.setEmail(mail);
					Thread.sleep(1000);
					
				}
				
				else if(Option.equals("Phone")){
					ud.getPhoneEdit();
					Thread.sleep(1000);
					WebElement Phonecode = driver.findElement(By.id("formGroupPhoneNumber"));
					Thread.sleep(1000);
					Select s1 = new Select(Phonecode);
					s1.selectByVisibleText(code);
					Thread.sleep(1000);
					logger.info("user selected the code");
					Thread.sleep(1000);
					ud.clearPhone();
					Thread.sleep(1000);
					ud.setPhone(phone);
					Thread.sleep(1000);
					
				}
			}
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,2000)");
			
			String status = ud.getStatus();
			switch (status) {
			case "0":
				ud.selectUpdate();
				Thread.sleep(1000); 
				if(driver.findElements(By.className("MuiSnackbarContent-message")).size()!=0){
					String msg = ud.getMessage();
					System.out.println(msg);
				}
				
				sheet.getRow(j).createCell(7).setCellValue("Success");
				logger.info("Success");	
				ud.getMenu();
				Thread.sleep(1000); 
				ud.clickSignOut();
				Thread.sleep(1000); 
				break;

			case "-1":
				sheet.getRow(j).createCell(7).setCellValue("Fail");
				logger.info("Fail");
				Thread.sleep(1000); 
				ud.gotoBack();
				Thread.sleep(1000); 
				ud.clickLogout();
				Thread.sleep(1000); 
				break;
			}
			
	}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\hp\\Desktop\\UserDashboard.xlsx");
		wb.write(fos);
		wb.close();
	}
}
