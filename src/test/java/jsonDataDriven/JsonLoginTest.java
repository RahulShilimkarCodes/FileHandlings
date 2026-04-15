package jsonDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsonLoginTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void browserSetup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test(dataProviderClass=JsonDataProvider.class,dataProvider="jsonDataProvider")
	public void loginTest(String userName, String password) throws InterruptedException
	{
		
	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	
	driver.findElement(By.id("username")).sendKeys(userName);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("terms")).click();
	
	driver.findElement(By.id("signInBtn")).click();
		
	Thread.sleep(2000);
	}
	
	
	@Test(dataProviderClass=JsonDataProvider.class,dataProvider="jsonIterDataProvider")
	public void loginTestIterator(UserPojo user) throws InterruptedException
	{
		
	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	
	driver.findElement(By.id("username")).sendKeys(user.getUserName());
	driver.findElement(By.id("password")).sendKeys(user.getPassword());
	driver.findElement(By.id("terms")).click();
	
	driver.findElement(By.id("signInBtn")).click();
		
	Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
