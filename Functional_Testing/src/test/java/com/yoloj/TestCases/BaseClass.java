package com.yoloj.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.yoloj.PageObjects.ProviderRegister_PageObject;
import com.yoloj.PageObjects.UserRegister_PageObject;
import com.yoloj.utilities.ReadConfig;

public class BaseClass {
	
ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public String userRegisterPath =readconfig.getUserRegisterData();
	public String providerData = readconfig.getProviderData();
	public String fname = readconfig.getFirst_Name();
	public String lname = readconfig.getLast_Name();
	public String mail = readconfig.getEmail();
	public String pass = readconfig.getPass();
	public String ConPass = readconfig.getConPass();
	public String code = readconfig.getCountryCode();
	public String phone = readconfig.getPhoneNumber();
	public String orgName = readconfig.getOrgName();
	public String orgAddress = readconfig.getOrgAdd();
	public String fee = readconfig.getFee();
	public String pinCode = readconfig.getPinCode();
	public String country = readconfig.getCountry();
	public String city = readconfig.getCity();
	public String address1 = readconfig.getAddress1();
	public String address2 = readconfig.getAddress2();
	public String regNum = readconfig.getRegNum();
	public String pinType = readconfig.getRegPin();
	public String image = readconfig.getImage();
	public static WebDriver driver;
	public UserRegister_PageObject up;
	public ProviderRegister_PageObject pr;
	
	public static Logger logger;
	
	public String[] individualOptions={"Individual","Tax returns","TDS","Legal","Miscelleneous Services"};
	public String[] taxOptions={"salaried Individuals","Capital Gains","Tax notice management plan","LTCG filling and advisory"};		
	public String[] tdsOptions = {"Challan 26QB"};
	public String[] legalOptions = {"Document Review","Legal Drafting","Filling of Form DPT-3"};
	public String[] IndMisc = {"Advisory tax saving","Ask an expert"};
	
	public String[] businessOptions = {"Business Incorporation","GST Service","Startup Services","Legal Complaince Service","Tax Returns","Goverment Registration","Trademark","Miscelleneous Services"};
	public String[] busIncOptions = {"Private Limited Company","One person company","Limited Liability Partnership","PLC registration","NGO section and company registration"};
	public String[] gstOptions = {"GST registration","GST filing","Ask an expert","E-way bill service","GST notice-Ask an expert"};
	public String[] startupOptions = {"Payroll Service","Launch Your Startup","Start up India Registration","Winding up of company","Company and LLP returns"};
	public String[] legalCompOptions = {"Change company name","Change registered office"};
	public String[] taxOption = {"TDS returns","Business Tax returns"};
	public String[] govrOptions = {"Provident Fund","PAN registration"};
	public String[] tradeOptions = {"Trademark registration","Trademark renewal","Trademark registration in India"};
	public String[] BusinessMisc = {"List Your Business on government website","LEI Code","15CA Form Filing","Getting FDI in India"};
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{			
		logger = Logger.getLogger("yoloj");
		PropertyConfigurator.configure("Log4j.properties");
		
		

		
//		System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
//		driver=new EdgeDriver();
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public FileInputStream setFileInput(String path) {
		FileInputStream fis=null;
		try {
			File file = new File(path);
			fis=new FileInputStream(file);
			return fis;
		}
		catch(Exception e) {
			System.out.println("Error Message"+e.getMessage());
		}
		return fis;
	}
	
	public FileOutputStream setFileOutput(String path) {
		FileOutputStream fos=null;
		try {
			File file = new File(path);
			fos=new FileOutputStream(file);
			return fos;
		}
		catch(Exception e) {
			System.out.println("Error Message"+e.getMessage());
		}
		return fos;
	}
	
	

}
