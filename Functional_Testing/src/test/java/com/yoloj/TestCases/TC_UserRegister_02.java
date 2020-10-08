package com.yoloj.TestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
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
				logger.info("URL is opened");
				
				//initializing the instance of page object
				up = new UserRegister_PageObject(driver);
				Thread.sleep(2000);
				
				// user clicking the register button
				up.ClickRegisterbtn();
				logger.info("User clicked the Register button");
				Thread.sleep(1000);
				
				// getting the path from base class
				String path = "C:\\Users\\hp\\Desktop\\UserRegister_TestData.xlsx";
				FileInputStream fis = new FileInputStream(path);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheet("Sheet1");
				
				//getting the row count
				int size = sheet.getLastRowNum() -  sheet.getFirstRowNum();
				System.out.println(size);
				
				//getting the data through looping
				for(int i=14; i<=size; i++){
					
					DataFormatter formatter = new DataFormatter();
					
					String name_errormsg="";
					String mail_errormsg = "";
					String pass_errormsg = "";
					String confirmpass_errormsg = "";
					String phone_errormsg = "";
					String name_status = "";
					String email_status = "";
					String password_status = "";
					String confirm_password_status = "";
					String phone_number_status = "";
					String name = formatter.formatCellValue(sheet.getRow(i).getCell(0));
					String email = formatter.formatCellValue(sheet.getRow(i).getCell(1));
					String password = formatter.formatCellValue(sheet.getRow(i).getCell(2));
					String ConfirmPass = formatter.formatCellValue(sheet.getRow(i).getCell(3));
					String code = formatter.formatCellValue(sheet.getRow(i).getCell(4));
					String phone = formatter.formatCellValue(sheet.getRow(i).getCell(5));
					
					System.out.println(name+" "+email+" "+password+" "+ConfirmPass+" "+code+" "+phone);
					
					Actions action = new Actions(driver);
					//user setting the name
					up.setName(name);
					logger.info("User entered the name");
					Thread.sleep(2000);
					//Checking for invalid message
					if(driver.findElements(By.id("name-helper-text")).size()!=0){
						name_errormsg = up.getNameError();
						System.out.println(name_errormsg);
					} 
					
					//user setting the mail
					up.setEmail(email);
					logger.info("User entered the mail");
					Thread.sleep(2000);
					//Checking for invalid message
					if(driver.findElements(By.id("email-helper-text")).size()!=0){
						mail_errormsg = up.getEmailError();
						System.out.println(mail_errormsg);
						
					}
					//user setting the password
					up.setPassword(password);
					logger.info("User entered the password");
					Thread.sleep(2000);
					//Checking for invalid message
					if(driver.findElements(By.id("password-helper-text")).size()!=0){
						pass_errormsg = up.getPasswordError();
						System.out.println(pass_errormsg);
						
					}
					//user setting the confirm password
					up.setConfirmPassword(ConfirmPass);
					logger.info("User confirmed the password");
					Thread.sleep(2000);
					//Checking for invalid message
					if(driver.findElements(By.id("confirm_password-helper-text")).size()!=0){
						confirmpass_errormsg = up.getConfirmPassError();
						System.out.println(confirmpass_errormsg);
						
					}
					//user selecting the code from drop down
					driver.findElement(By.id("demo-simple-select")).click();
					Thread.sleep(1000);
					List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]/li"));
					for(int j=0; j<list.size(); j++){
						if(list.get(j).getText().equals(code)){
							//System.out.println(list.get(j).getText());
							list.get(j).click();
							break;
							
						}
					}
					logger.info("user selected the code");
					//user setting the phone number
					action.moveToElement(up.phone()).click().perform();
					up.setPhone(phone);
					logger.info("User entered the number");
					Thread.sleep(2000);
					//Checking for invalid message
					if(driver.findElements(By.id("phone_number-helper-text")).size()!=0){
						phone_errormsg = up.getPhoneError();
						System.out.println(phone_errormsg);
					}
					
					//checking the status of empty field
					Thread.sleep(1000);
					if(driver.findElement(By.xpath("//*[@id=\"name-label\"]")).getAttribute("data-shrink").equals("false")){
						 name_status = "Name field is empty";
						 System.out.println(name_status);
					}
					if(driver.findElement(By.xpath("//*[@id=\"email-label\"]")).getAttribute("data-shrink").equals("false")){
						email_status = "Email field is empty";
						System.out.println(email_status);
					}
					if(driver.findElement(By.xpath("//*[@id=\"password-label\"]")).getAttribute("data-shrink").equals("false")){
						password_status = "Password field is empty";
						System.out.println(password_status);
					}
					if(driver.findElement(By.xpath("//*[@id=\"confirm_password-label\"]")).getAttribute("data-shrink").equals("false")){
						confirm_password_status = "Confirm Password field is empty";
						System.out.println(confirm_password_status);
					}
					if(driver.findElement(By.xpath("//*[@id=\"phone_number-label\"]")).getAttribute("data-shrink").equals("false")){
						phone_number_status = "Phone Number field is empty";
						System.out.println(phone_number_status);
					}
					
					//user selecting the create account
					Thread.sleep(1000);
					up.createAccount();
					logger.info("User clicked the create account");	
					Thread.sleep(2000);
					
					//Checking the status of result
					if(name_errormsg.length()!=0 || mail_errormsg.length()!=0 || pass_errormsg.length()!=0 || confirmpass_errormsg.length()!=0 || phone_errormsg.length()!=0){
						sheet.getRow(i).createCell(6).setCellValue("Fail");
						logger.info("Fail");	
					}
					else if(name_status.length()!=0 || email_status.length()!=0 || password_status.length()!=0 || confirm_password_status.length()!=0 || phone_number_status.length()!=0){
						sheet.getRow(i).createCell(6).setCellValue("Fail");
						logger.info("Fail");
					}
					else{
						sheet.getRow(i).createCell(6).setCellValue("Success");
						logger.info("Success");	
					}
					
					
					driver.get("http://3.83.124.93:3000/register");
					logger.info("Resetting the value");
				}
				
				FileOutputStream fos = new FileOutputStream(path);
				wb.write(fos);
				wb.close();
			
			}
			catch(Exception e){
				System.out.println("Error Message"+e.getMessage());
			}
	}

}









//user capturing the error message
//if(driver.findElements(By.className("MuiSnackbarContent-message")).size()!=0){
//	msg = up.getExistmsg();
//	System.out.println(msg);
//}
//
//up.gotoLogin();
//Thread.sleep(2000);
//user navigating to home page
//up.gotoHome();
//logger.info("User is on the home page");
//Thread.sleep(2000);

//if(msg.length()!=0){
//	sheet.getRow(i).createCell(6).setCellValue(msg);
//	System.out.println(msg);
//}

//Actions action = new Actions(driver);
//action.moveToElement(up.crtbutton()).click().perform();

//String name = sheet.getRow(i).getCell(0).getStringCellValue();
//String email = sheet.getRow(i).getCell(1).getStringCellValue();
//String password = sheet.getRow(i).getCell(2).getStringCellValue();
//String ConfirmPass = sheet.getRow(i).getCell(3).getStringCellValue();
//String code = sheet.getRow(i).getCell(4).getStringCellValue();
//String phone = String.valueOf(sheet.getRow(i).getCell(5).getNumericCellValue());
