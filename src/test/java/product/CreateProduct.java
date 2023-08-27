package product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMRepository.CreateProductPage;
import POMRepository.HomePage;
import POMRepository.LoginPage;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		File_Utility flib=new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
	
		/*FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
		driver.get(URL);
		LoginPage login=new LoginPage(driver);
		login.logInToVtiger(USERNAME, PASSWORD);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		HomePage home=new HomePage(driver);
		home.clickProductLink();
		//driver.findElement(By.linkText("Products")).click();
		CreateProductPage product=new CreateProductPage(driver);
		product.clickProductImg();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Random ran = new Random();
	     int ranNum = ran.nextInt(1000);
		
		/*FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
	     Cell cell = row.getCell(0);
	    String ProductName = cell.getStringCellValue()+ranNum;*/
	    
	    Excel_Utility elib=new Excel_Utility();
	    String ProdName = elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
	    product.productName(ProdName);
	  // driver.findElement(By.name("productname")).sendKeys(ProductName);
	    product.clickSaveButton();
	//WebElement saveButton = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
	
	//WebDriver_Utility wlib=new WebDriver_Utility();
	//wlib.scrollPAge(driver, saveButton);
	/*Rectangle rect = saveButton.getRect();
	System.out.println(rect.getX());
	System.out.println(rect.getY());
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1152)");*/
	
	// driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
	
	    Thread.sleep(2000);
	    home.logout(driver);
	 //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	  //  driver.findElement(By.linkText("Sign Out")).click();
	
	}

}
