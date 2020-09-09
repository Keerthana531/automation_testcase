package com.yoloj.TestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.UserRegister_PageObject;

public class TC_UserRegister_02 extends BaseClass{
	@Test
	public void test2(){
	
		try{
				
				// getting the application url
		//		driver.get(baseURL);
				logger.info("URL is opened");
				
				//initializing the instance of page object
				up = new UserRegister_PageObject(driver);
				Thread.sleep(2000);
				
				// getting the path from base class
				//String path = "C:\\Users\\hp\\Desktop\\User_Register_Test_Data.xlsx";
				FileInputStream fis = new FileInputStream(userRegisterPath);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheet("Sheet1");
				
				//getting the row count
				int size = sheet.getLastRowNum() -  sheet.getFirstRowNum();
				System.out.println(size);
				
				//getting the data through looping
				for(int i=11; i<=size; i++){
					
					String msg = "";
					String name = sheet.getRow(i).getCell(0).getStringCellValue();
					String email = sheet.getRow(i).getCell(1).getStringCellValue();
					String password = sheet.getRow(i).getCell(2).getStringCellValue();
					String ConfirmPass = sheet.getRow(i).getCell(3).getStringCellValue();
					String code = sheet.getRow(i).getCell(4).getStringCellValue();
					String phone = sheet.getRow(i).getCell(5).getRawValue();
					
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
					Thread.sleep(1000);
					//user capturing the error message
					if(driver.findElements(By.className("MuiSnackbarContent-message")).size()!=0){
						msg = up.getExistmsg();
						System.out.println(msg);
					}
					//user navigating to home page
					up.gotoHome();
					logger.info("User is on the home page");
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
