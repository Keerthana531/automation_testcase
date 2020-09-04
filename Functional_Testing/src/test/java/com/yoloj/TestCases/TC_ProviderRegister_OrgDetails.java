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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.ProviderRegister_PageObject;

public class TC_ProviderRegister_OrgDetails extends BaseClass{
	
	@Test
	public void OrgDetails() throws InterruptedException, IOException{
		
		driver.get(baseURL);
		logger.info("URL is opened");
		
		pr = new ProviderRegister_PageObject(driver);
		Thread.sleep(1000);
		
		String path = "C:\\Users\\hp\\Desktop\\ProviderRegisterDatas.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Organization Details");
		
		int size = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(size);
		
		for(int j=1; j<=size; j++){
			Actions actions = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			DataFormatter formatter = new DataFormatter();
			
			String fname = formatter.formatCellValue(sheet.getRow(j).getCell(0));
			String lname = formatter.formatCellValue(sheet.getRow(j).getCell(1));
			String mail =formatter.formatCellValue( sheet.getRow(j).getCell(2));
			String pass = formatter.formatCellValue(sheet.getRow(j).getCell(3));
			String cpass = formatter.formatCellValue(sheet.getRow(j).getCell(4));
			String code =formatter.formatCellValue( sheet.getRow(j).getCell(5));
			String phone = formatter.formatCellValue(sheet.getRow(j).getCell(6));
			String orgname = formatter.formatCellValue(sheet.getRow(j).getCell(7));
			String orgaddress = formatter.formatCellValue( sheet.getRow(j).getCell(8));
			String fee = formatter.formatCellValue(sheet.getRow(j).getCell(9));
			String pincode = formatter.formatCellValue(sheet.getRow(j).getCell(10));
			String country = formatter.formatCellValue(sheet.getRow(j).getCell(11));
			String cty = formatter.formatCellValue(sheet.getRow(j).getCell(12));
			String add1 = formatter.formatCellValue( sheet.getRow(j).getCell(13));
			String add2 = formatter.formatCellValue(sheet.getRow(j).getCell(14));
			String regnum = formatter.formatCellValue(sheet.getRow(j).getCell(15));
			String regtype = formatter.formatCellValue(sheet.getRow(j).getCell(16));
			
			System.out.println(fname+" "+lname+" "+mail+" "+pass+" "+cpass+" "+code+" "+phone+" "+
			orgname+" "+orgaddress+" "+fee+" "+pincode+" "+country+" "+cty+" "+add1+" "+add2+" "+regnum+" "+regtype);
			
			
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
					System.out.println(list.get(i).getText());
					list.get(i).click();
					break;
					
				}
			}
			logger.info("user selected the code");
			
			
			
			actions.moveToElement(pr.phone()).click().perform();
			pr.getPhone(phone);
			logger.info("User entered the phone number");
//			js.executeScript("arguments[0].scrollIntoview();", pr.Next());
//			pr.gotoNext();
			actions.moveToElement(pr.Next()).click().perform();
			logger.info("User is on next page");
			Thread.sleep(1000);
			pr.getOrgName(orgname);
			Thread.sleep(1000);
			
			pr.getOrgAddress(orgaddress);
			Thread.sleep(1000);
			
			pr.getFee(fee);
			Thread.sleep(1000);
			
			pr.getPinCode(pincode);
			Thread.sleep(1000);
			
			pr.getCountry().click();                                        //*[@id="menu-"]/div[3]/ul   //*[@id="menu-"]/div[3]/ul
			Thread.sleep(1000);
			List<WebElement> ctry = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')][@style='padding-right: 17px; width: calc(100% + 17px);']/li"));
			//System.out.println(list.size());
			
			for(int i=0; i<ctry.size(); i++){
				if(ctry.get(i).getText().equals(country)){
					System.out.println(ctry.get(i).getText());
					ctry.get(i).click();
					break;
					
				}
			}
			
			pr.getCity().click();
			Thread.sleep(1000);
			List<WebElement> ctyy = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]/li"));
			
			for(int k=0; k<ctyy.size(); k++){
				if(ctyy.get(k).getText().equals("Others")){
					System.out.println(ctyy.get(k).getText());
					ctyy.get(k).click();
					driver.findElement(By.id("otherCitiesLabel")).sendKeys(cty);
					break;
					
				}
			}
			
			pr.getAddress1(add1);
			Thread.sleep(1000);
			pr.getAddress2(add2);
			Thread.sleep(1000);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			pr.getOrgNumber(regnum);
			Thread.sleep(1000);
			pr.getOrgPin(regtype);
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2000)");
			pr.gotoNext();
			Thread.sleep(1000);
			
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
			default:
				pr.gotoHome();
				logger.info("User is on home page");
				System.out.println("Fail");
				sheet.getRow(j).createCell(7).setCellValue("Fail");
				break;
			
			}
		}

		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
	}

}
