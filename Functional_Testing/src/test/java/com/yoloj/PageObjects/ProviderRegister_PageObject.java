package com.yoloj.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProviderRegister_PageObject {
	
	WebDriver ldriver;
	
	public ProviderRegister_PageObject(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/header/div/img")  
	WebElement HomePageLink;   
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/header/div/div[2]/ul/li[1]/div/div/button/span[1]")   
	WebElement providerLink;  
	
	@FindBy(linkText = "Provider Register")
	WebElement regLink;
	
	@FindBy(id = "firstName")
	WebElement fnameLink;
	
	@FindBy(id = "lastName")
	WebElement lnameLink;
	
	@FindBy(id = "email")
	WebElement mailLink;
	
	@FindBy(id = "password")
	WebElement passLink;
	
	@FindBy(id = "confirmPassword")
	WebElement confirmPassLink;
	
	@FindBy(id = "demo-simple-sßelect")
	WebElement codeLink;
	
	@FindBy(id = "phone_number")
	WebElement phoneLink;
	
	@FindBy(xpath = "//*[@id='root']/div/div/div/div[2]/div[2]/div/div/div/button[2]/span[1]")
	WebElement NextLink;  //*[@id="root"]/div/div/div/div[2]/div[2]/div/div/div/button[2]/span[1]
	                      
	@FindBy(id = "OrgName")
	WebElement orgNameLink;
	
	@FindBy(id = "OrgAddress")
	WebElement orgAddressLink;
	
	@FindBy(id = "Fees")
	WebElement feeLink;
	
	@FindBy(id = "PinCode")
	WebElement pinLink;
	
	@FindBy(id = "countriesLabel")
	WebElement countryLink;
	
	@FindBy(id = "citiesLabel")
	WebElement cityLink;
	
	@FindBy(id = "ALine1")
	WebElement add1Link;
	
	@FindBy(id = "ALine2")
	WebElement add2Link;
	
	@FindBy(id = "OrgRegNumber")
	WebElement OrgRegNumberLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/div/form/div[15]/div/div/div/input")
	WebElement OrgPINTypeLink;
	
//	@FindBy(xpath = "//*[@id='root']/div/div/div/div[2]/div[2]/div/div/div/button[1]/span[1]")
//	WebElement orgpinLink;    
	
	public void getProvider(){
		providerLink.click();
	}
	
	public void getReg(){
		regLink.click();
	}
	
	public WebElement Next(){
		return NextLink;
	}
	
	public WebElement phone(){
		return phoneLink;
	}
	
	public WebElement code(){
		return codeLink;
	}
	
	public void gotoHome(){
		HomePageLink.click();
	}
	
	public void getFname(String uname){
		fnameLink.sendKeys(uname);
	}
	
	public void getLname(String lname){
		lnameLink.sendKeys(lname);
	}
	
	public void getEmail(String email){
		mailLink.sendKeys(email);
	}
	
	public void getPassword(String pass){
		passLink.sendKeys(pass);
	}
	
	public void getCPass(String cpass){
		confirmPassLink.sendKeys(cpass);
	}
	
	public WebElement getCode(){
		return codeLink;
	}
	
	public void getPhone(String phone){
		phoneLink.sendKeys(phone);
	}
	public void gotoNext(){
		NextLink.click();
	}
	
	public void getOrgName(String orgname){
		orgNameLink.sendKeys(orgname);
	}
	
	public void getOrgAddress(String orgaddress){
		orgAddressLink.sendKeys(orgaddress);
	}
	
	public void getFee(String fee){
		feeLink.sendKeys(fee);
	}
	
	public void getPinCode(String pincode){
		pinLink.sendKeys(pincode);
	}
	
	public WebElement getCountry(){
		return countryLink;
	}
	
	public WebElement getCity(){
		return cityLink;
	}
	
	public void getAddress1(String add1){
		add1Link.sendKeys(add1);
	}
	
	public WebElement regtype(){
		return OrgPINTypeLink;
	}
	
	public void getAddress2(String add2){
		add2Link.sendKeys(add2);
	}
	
	public void getOrgNumber(String orgnum){
		OrgRegNumberLink.sendKeys(orgnum);
	}
	
	public void getOrgPin(String orgpin){
		OrgPINTypeLink.sendKeys(orgpin);
	}
	
	

}
