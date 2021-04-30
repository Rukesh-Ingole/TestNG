package com.testNG;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MercuryTest {
	public WebDriver driver;
	@BeforeSuite
	public void OpenBrowser()
	{
		System.out.println("Under Before Suit");
		System.setProperty("webdriver.chrome.driver", "F:\\Testing\\Class\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("SuccessFully Open Browser");
	}
	
	@BeforeTest
	public void EnteUrl()
	{
		System.out.println("Before Test");
		driver.get("http://demo.guru99.com/test/newtours/register.php");
	}
	@BeforeClass
	public void maximizewindow()
	{
		System.out.println("Before Class");
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		System.out.println("Before Method");
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) 
		{
		System.out.println(cookie.getName());	
		}
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
	}
  @Test(dataProvider = "getdata")
  public void loginwithvaliduser(String un, String us, String mo, String mail, String ad1, String ad2, String ct, String st, String pc, String coun, String id, String ps, String cs) throws IOException, InterruptedException 
  {
	  System.out.println("Login with valid user test annotation");
	  driver.findElement(By.name("firstName")).sendKeys(un);
		
		driver.findElement(By.name("lastName")).sendKeys(us);
		
		driver.findElement(By.name("phone")).sendKeys(mo);
		
		driver.findElement(By.id("userName")).sendKeys(mail);
		
		driver.findElement(By.name("address1")).sendKeys(ad1);
		
		driver.findElement(By.name("address2")).sendKeys(ad2);
		
		driver.findElement(By.name("city")).sendKeys(ct);
		
		driver.findElement(By.name("state")).sendKeys(st);
		
		driver.findElement(By.name("postalCode")).sendKeys(pc);
		
		Select selectcountry=new Select(driver.findElement(By.name("country")));
		selectcountry.selectByVisibleText(coun);
		
		driver.findElement(By.id("email")).sendKeys(id);
		
		driver.findElement(By.name("password")).sendKeys(ps);
		
		driver.findElement(By.name("confirmPassword")).sendKeys(cs);
		
		driver.findElement(By.name("register")).click();
		System.out.println("Successful Login");
  }
  @AfterMethod
  public void CaptureScreen() throws IOException
  {
	  System.out.println("Under After Method");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 
	  FileUtils.copyFileToDirectory(src, new File("F:\\Testing\\Class\\ScreenShot\\"));
	  
	  System.out.println("successfuly ScreenShot");
	   }
  @AfterClass
  public void DeleteCookies()
  {
	  System.out.println("After Class");
	  driver.manage().deleteAllCookies();
  }
  @AfterTest
  public void dbconnection()
  {
	  System.out.println("After Test");
  }
  @AfterSuite
  public void closebrowser()
  {
	  System.out.println("After Suite");
	  driver.close();
  }
//  @DataProvider 
//	public Object[][] getdata() 
//	{ 
//		return new Object[][] 
//				{
//
//			new Object[] 
//					{"Rukesh","Ingole","9960130505","cndsjcnj@gmail.com","Pande Layout, Dhamangaon Railway","District Amravati","Dhamangaon Railway","Maharashtra","444709","INDIA","rukeshingole","9960130505","9960130505"}, 
//					new Object[] 
//							{"Mayur","Ingole","9960130505","jbjsbccjsdbdcjj@gmail.com","Pande Layout, Dhamangaon Railway","District Amravati","Dhamangaon Railway","Maharashtra","444709","INDIA","mayuringole","9960130505","9960130505"}, 
//							
//				}; 

@DataProvider
public Object[][] getdata()
{
	Object[][] data=new Object[2][13];
	data[0][0] = "Rukesh";
	data[0][1] = "Ingole";
	data[0][2] = "cndsjcnj@gmail.com";
	data[0][3] = "9960130505";
	data[0][4] = "Pande Layout, Dhamangaon Railway";
	data[0][5] = "District Amravati";
	data[0][6] = "Dhamangaon Railway";
	data[0][7] = "Maharashtra";
	data[0][8] = "444709";
	data[0][9] = "INDIA";
	data[0][10] = "rukeshingole";
	data[0][11] = "9960130505";
	data[0][12] = "9960130505";

	data[1][0] = "Mayur";
	data[1][1] = "Ingole";
	data[1][2] = "jsjccjsdc@gmail.com";
	data[1][3] = "9960130505";
	data[1][4] = "Pande Layout, Dhamangaon Railway";
	data[1][5] = "District Amravati";
	data[1][6] = "Dhamangaon Railway";
	data[1][7] = "Maharashtra";
	data[1][8] = "444709";
	data[1][9] = "INDIA";
	data[1][10] = "mayuringole";
	data[1][11] = "9960130505";
    data[1][12] = "9960130505";
	return data;


}

}
