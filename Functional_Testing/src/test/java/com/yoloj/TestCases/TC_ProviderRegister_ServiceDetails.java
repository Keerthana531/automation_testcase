package com.yoloj.TestCases;

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
	public void ServideType() throws InterruptedException, IOException{
		
		driver.get(baseURL);
		logger.info("URL is opened");
		
		pr = new ProviderRegister_PageObject(driver);
		Thread.sleep(1000);
		
		String path = "C:\\Users\\hp\\Desktop\\ProviderRegisterDatas.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Services Details");
		
		int size = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println(size);
		
		for(int j=4; j<=size; j++){
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
			String stype = formatter.formatCellValue(sheet.getRow(j).getCell(17));
			String sexpert = formatter.formatCellValue(sheet.getRow(j).getCell(18));
			String sdetail = formatter.formatCellValue(sheet.getRow(j).getCell(19));
			String business = formatter.formatCellValue(sheet.getRow(j).getCell(20));
			
			System.out.println(fname+" "+lname+" "+mail+" "+pass+" "+cpass+" "+code+" "+phone+" "+
			orgname+" "+orgaddress+" "+fee+" "+pincode+" "+country+" "+cty+" "+add1+" "+add2+" "+regnum+" "+regtype+" "+stype+" "+sexpert);
			
			
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
			
			actions.moveToElement(pr.Next()).click().perform();
			logger.info("User is on next page");
			pr.getOrgName(orgname);
			logger.info("User entered Organization name");
			Thread.sleep(1000);
			
			pr.getOrgAddress(orgaddress);
			logger.info("User entered Organization address");
			Thread.sleep(1000);
			
			pr.getFee(fee);
			logger.info("User entered fee");
			Thread.sleep(1000);
			
			pr.getPinCode(pincode);
			logger.info("User entered pincode");
			Thread.sleep(1000);
			
			pr.getCountry().click();                                        
			Thread.sleep(1000);
			List<WebElement> ctry = driver.findElements(By.xpath("//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')][@style='padding-right: 17px; width: calc(100% + 17px);']/li"));
			//System.out.println(list.size());
			
			for(int i=0; i<ctry.size(); i++){
				if(ctry.get(i).getText().equals(country)){
					System.out.println(ctry.get(i).getText());
					ctry.get(i).click();
					logger.info("User selected the country");
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
					logger.info("User entered city name");
					break;
					
				}
				else if(ctyy.get(k).getText().equals(cty)){
					System.out.println(ctyy.get(k).getText());
					ctyy.get(k).click();
					logger.info("User selected the city");
					break; 
				}
			}
			
			pr.getAddress1(add1);
			logger.info("User entered address line 1");
			Thread.sleep(1000);
			pr.getAddress2(add2);
			logger.info("User entered address line 2");
			Thread.sleep(1000);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			pr.getOrgNumber(regnum);
			logger.info("User entered Organization Registration number");
			Thread.sleep(1000);
			pr.getOrgPin(regtype);
			logger.info("User entered Organization Pin type");
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2000)");
			Thread.sleep(1000);
			pr.gotoNext();
			Thread.sleep(1000);
			
			
			pr.getServiceType();
			String type[]=stype.split(",");
			for(String opt: type){
			Thread.sleep(1000);
			pr.selectService(opt);
			Thread.sleep(1000);
			}
			logger.info("User selected Service type");
			pr.getServiceExpertise();
			String expert[]=sexpert.split(",");
			for(String opt1:expert){
				Thread.sleep(1000);
				pr.selectService(opt1);
				Thread.sleep(1000);
			}
			logger.info("User selected Service Expertise");
			pr.select();
			Thread.sleep(1000);
			
			switch (pr.getStatus()){
			
				case "0":
					actions.moveToElement(pr.Next()).click().perform();
					Thread.sleep(1000);
					logger.info("User is on next page");
					
					pr.getIndividual();
					Thread.sleep(2000);
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
					pr.getIndividual();
					Thread.sleep(1000);
					pr.getBusiness();
					Thread.sleep(2000);
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
					pr.getBusiness();
					Thread.sleep(1000);
					pr.gotoHome();
					logger.info("User is on home page");
					sheet.getRow(j).createCell(19).setCellValue("Success");
					break;
				
			case "-1":
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
