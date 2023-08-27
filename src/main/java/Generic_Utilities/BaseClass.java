package Generic_Utilities;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("parallel execution");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Launching Browser");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("login to Application");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("logout from Application");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("Close Browser");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("parallel execution done");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Data BAse Connection Close");
	}
}
