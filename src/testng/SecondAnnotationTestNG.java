package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SecondAnnotationTestNG {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println("Test "+n);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod() inside SecondAnnotationTestNG");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod() inside SecondAnnotationTestNG");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass() inside SecondAnnotationTestNG");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass() inside SecondAnnotationTestNG");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest() inside SecondAnnotationTestNG");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest() inside SecondAnnotationTestNG");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite() inside SecondAnnotationTestNG");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite() inside SecondAnnotationTestNG");
  }

}
