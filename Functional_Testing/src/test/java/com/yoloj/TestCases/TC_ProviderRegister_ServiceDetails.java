package com.yoloj.TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.ProviderRegister_PageObject;

public class TC_ProviderRegister_ServiceDetails extends BaseClass{
	
	@Test
	public void ServideType() throws InterruptedException, IOException, AWTException{
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
			XSSFSheet sheet = wb.getSheet("Services Details");
			
			//getting the row count
			int size = sheet.getLastRowNum() - sheet.getFirstRowNum();
			System.out.println(size);
			
			//getting the data through looping
			for(int j=1; j<=size; j++){
				Actions actions = new Actions(driver);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				
				DataFormatter formatter = new DataFormatter();
				
				String stype = formatter.formatCellValue(sheet.getRow(j).getCell(0));
				String sexpert = formatter.formatCellValue(sheet.getRow(j).getCell(1));
				String sdetail = formatter.formatCellValue(sheet.getRow(j).getCell(2));
				String business = formatter.formatCellValue(sheet.getRow(j).getCell(3));
				String button = formatter.formatCellValue(sheet.getRow(j).getCell(4));
				
				System.out.println(fname+" "+lname+" "+mail+" "+pass+" "+ConPass+" "+code+" "+phone+" "+
						orgName+" "+orgAddress+" "+fee+" "+pinCode+" "+country+" "+city+" "+address1+" "+address2+" "+regNum+" "+pinType+" "+stype+" "+sexpert);
				
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
				
				// clicking the organisation name
				pr.getOrgName(orgName);
				logger.info("User entered Organization name");
				Thread.sleep(1000);
				
				// clicking the organisation address
				pr.getOrgAddress(orgAddress);
				logger.info("User entered Organization address");
				Thread.sleep(1000);
				
				// clicking the fee
				pr.getFee(fee);
				logger.info("User entered fee");
				Thread.sleep(1000);
				
				// clicking the pincode
				pr.getPinCode(pinCode);
				logger.info("User entered pincode");
				Thread.sleep(1000);
				
				// clicking the country
				//pr.getCountry().click();
				//pr.getCountry().sendKeys("India");
				Thread.sleep(1000);
//				List<WebElement> ctry = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')][@style='padding-right: 17px; width: calc(100% + 17px);']/li"));
//				//System.out.println(list.size());
//				
//				for(int i=0; i<ctry.size(); i++){
//					if(country.isEmpty()){
//						ctry.get(0).click();
//						break;
//					}
//					else{
//						if(ctry.get(i).getText().equals(country)){
//							System.out.println(ctry.get(i).getText());
//							ctry.get(i).click();
//							break;
//								
//						}
//					}
//				}
				logger.info("country is entered");
				// clicking the city
				pr.getCity().click();
				Thread.sleep(1000);
				List<WebElement> ctyy = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]/li"));
				
				for(int k=0; k<ctyy.size(); k++){
					if(city.isEmpty()){
						ctyy.get(0).click();
						break;
					}
					else{
						if(ctyy.size()<2){
							if(ctyy.get(k).getText().equals("Others")){
								System.out.println(ctyy.get(k).getText());
								ctyy.get(k).click();
								driver.findElement(By.id("otherCitiesLabel")).sendKeys(city);
								logger.info("User entered city name");
								break;
								
							}
						}
						else{
							if(ctyy.get(k).getText().equals(city)){
								System.out.println(ctyy.get(k).getText());
								ctyy.get(k).click();
								logger.info("User selected the city");
								break; 
							}
							else if(ctyy.get(k).getText().equals("Others")){
								System.out.println(ctyy.get(k).getText());
								ctyy.get(k).click();
								driver.findElement(By.id("otherCitiesLabel")).sendKeys(city);
								logger.info("User entered city name");
								break;
								
							}
						}
					}
				}
				// clicking the address line 1
				pr.getAddress1(address1);
				logger.info("User entered address line 1");
				Thread.sleep(1000);
				
				// clicking the address line 2
				pr.getAddress2(address2);
				logger.info("User entered address line 2");
				Thread.sleep(1000);
				
				//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				// clicking the Organisation Register number
				pr.getOrgNumber(regNum);
				logger.info("User entered Organization Registration number");
				Thread.sleep(1000);
				
				// clicking the Pintype
				pr.getOrgPin(pinType);
				logger.info("User entered Organization Pin type");
				Thread.sleep(1000);
				
				// Scrolling the window
				js.executeScript("window.scrollBy(0,2000)");
				Thread.sleep(1000);
				
				// clicking the image
				driver.findElement(By.id("raised-button-file")).click();
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
				robot.keyPress(KeyEvent.VK_ENTER);
				
				}
				logger.info("User selected the image");
				Thread.sleep(1000);
				
				//Clicking the next button
				pr.gotoNext();
				Thread.sleep(1000);
				
				//Clicking the Service Type
				pr.getServiceType();
				String type[]=stype.split(",");
				for(String opt: type){
					Thread.sleep(1000);
					//Selecting the Service Type
					pr.selectService(opt);
					Thread.sleep(1000);
				}
				logger.info("User selected Service type");
				
				//Clicking the Service Expertise
				pr.getServiceExpertise();
				String expert[]=sexpert.split(",");
				for(String opt1:expert){
					Thread.sleep(1000);
					//Selecting the Service Expertise
					pr.selectService(opt1);
					Thread.sleep(1000);
				}
				logger.info("User selected Service Expertise");
				
				//Selecting the field to close the dropdown
				pr.select();
				Thread.sleep(1000);
				
				//Checking the status of next button
				switch (pr.getStatus()){
				
					case "0":
						actions.moveToElement(pr.Next()).click().perform();
						Thread.sleep(1000);
						logger.info("User is on next page");
						
						//Clicking the individual button
						pr.getIndividual();
						Thread.sleep(2000);
						
						//Expanding the individual dropdown
						pr.getFirstInd();
						Thread.sleep(2000);
						 
						 String sdet[]=sdetail.split(",");
						 for(String det:sdet){
							System.out.println(det);
							
								if(Arrays.stream(individualOptions).anyMatch(det::equals)){
									List<WebElement> detail = driver.findElements(By.className("rct-title"));
									System.out.println(detail.size());                 
									for(int i=0; i<detail.size(); i++){
									if(detail.get(i).getText().equals(det)){
										System.out.println(detail.get(i).getText());
										detail.get(i).click(); 
										Thread.sleep(1000);
										break;
										
									}
									
								}
									logger.info("User selected Individual service details");
									}
								else if(Arrays.stream(taxOptions).anyMatch(det::equals)){
									pr.getSecondInd();
									 Thread.sleep(1000);
									 List<WebElement> detail = driver.findElements(By.className("rct-title"));
										System.out.println(detail.size());                 
										for(int i=0; i<detail.size(); i++){
									 if(detail.get(i).getText().equals(det)){
											System.out.println(detail.get(i).getText());
											detail.get(i).click(); 
											Thread.sleep(1000);
											break;
											
										}
									
									}
										logger.info("User selected Individual service details");
								}
								else if(Arrays.stream(tdsOptions).anyMatch(det::equals)){
									pr.getThirdInd();
									 Thread.sleep(1000);
									 List<WebElement> detail = driver.findElements(By.className("rct-title"));
										System.out.println(detail.size());                 
										for(int i=0; i<detail.size(); i++){
									 if(detail.get(i).getText().equals(det)){
											System.out.println(detail.get(i).getText());
											detail.get(i).click(); 
											Thread.sleep(1000);
											break;
											
										}
										}
								}
								else if(Arrays.stream(legalOptions).anyMatch(det::equals)){
									pr.getFourthInd();
									 Thread.sleep(1000);
									 List<WebElement> detail = driver.findElements(By.className("rct-title"));
										System.out.println(detail.size());                 
										for(int i=0; i<detail.size(); i++){
									 if(detail.get(i).getText().equals(det)){
											System.out.println(detail.get(i).getText());
											detail.get(i).click(); 
											Thread.sleep(1000);
											break;
											
										}
									}
										logger.info("User selected Individual service details");
								}
								else if(Arrays.stream(IndMisc).anyMatch(det::equals)){
									pr.getFifthInd();
									 Thread.sleep(1000);
									 List<WebElement> detail = driver.findElements(By.className("rct-title"));
										System.out.println(detail.size());                 
										for(int i=0; i<detail.size(); i++){
									 if(detail.get(i).getText().equals(det)){
											System.out.println(detail.get(i).getText());
											detail.get(i).click(); 
											Thread.sleep(1000);
											break;
											
										}
									}
										logger.info("User selected Individual service details");
								}
								else if(sdet.length==0){
									pr.getFirstInd();
								}
								else{
									continue;
								}
							}
						 
						//Closing the individual dropdown
						pr.getIndividual();
						Thread.sleep(1000);
						
						//Clicking the business button
						pr.getBusiness();
						Thread.sleep(2000);
						
						//Expanding the business dropdown
						pr.getFirstBusiness();
						Thread.sleep(2000);
						js.executeScript("window.scrollBy(0,2000)");
						Thread.sleep(1000);
						String sbus[]=business.split(",");
						for(String bu:sbus){
							System.out.println(bu);
							if(Arrays.stream(businessOptions).anyMatch(bu::equals)){
								List<WebElement> bus = driver.findElements(By.className("rct-title"));
								System.out.println(bus.size());
								for(int i=0; i<bus.size(); i++){
									if(bus.get(i).getText().equals(bu)){
										System.out.println(bus.get(i).getText());
										bus.get(i).click();
										Thread.sleep(1000);
										break;
										
									}
									
								}
								logger.info("User selected Business service details");
							}
							else if(Arrays.stream(busIncOptions).anyMatch(bu::equals)){
								pr.getSecondBusiness();
								Thread.sleep(1000);
								List<WebElement> bus = driver.findElements(By.className("rct-title"));
								System.out.println(bus.size());
								for(int i=0; i<bus.size(); i++){
									if(bus.get(i).getText().equals(bu)){
										System.out.println(bus.get(i).getText());
										bus.get(i).click();
										Thread.sleep(1000);
										break;
										
									}
									
								}
								logger.info("User selected Business service details");
							}
							else if(Arrays.stream(gstOptions).anyMatch(bu::equals)){
								pr.getThirdBusiness();
								Thread.sleep(1000);
								List<WebElement> bus = driver.findElements(By.className("rct-title"));
								System.out.println(bus.size());
								for(int i=0; i<bus.size(); i++){
									if(bus.get(i).getText().equals(bu)){
										System.out.println(bus.get(i).getText());
										bus.get(i).click();
										Thread.sleep(1000);
										break;
										
									}
									
								}
								logger.info("User selected Business service details");
							}
							else if(Arrays.stream(startupOptions).anyMatch(bu::equals)){
								pr.getFourthBusiness();
								Thread.sleep(1000);
								List<WebElement> bus = driver.findElements(By.className("rct-title"));
								System.out.println(bus.size());
								for(int i=0; i<bus.size(); i++){
									if(bus.get(i).getText().equals(bu)){
										System.out.println(bus.get(i).getText());
										bus.get(i).click();
										Thread.sleep(1000);
										break;
										
									}
									
								}
								logger.info("User selected Business service details");
							}
							else if(Arrays.stream(legalCompOptions).anyMatch(bu::equals)){
								pr.getFifthBusiness();
								Thread.sleep(1000);
								List<WebElement> bus = driver.findElements(By.className("rct-title"));
								System.out.println(bus.size());
								for(int i=0; i<bus.size(); i++){
									if(bus.get(i).getText().equals(bu)){
										System.out.println(bus.get(i).getText());
										bus.get(i).click();
										Thread.sleep(1000);
										break;
										
									}
									
								}
								logger.info("User selected Business service details");
							}
							else if(Arrays.stream(taxOption).anyMatch(bu::equals)){
								pr.getSixthBusiness();
								Thread.sleep(1000);
								List<WebElement> bus = driver.findElements(By.className("rct-title"));
								System.out.println(bus.size());
								for(int i=0; i<bus.size(); i++){
									if(bus.get(i).getText().equals(bu)){
										System.out.println(bus.get(i).getText());
										bus.get(i).click();
										Thread.sleep(1000);
										break;
										
									}
									
								}
								logger.info("User selected Business service details");
							}
							else if(Arrays.stream(govrOptions).anyMatch(bu::equals)){
								pr.getSeventhBusiness();
								Thread.sleep(1000);
								List<WebElement> bus = driver.findElements(By.className("rct-title"));
								System.out.println(bus.size());
								for(int i=0; i<bus.size(); i++){
									if(bus.get(i).getText().equals(bu)){
										System.out.println(bus.get(i).getText());
										bus.get(i).click();
										Thread.sleep(1000);
										break;
										
									}
									
								}
								logger.info("User selected Business service details");
							}
							else if(Arrays.stream(tradeOptions).anyMatch(bu::equals)){
								pr.getEigthBusiness();
								Thread.sleep(1000);
								List<WebElement> bus = driver.findElements(By.className("rct-title"));
								System.out.println(bus.size());
								for(int i=0; i<bus.size(); i++){
									if(bus.get(i).getText().equals(bu)){
										System.out.println(bus.get(i).getText());
										bus.get(i).click();
										Thread.sleep(1000);
										break;
										
									}
									
								}
								logger.info("User selected Business service details");
							}
							else if(Arrays.stream(BusinessMisc).anyMatch(bu::equals)){
								pr.getNinthtBusiness();
								Thread.sleep(1000);
								List<WebElement> bus = driver.findElements(By.className("rct-title"));
								System.out.println(bus.size());
								for(int i=0; i<bus.size(); i++){
									if(bus.get(i).getText().equals(bu)){
										System.out.println(bus.get(i).getText());
										bus.get(i).click();
										Thread.sleep(1000);
										break;
										
									}
								
								}
								logger.info("User selected Business service details");
							}
							else if(sbus.length==0){
								pr.getFirstBusiness();
							}
							else{
								continue;
							}
						}
						js.executeScript("window.scrollBy(0,-1000)");
						Thread.sleep(1000);
						
						//Closing the business dropdown
						pr.getBusiness();
						Thread.sleep(2000);
						if(button.equals("Reset")){
							pr.selectReset();
							logger.info("User selected Reset button");
							pr.gotoHome();
							logger.info("User is on home page");
							sheet.getRow(j).createCell(5).setCellValue("Success");
							break;
						}
						else if(button.equals("Create")){
							String status = pr.getCreateStatus();
							System.out.println(status);
							if (status.equals("0")){
								pr.selectCreate();
								logger.info("User selected create button");
								Thread.sleep(2000);
								pr.gotoHome();
								logger.info("User is on home page");
								Thread.sleep(2000);
								sheet.getRow(j).createCell(5).setCellValue("Success");
								break;
							}
							else if(status.equals("-1")){
								pr.gotoHome();
								logger.info("User is on home page");
								sheet.getRow(j).createCell(5).setCellValue("Fail");
								break;
							}
						}
					
				case "-1":
					pr.gotoBack();
					logger.info("User is on previous page");
					pr.gotoHome();
					logger.info("User is on home page");
					System.out.println("Fail");
					sheet.getRow(j).createCell(5).setCellValue("Fail");
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
