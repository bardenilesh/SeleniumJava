package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class TestNGDependsOn {
 
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod()");
    }
 
    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod()\n");
    }
     
    @Test
    public void testAdd() {
        System.out.println("testAdd()");
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(15, 2) , 17);
    }
 
    @Test
    public void testDivide() {
        System.out.println("testDivide()");
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(16, 0), 16);
    }
     
    @Test(dependsOnMethods={"testAdd", "testDivide"})
    public void testProcessRealNumbers() {
        System.out.println("testProcessRealNumbers()");
    }
 
    @Test(dependsOnMethods={"testAdd", "testDivide"}, alwaysRun=true)
    public void testProcessEvenNumbers() {
        System.out.println("testProcessEvenNumbers()");
    }
    
/*    It’s clear from above output that testProcessRealNumbers was skipped as one of the method it depends on (testDivide) failed.

    Method testProcessEvenNumbers, however was still executed, thanks to alwaysRun=true.

    That’s it.*/
 
}