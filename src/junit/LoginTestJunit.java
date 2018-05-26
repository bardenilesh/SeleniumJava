package junit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestJunit {
	WebDriver driver;
	String workDir= System.getProperty("user.dir");
	WebDriverWait wait;

	
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", workDir+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
				
				//navigating to the specific url
				driver.get("http://automationpractice.com");
				
				//initialize wait instance
				wait = new WebDriverWait(driver, 10);
				
				//waiting for page to load
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//maximize the browser
				driver.manage().window().maximize();
				
				//clicking on Sign In link
				WebElement link_SignIn= driver.findElement(By.linkText("Sign in"));
				link_SignIn.click();
				
				//Waiting for 2 seconds
				Thread.sleep(2000);
				
				//enter username
				WebElement txtBox_Username = driver.findElement(By.id("email"));
				txtBox_Username.sendKeys("bardenilesh@gmail.com");
				
				//enter password
				WebElement txtBox_Password = driver.findElement(By.id("passwd"));
				txtBox_Password.sendKeys("test123");
				
				//clicking on Sign In button
				WebElement btn_SignIn = driver.findElement(By.id("SubmitLogin"));
				btn_SignIn.click();
				
				//waiting for login to be done successfully
				WebElement post_Login = driver.findElement(By.linkText("Sign out"));
				wait.until(ExpectedConditions.visibilityOf(post_Login));
				
				Thread.sleep(3000);
	}

}
