package com.yoloj.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getLoginURL()
	{
		String url=pro.getProperty("loginURL");
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	
	public String getLoginDataExcel()
	{
	String loginData=pro.getProperty("loginData");
	return loginData;
	}

	public String getProviderLoginURL() {
		String providerLoginUrl = pro.getProperty("providerLoginURL");
		return providerLoginUrl;
	}
	
	public String getUserRegisterData(){
		String registerData = pro.getProperty("userRegisterData");
		return registerData;
	}
	
	public String getFirst_Name(){
		return pro.getProperty("First_Name");
	}
	
	public String getLast_Name(){
		return pro.getProperty("Last_Name");
	}
	
	public String getEmail(){
		return pro.getProperty("Email");
	}
	
	public String getPass(){
		return pro.getProperty("Password");
	}
	
	public String getConPass(){
		return pro.getProperty("Confirm_Password");
	}
	
	public String getCountryCode(){
		return pro.getProperty("Country_Code");
	}
	
	public String getPhoneNumber(){
		return pro.getProperty("Phone_Number");
	}
	
	public String getOrgName(){
		return pro.getProperty("Organization_Name");
	}
	
	public String getOrgAdd(){
		return pro.getProperty("Organization_Address");
	}
	
	public String getFee(){
		return pro.getProperty("Fee");
	}
	
	public String getPinCode(){
		return pro.getProperty("Pincode");
	}
	
	public String getCountry(){
		return pro.getProperty("Country");
	}
	
	public String getCity(){
		return pro.getProperty("City");
	}
	public String getAddress1(){
		return pro.getProperty("Address1");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
