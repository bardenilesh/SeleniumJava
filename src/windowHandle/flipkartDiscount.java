package windowHandle;

import org.testng.annotations.Test;

import framework.util.ExcelUtility;
import framework.util.Global;
import framework.util.SeleniumUtilities;

import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class flipkartDiscount extends SeleniumUtilities{
	WebDriver driver;
	ExcelUtility oExcel = new ExcelUtility();
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
      driver = new ChromeDriver();
      Global.drv=driver;
      driver.get("https://www.flipkart.com");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
//	  driver.quit();
  }
  @Test
  public void checkDisc() {
	  driver.findElement(By.xpath("//button[text()='✕']")).click();
	  driver.findElement(By.name("q")).sendKeys("redmi note 5");
	  wait(2000);
	  driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.className("_3ZgIXy")).click();
	  driver.findElement(By.xpath("//div[text()='Redmi Note 5 (Black, 32 GB)']")).click();
	  String parentWin = driver.getWindowHandle();
	  for (String handle : driver.getWindowHandles()) {
		driver.switchTo().window(handle);
	  }
	  List <WebElement> discText = driver.findElements(By.xpath("//span[@class='_7g_MLT row']/li/span"));
	  for(int i=0;i<discText.size();i++){
		  if(!(discText.get(i).getText().equals("")))
		  System.out.println(discText.get(i).getText());
	  }
	  driver.close();
	  wait(2000);
	  //use driver.switchTo().defaultContent(); to switch to the previous page
  }
}
