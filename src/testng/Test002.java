package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test002 {

	@Test
	public void Test1()
	{
		System.out.println("Test1");
		Assert.assertEquals(false, true);
	}

	@Test
	public void Test2()
	{
		System.out.println("Test2");
		Assert.assertEquals(false, true);
	}
}