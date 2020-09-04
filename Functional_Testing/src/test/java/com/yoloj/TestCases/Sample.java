package com.yoloj.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.ProviderRegister_PageObject;

public class Sample extends BaseClass{
	
	@Test
	public void test() throws InterruptedException{
		
		driver.get(baseURL);
		Actions act = new Actions(driver);
		pr = new ProviderRegister_PageObject(driver);
		pr.getProvider();
		pr.getReg();
		
		pr.gotoNext();
		
		act.moveToElement(pr.Next()).click().perform();
		
		pr.gotoNext();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]")).click();
		Thread.sleep(1000);         
		
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"rct-JFN18q4\"]/ol/li/ol"));
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++){
				
				System.out.println(list.get(i).getText());
				
		}
		
//		String type[]={"Mutual Funds","Insurance"};
//		for(String opt: type){
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"checkboxes-tags-demo\"]")).sendKeys(opt+Keys.ARROW_DOWN+Keys.ENTER);
//		Thread.sleep(1000);
//		}
		
//		pr.gotoNext();
//		
//		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]")).click();
//		Thread.sleep(1000);
		
		 //list = driver.findElement(By.xpath("//*[@id=\"rct-JFN18q4\"]/ol/li/ol"));
		
		
		
		
//		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div/div/button[1]/span[1]")).click();
//		String type[]={"Mutual Funds","Insurance"};
//		
//		for(String opt: type){
//		
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div/div")).click();
//		
//		
//		//driver.findElement(By.id("checkboxes-tags-demo")).sendKeys(opt);
//		Thread.sleep(1000);
//		 String msg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div/div")).getText();
//		System.out.println(msg);
		
		
		
	}

}
