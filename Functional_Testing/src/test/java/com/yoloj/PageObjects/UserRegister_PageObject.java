package com.yoloj.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegister_PageObject {
	
	WebDriver ldriver;
	
	public UserRegister_PageObject(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[1]/header/div/div[2]/ul/li[3]/button/span[1]" )
	WebElement RegLink;
	
	@FindBy(id = "name")
	WebElement txtName;
	
	@FindBy(id = "email")
	WebElement txtEmail;
	
	@FindBy(id = "password")
	WebElement txtPass;
	
	@FindBy(id = "confirm_password")
	WebElement txtConfirmPass;
	
	@FindBy(id = "demo-simple-select")
	WebElement CodeLink;
	
	@FindBy(id = "phone_number")
	WebElement txtPhone;
	
	@FindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiButton-root')][@type='submit']")
	WebElement Createbtn;               //*[@id="root"]/div/div/div/div[2]/div/div/div/div[2]/form/button/span[1]
	                                    //*[@id="root"]/div/div/div/div[2]/div/div/div/div[2]/form/button/span[1]
	@FindBy(linkText = "Link")
	WebElement Loginbtn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/header/div/img")  
	WebElement HomePageLink;                                                  
	
//	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]")         
//	WebElement Errormsg;
	//
	@FindBy(className = "MuiSnackbarContent-message")    //*[@id="root"]/div/div/div/div[3]/div/div[1]
	WebElement Errormsg;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[3]/div/div[1]")
	WebElement ExistErrormsg;
	
	@FindBy(id = "name-helper-text")
	WebElement NameError;
	
	@FindBy(id = "email-helper-text")
	WebElement EmailError;
	
	@FindBy(id = "password-helper-text")
	WebElement PasswordError;
	
	@FindBy(id = "confirm_password-helper-text")
	WebElement ConfirmPasswordError;
	
	@FindBy(id = "phone_number-helper-text")
	WebElement PhoneError;
	
	
	public void ClickRegisterbtn(){
		RegLink.click();
	}
	
	public void setName(String name){
		txtName.sendKeys(name);
	}
	
	public WebElement name() {
		return txtName;
	}
	public void setEmail(String mail){
		txtEmail.sendKeys(mail);
	}
	
	public WebElement mail() {
		return txtEmail;
	}
	
	public void setPassword(String password){
		txtPass.sendKeys(password);
	}
	
	public WebElement password() {
		return txtPass;
	}
	public void setConfirmPassword(String confirmpass){
		txtConfirmPass.sendKeys(confirmpass);
	}
	
	public WebElement ConfirmPassword() {
		return txtConfirmPass;
	}
	
	public void setPhone(String phone){
		txtPhone.sendKeys(phone);
	}
	
	public WebElement phone() {
		return txtPhone;
	}
	
	public void createAccount(){
		Createbtn.click();
	}
	
	public WebElement crtbutton(){
		return Createbtn;
	}
	
	public WebElement homeLink(){
		return HomePageLink;
	}
	public void gotoHome(){
		HomePageLink.click();
	}
	
	public void gotoLogin(){
		Loginbtn.click();
	}
	
	public String getErrormsg(){
		String msg = Errormsg.getText();
		return msg;
		
	}
	
	public String getExistmsg(){
		String msg = ExistErrormsg.getText();
		return msg;
	}
	
	public String getNameError(){
		
		String msg = NameError.getText();
		return msg;
	}
	
	public String getEmailError(){
		String msg = EmailError.getText();
		return msg;
	}
	
	public String getPasswordError(){
		String msg = PasswordError.getText();
		return msg;
	}
	
	public String getConfirmPassError(){
		String msg = ConfirmPasswordError.getText();
		
		return msg;
	}
	
	public String getPhoneError(){
		String msg = PhoneError.getText();
		return msg;
	}

}
