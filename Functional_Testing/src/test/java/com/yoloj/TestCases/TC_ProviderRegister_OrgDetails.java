package com.yoloj.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
	public void OrgDetails() throws InterruptedException, IOException, AWTException{
		try{
			
			// getting the application url
			logger.info("URL is opened");
			
			//initializing the instance of page object
			pr = new ProviderRegister_PageObject(driver);
			Thread.sleep(1000);
			
			// getting the path from base class
			//String path = "C:\\Users\\hp\\Desktop\\ProviderRegisterDatas.xlsx";
			FileInputStream fis = new FileInputStream(providerData);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Organization Details");
			
			//getting the row count
			int size = sheet.getLastRowNum() - sheet.getFirstRowNum();
			System.out.println(size);
			
			//getting the data through looping
			for(int j=1; j<=size; j++){
				Actions actions = new Actions(driver);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				
				DataFormatter formatter = new DataFormatter();
	
				String orgname = formatter.formatCellValue(sheet.getRow(j).getCell(0));
				String orgaddress = formatter.formatCellValue( sheet.getRow(j).getCell(1));
				String fee = formatter.formatCellValue(sheet.getRow(j).getCell(2));
				String pincode = formatter.formatCellValue(sheet.getRow(j).getCell(3));
				String country = formatter.formatCellValue(sheet.getRow(j).getCell(4));
				String cty = formatter.formatCellValue(sheet.getRow(j).getCell(5));
				String add1 = formatter.formatCellValue( sheet.getRow(j).getCell(6));
				String add2 = formatter.formatCellValue(sheet.getRow(j).getCell(7));
				String regnum = formatter.formatCellValue(sheet.getRow(j).getCell(8));
				String regtype = formatter.formatCellValue(sheet.getRow(j).getCell(9));
				String image = formatter.formatCellValue(sheet.getRow(j).getCell(10));
				
				System.out.println(fname+" "+lname+" "+mail+" "+pass+" "+ConPass+" "+code+" "+phone+" "+
				orgname+" "+orgaddress+" "+fee+" "+pincode+" "+country+" "+cty+" "+add1+" "+add2+" "+regnum+" "+regtype);
				
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
				pr.getCPass(ConPass);
				logger.info("User entered the confirm password");
				
			//  clicking the code
				actions.moveToElement(pr.code()).click().perform();
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
				
				// clicking the phone number
				actions.moveToElement(pr.phone()).click().perform();
				pr.getPhone(phone);
				logger.info("User entered the phone number");
				
				// clicking the next button
				actions.moveToElement(pr.Next()).click().perform();
				logger.info("User is on next page");
				Thread.sleep(1000);
				
				// clicking the organisation name
				pr.getOrgName(orgname);
				logger.info("User entered the Organization name");
				Thread.sleep(1000);
				
				// clicking the organisation address
				pr.getOrgAddress(orgaddress);
				logger.info("User entered the organization address");
				Thread.sleep(1000);
				
				// clicking the fee
				pr.getFee(fee);
				logger.info("User entered the fee");
				Thread.sleep(1000);
				
				// clicking the pincode
				pr.getPinCode(pincode);
				logger.info("User entered the pincode");
				Thread.sleep(1000);
				
				// clicking the country
				pr.getCountry().click();                                        
				Thread.sleep(1000);
				List<WebElement> ctry = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')][@style='padding-right: 17px; width: calc(100% + 17px);']/li"));
				//System.out.println(list.size());
				for(int i=0; i<ctry.size(); i++){
					if(country.isEmpty()){
						ctry.get(0).click();
						logger.info("User entered the country");
						break;
					}
					else{
						if(ctry.get(i).getText().equals(country)){
							System.out.println(ctry.get(i).getText());
							ctry.get(i).click();
							logger.info("User entered the country");
							break;
								
						}
					}
				}
				
				// clicking the city
				pr.getCity().click();
				Thread.sleep(1000);
				List<WebElement> ctyy = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]/li"));
				
				for(int k=0; k<ctyy.size(); k++){
					if(cty.isEmpty()){
						ctyy.get(0).click();
						logger.info("User entered the city");
						break;
					}
					else{
						if(ctyy.size()<2){
							if(ctyy.get(k).getText().equals("Others")){
								System.out.println(ctyy.get(k).getText());
								ctyy.get(k).click();
								driver.findElement(By.id("otherCitiesLabel")).sendKeys(cty);
								logger.info("User entered city name");
								break;
								
							}
						}
						else{
							if(ctyy.get(k).getText().equals(cty)){
								System.out.println(ctyy.get(k).getText());
								ctyy.get(k).click();
								logger.info("User selected the city");
								break; 
							}
							else if(ctyy.get(k).getText().equals("Others")){
								System.out.println(ctyy.get(k).getText());
								ctyy.get(k).click();
								driver.findElement(By.id("otherCitiesLabel")).sendKeys(cty);
								logger.info("User entered city name");
								break;
								
							}
						}
					}
				}
				
				// clicking the address line 1
				pr.getAddress1(add1);
				logger.info("User entered the Address line1");
				Thread.sleep(1000);
				
				// clicking the address line 2
				pr.getAddress2(add2);
				logger.info("User entered the Address line2");
				Thread.sleep(1000);
				
				//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				// clicking the Organisation Register number
				pr.getOrgNumber(regnum);
				logger.info("User entered the Organization Register Number");
				Thread.sleep(1000);
				
				// clicking the Pintype
				pr.getOrgPin(regtype);
				logger.info("User entered the Pin type");
				Thread.sleep(1000);
				
				// Scrolling the window
				js.executeScript("window.scrollBy(0,2000)");
				Thread.sleep(2000);
				
				// clicking the image
				actions.moveToElement(driver.findElement(By.id("raised-button-file"))).click().perform();
				logger.info("User selected the image button");
				Thread.sleep(1000);
				
				ClipboardOwner owner = null;
				String img = System.getProperty("user.dir")+"\\images\\"+image;
				
				Robot robot = new Robot();
				StringSelection attachment = new StringSelection(img);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(attachment, owner);
				
				robot.setAutoDelay(3000);
				if(image.isEmpty()){
					robot.keyPress(KeyEvent.VK_CANCEL);
				}
				else{
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_K);
				
				robot.setAutoDelay(3000);
				robot.keyPress(KeyEvent.VK_ENTER);
	//			robot.keyPress(KeyEvent.VK_ENTER);
				}
				
				logger.info("User selected the image");
				
				Thread.sleep(1000);
				
				// checking for next button
				switch (pr.getStatus()){
				
				case "0":
					actions.moveToElement(pr.Next()).click().perform();
					Thread.sleep(2000);
					logger.info("User is on next page");
					pr.gotoHome();
					logger.info("User is on home page");
					System.out.println("Success");
					sheet.getRow(j).createCell(11).setCellValue("Success");
					break;
				case "-1":
					pr.gotoBack();
					logger.info("User is on previous page");
					pr.gotoHome();
					logger.info("User is on home page");
					System.out.println("Fail");
					sheet.getRow(j).createCell(11).setCellValue("Fail");
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
