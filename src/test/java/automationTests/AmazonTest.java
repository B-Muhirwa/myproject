package automationTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonTest {

	public static WebDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebDriverWait wait;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\muhir\\OneDrive\\Desktop\\Selenium\\qa2023\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://codefios.com/ebilling/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
	}
	
	private void login(String username, String pwd)  {
		
		driver.findElement(By.cssSelector("input#user_name")).sendKeys(username);
		driver.findElement(By.cssSelector("input#password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("button#login_submit")).click();;

	}
	@Test
	public void test() throws InterruptedException {
		login("demo@codefios.com", "abc123");
		
		driver.findElement(By.cssSelector("a[title='List Accounts']")).click();
		driver.findElement(By.cssSelector("button[type='button'][data-toggle='modal']")).click();
		driver.findElement(By.cssSelector("input[type='text'][class='form-control account_name ']")).sendKeys("TechFios");
		driver.findElement(By.cssSelector("textarea#description")).sendKeys("Checking Account");
		driver.findElement(By.cssSelector("input#balance")).sendKeys("5000");
		driver.findElement(By.cssSelector("input[type='text'][class='form-control account_number']")).sendKeys("123232125");
		driver.findElement(By.cssSelector("input#contact_person")).sendKeys("Ramaphosa");
		driver.findElement(By.cssSelector("button#accountSave")).click();
		Thread.sleep(4000);
		
	} 
	@Test
	public void test1() throws InterruptedException {
		
	
		login("demo@codefios.com", "abc123");
		driver.findElement(By.cssSelector("a[title='Company']")).click();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@type= 'button'][@data-toggle='modal']")))).click();
		driver.findElement(By.id("company_name")).sendKeys("AB Technology");
		driver.findElement(By.id("company_url")).sendKeys("www.abtechnology.com");
		driver.findElement(By.id("company_email")).sendKeys("admin@abtechnology.com");
		driver.findElement(By.id("company_phone")).sendKeys("4563258987");
		driver.findElement(By.id("logo_url")).sendKeys("ABTECH");
		driver.findElement(By.id("companyformsubmit")).click();
		Thread.sleep(2000);
		
		
	}
	@After
	public void tearDown() {
		driver.close();
		
	}

}
