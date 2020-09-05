package com.yoloj.PageObjects;

import org.openqa.selenium.Keys;
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
	WebElement NextLink;  
	                      
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
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/button[2]")
	WebElement nextStatuslink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div/div/button[1]")
	WebElement ServiceTypelink;
	
	@FindBy(xpath = "//*[@id=\"checkboxes-tags-demo\"]")
	WebElement selectServiceTypelink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div/div/button[2]")
	WebElement ServiceExpertiselink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]")
	WebElement individualLink;
	
	@FindBy(className = "rct-icon")
	WebElement firstIndLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/ol/li/ol/li[1]/span/button/span")
	WebElement secondIndLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/ol/li/ol/li[2]/span/button/span")
	WebElement thirdIndLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/ol/li/ol/li[3]/span/button/span")
	WebElement fourthIndLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/ol/li/ol/li[4]/span/button/span")
	WebElement fifthIndLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/div[4]/div/div/div[1]/div[1]")
	WebElement businessLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div/ol/li/span/button/span")
	WebElement firstBusLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div/ol/li/ol/li[1]/span/button/span")
	WebElement secondBusLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div/ol/li/ol/li[2]/span/button/span")
	WebElement thirdBusLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div/ol/li/ol/li[3]/span/button/span")
	WebElement fourthBusLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div/ol/li/ol/li[4]/span/button/span")
	WebElement fifthBusLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div/ol/li/ol/li[5]/span/button/span")
	WebElement sixthBusLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div/ol/li/ol/li[6]/span/button/span")
	WebElement seventhBusLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div/ol/li/ol/li[7]/span/button/span")
	WebElement eigthBusLink;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[2]/div/div/div/div[4]/div/div/div[2]/div/div/div/div/div/div/div/ol/li/ol/li[8]/span/button/span")
	WebElement ninthBusLink;
	
	
  
	
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
	
	public String getStatus(){
		return nextStatuslink.getAttribute("tabindex");
	}
	
	public void getServiceType(){
		ServiceTypelink.click();
	}
	
	public void getServiceExpertise(){
		ServiceExpertiselink.click();
	}
	
	public void selectService(String option){
		selectServiceTypelink.sendKeys(option+Keys.ARROW_DOWN+Keys.ENTER);
	}
	
	public void select(){
		selectServiceTypelink.click();
	}
	
	public void getIndividual(){
		individualLink.click();
	}
	
	public void getFirstInd() {
		firstIndLink.click();
	}
	
	public void getSecondInd() {
		secondIndLink.click();
	}
	
	public void getThirdInd() {
		thirdIndLink.click();
	}
	
	public void getFourthInd() {
		fourthIndLink.click();
	}
	
	public void getFifthInd() {
		fifthIndLink.click();
	}
	
	public void getBusiness() {
		businessLink.click();
	}
	
	public void getFirstBusiness() {
		firstBusLink.click();
	}
	
	public void getSecondBusiness() {
		secondBusLink.click();
	}
	
	public void getThirdBusiness() {
		thirdBusLink.click();
	}
	
	public void getFourthBusiness() {
		fourthBusLink.click();
	}
	
	public void getFifthBusiness() {
		fifthBusLink.click();
	}
	
	public void getSixthBusiness() {
		sixthBusLink.click();
	}
	
	public void getSeventhBusiness() {
		seventhBusLink.click();
	}
	
	public void getEigthBusiness() {
		eigthBusLink.click();
	}
	
	public void getNinthtBusiness() {
		ninthBusLink.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
