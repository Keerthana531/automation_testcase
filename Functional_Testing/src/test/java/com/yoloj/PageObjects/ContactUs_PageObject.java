package com.yoloj.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs_PageObject {
	
WebDriver ldriver;
	
	public ContactUs_PageObject(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/header/div/div[2]/ul/li[2]/button[1]")
	WebElement loginLink;
	
	@FindBy(linkText = "Contact Us")
	WebElement homeContactLink;
	
	////*[@id="root"]/div/div/div/div[1]/header/div/div[2]/ul/li[2]/button[2]
	//*[@id="root"]/div/div/div/div[1]/header/div/div[2]/ul/li[2]/button[2]
	@FindBy(id = "name")
	WebElement nameLink;
	
	@FindBy(id = "email")
	WebElement mailLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[3]/div[1]/div[2]/div/form/textarea")
	WebElement queryLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[3]/div[1]/div[2]/div/form/button")
	WebElement submitLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[5]/div/div[1]")
	WebElement messageLink;
	
	public void clickLogin() {
		loginLink.click();
	}
	
	public void clickContact() {
		homeContactLink.click();
	}
	
	public void setName(String name) {
		nameLink.sendKeys(name);
	}
	
	public void setEmail(String email) {
		mailLink.sendKeys(email);
	}
	
	public void clickSubmit() {
		submitLink.click();
	}
	
	public String getStatus() {
		return submitLink.getAttribute("tabindex");
	}
	
	public String getMessage() {
		return messageLink.getText();
	}

}
