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
import org.testng.annotations.Test;


public class AutomationDemo {
	public WebDriver driver;
	@BeforeSuite
	public void openbrowser()
	{
		System.out.println("Under Before Suit");
		System.setProperty("webdriver.chrome.driver", "F:\\Testing\\Class\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("SuccessFully Open Browser");
	}
	@BeforeTest
	public void entreurl()
	{
		driver.get("http://demo.automationtesting.in/Register.html");
	}
	@BeforeClass
	public void maximizewindows()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		Set<Cookie> cookies=driver.manage().getCookies();
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName());
		}
	}
	@Test
	public void loginuser()
	{
		driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[1]/input")).sendKeys("Rukesh");
		driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[2]/input")).sendKeys("Ingole");
		driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea")).sendKeys("Dhamangaon Railway");
		driver.findElement(By.xpath("//*[@id='eid']/input")).sendKeys("rukeshingole789@gmail.com");
		driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[4]/div/input")).sendKeys("9960130505");
		driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[5]/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id='checkbox1']")).click();
//		Select selectlang=new Select(driver.findElement(By.xpath("//*[@id='msdd']")));
//		selectlang.selectByValue("Hindi");
		Select selectskill=new Select(driver.findElement(By.xpath("//*[@id='Skills']")));
		selectskill.selectByVisibleText("C++");
		Select selectcoun=new Select(driver.findElement(By.xpath("//*[@id='countries']")));
		selectcoun.selectByVisibleText("India");
//		Select selectcount=new Select(driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[10]/div/span/span[1]/span")));
//		selectcount.selectByVisibleText("India");
		Select year=new Select(driver.findElement(By.xpath("//*[@id='yearbox']")));
		year.selectByValue("1993");;
		Select month=new Select(driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[11]/div[2]/select")));
		month.selectByVisibleText("June");
		Select day=new Select(driver.findElement(By.xpath("//*[@id='daybox']")));
		day.selectByValue("28");
		driver.findElement(By.xpath("//*[@id='firstpassword']")).sendKeys("Mayur8600");
		driver.findElement(By.xpath("//*[@id='secondpassword']")).sendKeys("Mayur8600");
		driver.findElement(By.xpath("//*[@id='submitbtn']")).click();
		}
	@AfterMethod
	public void Screenshot() throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("F:\\Testing\\Class\\ScreenShot\\"));
		System.out.println("SuccessFully ScreenShot");
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
//	  @AfterSuite
//	  public void closebrowser()
//	  {
//		  System.out.println("After Suite");
//		  driver.close();
//	  }
	

}
