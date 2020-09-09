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
		
		Actions actions = new Actions(driver);
		
		driver.get(baseURL);
		logger.info("URL is opened");
		
		pr = new ProviderRegister_PageObject(driver);
		Thread.sleep(1000);
		
		//String path = "C:\\Users\\hp\\Desktop\\ProviderRegisterDatas.xlsx";
		FileInputStream fis = new FileInputStream(providerData);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Partner Details");
		
		int size = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(size);
		
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
			
			pr.getProvider();
			Thread.sleep(1000);
			
			pr.getReg();
			Thread.sleep(1000);
			
			pr.getFname(fname);
			logger.info("User entered the first name");
			
			pr.getLname(lname);
			logger.info("User entered the last name");
			
			pr.getEmail(mail);
			logger.info("User entered the mail");
			
			pr.getPassword(pass);
			logger.info("User entered the password");
			
			pr.getCPass(cpass);
			logger.info("User entered the confirm password");
			
			actions.moveToElement(pr.code()).click().perform();
			//pr.getCode().click();
			Thread.sleep(1000);
			
			List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]/li"));
			//System.out.println(list.size());
			
			for(int i=0; i<list.size(); i++){
				if(list.get(i).getText().equals(code)){
					//System.out.println(list.get(i).getText());
					list.get(i).click();
					break;
					
				}
			}
			logger.info("user selected the code");
			
			
			
			actions.moveToElement(pr.phone()).click().perform();
			pr.getPhone(phone);
			logger.info("User entered the phone number");
			
			String status = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/button[2]")).getAttribute("tabindex");
			System.out.println(status);
			
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
}
			

