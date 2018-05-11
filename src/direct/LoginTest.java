package direct;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.internal.runners.model.EachTestNotifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	static WebDriver driver;
	static String workDir= System.getProperty("user.dir");
	static WebDriverWait wait;
	public static void main(String[] args) throws InterruptedException {
		//setting up the path of the chrome driver
		System.setProperty("webdriver.chrome.driver", workDir+"\\drivers\\chromedriver.exe");
		
		//opening the chromedriver
		driver = new ChromeDriver();
		
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
		
		WebElement link_Women = driver.findElement(By.linkText("Women"));
		link_Women.click();
		
		WebElement link_Tops = driver.findElement(By.linkText("Tops"));
		link_Tops.click();
		
		WebElement chkBox_SizeSmall = driver.findElement(By.xpath("//div[@class='layered_filter'][2]//li[1]//input"));
		chkBox_SizeSmall.click();
		
		WebElement drop_ProductSort = driver.findElement(By.id("selectProductSort"));
		new Select(drop_ProductSort).selectByVisibleText("Product Name: A to Z");
		
		WebElement img_Container = driver.findElement(By.xpath("//a[(@class='product-name') and contains (text(),'Blouse')]/ancestor::li"));
		Actions action = new Actions(driver);
		action.moveToElement(img_Container).build().perform();
		
		WebElement btn_AddToCard = img_Container.findElement(By.linkText("Add to cart"));
		btn_AddToCard.click();
		Thread.sleep(3000);
		
		WebElement btn_ContinueShopping = driver.findElement(By.xpath("//span[@title='Continue shopping']"));
		btn_ContinueShopping.click();
		
		img_Container = driver.findElement(By.xpath("//a[(@class='product-name') and contains (text(),'Faded Short Sleeve T-shirts')]/ancestor::li"));
		action.moveToElement(img_Container).build().perform();
		
		btn_AddToCard = img_Container.findElement(By.linkText("Add to cart"));
		btn_AddToCard.click();
		Thread.sleep(3000);
		
		btn_ContinueShopping = driver.findElement(By.xpath("//span[@title='Continue shopping']"));
		btn_ContinueShopping.click();
		
		Thread.sleep(3000);
		
		WebElement link_Cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		action.moveToElement(link_Cart).build().perform();
		
		WebElement cart_Container = driver.findElement(By.xpath("//div[@class='cart_block_list']"));
		List <WebElement> items = cart_Container.findElements(By.className("cart_block_product_name"));
		System.out.println(items.size());
		for(WebElement e: items){
			System.out.println(e.getAttribute("title"));
		}
		
		Thread.sleep(5000);
		//closing driver instance
		
		
		driver.quit();
	}

}
