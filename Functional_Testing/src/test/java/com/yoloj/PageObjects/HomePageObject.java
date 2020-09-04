package com.yoloj.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
WebDriver ldriver;
	
	public HomePageObject(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//*[@id=\"country\"]")
	WebElement countryDropDown;
	
	@FindBy(id="city")
	WebElement cityDropDown;
	
	@FindBy(id="searchBy")
	WebElement searchByDropDown;
	
	@FindBy(id="SearchByField")
	WebElement typeToSearch;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]/div/div/div/div/div/div[5]/div/button")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[2]/div/div/div/div/div/div[6]/div/a")
	WebElement clearFields;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div[1]/header/div/div[2]/ul/li[2]/button/span[1]/b")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/ul/li[3]/button/span[1]")
	WebElement RegisterButton;
	
	@FindBy(xpath="//*[@id=\"menu-list\"]/ul/li[1]/a")
	WebElement providerRegisterButton;
	
	@FindBy(xpath="//*[@id=\"menu-list\"]/ul/li[2]/a")
	WebElement providerLoginButton;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/ul/li[1]/div/div/button")
	WebElement providerDropDown;
	
	public void Country(String country) {
		countryDropDown.sendKeys(country);
	}
	
	public void City(String city) {
		cityDropDown.sendKeys(city);
	}
	
	public void SearchBy(String searchby) {
		searchByDropDown.sendKeys(searchby);
	}
	
	public void TypeToSearh(String typevalue) {
		typeToSearch.sendKeys(typevalue);
	}
	
	public void ClickSearchButton() {
		searchButton.click();
	}
	
	public void ResetField() {
		clearFields.click();
	}
	
	public void ClickUserLogin() {
		loginButton.click();
	}
	
	public void ClickUserRegister() {
		RegisterButton.click();
	}
	
	public void ProviderDrop() {
		providerDropDown.click();
	}
	
	public void ProviderLogin() {
		providerLoginButton.click();
	}
	
	public void ProviderRegister() {
		providerRegisterButton.click();
	}
}
