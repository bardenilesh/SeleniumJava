package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test002 {

	@Test
	public void Test1()
	{
		try {
			System.out.println("Test1");
			Assert.assertEquals(false, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void Test2()
	{
		try {
			System.out.println("Test2");
			Assert.assertEquals(false, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test3()
	{
		try {
			System.out.println("Test3");
			Assert.assertEquals(true, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}