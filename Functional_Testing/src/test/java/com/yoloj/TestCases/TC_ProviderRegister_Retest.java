package com.yoloj.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.ProviderRegister_PageObject;

public class TC_ProviderRegister_Retest extends BaseClass {
	
	@Test
	public void providerRegister() throws InterruptedException, IOException{
		try{
			
			Actions actions = new Actions(driver);
			// getting the application url
			logger.info("URL is opened");
			
			//initializing the instance of page object
			pr = new ProviderRegister_PageObject(driver);
			Thread.sleep(1000);
			
			// getting the path from base class
			//String path = "C:\\Users\\hp\\Desktop\\ProviderRegisterDatas.xlsx";
			FileInputStream fis = new FileInputStream(providerData);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Partner Details");
			
			//getting the row count
			int size = sheet.getLastRowNum() - sheet.getFirstRowNum();
			System.out.println(size);
			
			//getting the data through looping
			for(int j=1; j<=size; j++){
				
				DataFormatter formatter = new DataFormatter();
	            String fname = formatter.formatCellValue(sheet.getRow(j).getCell(0));
				String lname = formatter.formatCellValue(sheet.getRow(j).getCell(1));
				String mail =formatter.formatCellValue( sheet.getRow(j).getCell(2));
				String pass = formatter.formatCellValue(sheet.getRow(j).getCell(3));
				String cpass = formatter.formatCellValue(sheet.getRow(j).getCell(4));
				String code =formatter.formatCellValue( sheet.getRow(j).getCell(5));
				String phone = formatter.formatCellValue(sheet.getRow(j).getCell(6));
				
				
				System.out.println(fname+" "+lname+" "+mail+" "+pass+" "+cpass+" "+code+" "+phone);
				//clicking the provider button
				pr.getProvider();
				Thread.sleep(1000);
				logger.info("User clicked the provider button");
				
				// clicking the register button
				pr.getReg();
				Thread.sleep(1000);
				logger.info("User clicked the Register button");
				
				//  clicking the first name
				pr.getFname(fname);
				logger.info("User entered the first name");
				
				// clicking the last name
				pr.getLname(lname);
				logger.info("User entered the last name");
				
				//  clicking the email
				pr.getEmail(mail);
				logger.info("User entered the mail");
				
				//  clicking the password
				pr.getPassword(pass);
				logger.info("User entered the password");
				
				// clicking the confirm password
				pr.getCPass(cpass);
				logger.info("User entered the confirm password");
				Thread.sleep(1000);
				
				//  clicking the code
				actions.moveToElement(pr.code()).click().perform();
				Thread.sleep(1000);
				List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]/li"));
				for(int i=0; i<list.size(); i++){
					if(list.get(i).getText().equals(code)){
						System.out.println(list.get(i).getText());
						list.get(i).click();
						break;
					}
				}
				logger.info("user selected the code");
				
				// clicking the phone number
				actions.moveToElement(pr.phone()).click().perform();
				pr.getPhone(phone);
				logger.info("User entered the phone number");
				
				// checking the status of next button
				String status = pr.getStatus();
				switch (status){
				
				case "0":
					actions.moveToElement(pr.Next()).click().perform();
					Thread.sleep(2000);
					logger.info("User is on next page");
					pr.gotoHome();
					logger.info("User is on home page");
					System.out.println("Success");
					sheet.getRow(j).createCell(7).setCellValue("Success");
					break;
				case "-1":
					pr.gotoHome();
					logger.info("User is on home page");
					System.out.println("Fail");
					sheet.getRow(j).createCell(7).setCellValue("Fail");
					break;
				
				}
				
			}
			FileOutputStream fos = new FileOutputStream(providerData);
			wb.write(fos);
			wb.close();
		}
		catch(Exception e){
		System.out.println("Error Message"+e.getMessage());
			}
	}
}
			

