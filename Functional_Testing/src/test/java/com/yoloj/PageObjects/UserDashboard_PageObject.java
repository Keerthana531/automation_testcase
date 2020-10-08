package com.yoloj.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboard_PageObject {
	
	WebDriver ldriver;
	
	public UserDashboard_PageObject(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/header/div/div[2]/ul/li[2]/button[1]")
	WebElement loginLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/header/div/div[2]/ul/li[2]/button[1]")
	WebElement welcomeLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/form/div[1]/div[2]/div[2]/button")
	WebElement nameEdit;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/form/div[2]/div[2]/div[2]/button")
	WebElement mailEdit;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/form/div[3]/div[2]/div[2]/button")
	WebElement phoneEdit;
	
	@FindBy(id = "formGroupName")
	WebElement nameBox;
	
	@FindBy(id = "formGroupEmail")
	WebElement mailBox;
	
	@FindBy(name = "phone_number")
	WebElement numberBox;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/form/button")
	WebElement updateBtn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/div[2]/div/div[1]")
	WebElement txtLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[1]/header/div/button[1]")
	WebElement menuLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/ul/div[2]")
	WebElement signOutLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[1]/header/div/button[2]")
	WebElement backLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/header/div/div[2]/ul/li[3]/button")
	WebElement logoutLink;
	
	public void clickLogin() {
		loginLink.click();
	}
	public void clickWelcome() {
		welcomeLink.click();
	}
	
	public String getWelcomeText() {
		return welcomeLink.getText();
	}
	public void getNameEdit() {
		nameEdit.click();
	}
	
	public void getMailEdit() {
		mailEdit.click();
	}
	
	public void getPhoneEdit() {
		phoneEdit.click();
	}
	
	public void clearName() {
		nameBox.clear();
	}
	
	public void setName(String name) {
		nameBox.sendKeys(name);
	}
	
	public void clearMail() {
		mailBox.clear();
	}
	
	public void setEmail(String mail) {
		mailBox.sendKeys(mail);
	}
	
	public void selectPhone() {
		numberBox.click();
	}
	public void clearPhone() {
		numberBox.clear();
	}
	
	public void setPhone(String phone) {
		numberBox.sendKeys(phone);
	}
	
	public String getStatus(){
		return updateBtn.getAttribute("tabindex");
	}
	
	public void selectUpdate() {
		updateBtn.click();
	}
	
	public String getMessage(){
		return txtLink.getText();
	}
	
	public void getMenu() {
		menuLink.click();
	}
	
	public void clickSignOut() {
		signOutLink.click();
	}
	
	public void gotoBack() {
		backLink.click();
	}
	
	public void clickLogout() {
		logoutLink.click();
	}

}
