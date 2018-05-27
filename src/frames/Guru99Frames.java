package frames;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Guru99Frames {
	WebDriver driver;
	String WorkDir= System.getProperty("user.dir");
  @Test
  public void f() throws InterruptedException {
	  driver.get("http://total-qa.com/selenium/demo-sites/");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  List <WebElement> frame = driver.findElements(By.tagName("iframe"));
	  System.out.println("Total Frames available are "+frame.size());
	  driver.switchTo().frame("twitter-widget-0");
//	  driver.switchTo().frame();
	  driver.findElement(By.id("b")).click();
//	  driver.findElement(By.xpath("(//button[@aria-label='Play'])[1]")).click();
	  Thread.sleep(2000);
//	  for (String handle : driver.getWindowHandles()) {
//			driver.switchTo().window(handle);
//		  }
//	  driver.close();
	  driver.switchTo().defaultContent();
	  driver.findElement(By.linkText("Complete List of Selenium Basics")).click();
	  Thread.sleep(3000);
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", WorkDir+"\\drivers\\chromedriver.exe");
      driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
