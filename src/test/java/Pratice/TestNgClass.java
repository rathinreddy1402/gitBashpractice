package Pratice;

import org.testng.annotations.Test;

public class TestNgClass {

	@Test
	public void createProductName()
	{
	
		System.out.println("productName created");
	}
	@Test(dependsOnMethods = "createProductName")
	public void modifyProductName()
	{
		System.out.println("productName modified");
	}
	@Test
	public void deleteProductName()
	{
		System.out.println("productName deleted");
	}
}
