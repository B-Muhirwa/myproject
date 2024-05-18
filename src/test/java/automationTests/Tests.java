package automationTests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Tests {
	
	static WebDriver driver;
	
		@Before
		public  void setup() {
			
			System.setProperty("webdriver.edge.driver", "C:\\Users\\muhir\\OneDrive\\Desktop\\Selenium\\qa2023\\Driver\\msedgedriver.exe");
			driver= new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://codefios.com/ebilling/");
			driver.manage().deleteAllCookies();
			
		}
		@Test
		public void Login() throws InterruptedException {
			
			//login with username and password and click and submit button
			
			driver.findElement(By.id("user_name")).sendKeys("demo@codefios.com");
			driver.findElement(By.id("password")).sendKeys("abc123");
			driver.findElement(By.id("login_submit")).click();
			
			//clicking on List Accounts using xpath as a locator
			driver.findElement(By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[3]/a/span")).click();
			
			// clicking on Add Account button using xpath as a locator
			driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div[1]/div/div[2]/header/button")).click();
			
			// the New Account form elements were unreachable therefore i used throws InterruptedException
			
			Thread.sleep(4500);
			
			//filling the form for New Account using id as a locator
			driver.findElement(By.id("account_name")).sendKeys("TechFios Batch Dec2023");
			driver.findElement(By.id("description")).sendKeys("Saving Account");
			driver.findElement(By.id("balance")).sendKeys("200000");
			driver.findElement(By.id("account_number")).sendKeys("1122334455");
			driver.findElement(By.id("contact_person")).sendKeys("Admin");
			
			//Saving the new created account 
			driver.findElement(By.id("accountSave")).click();
		
			
		}
		@After
		public void tearDown() {
			driver.close();
			driver.quit();
		
		
	
		
	
		
	}	  
		

	}
