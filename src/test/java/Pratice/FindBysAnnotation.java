package Pratice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.File_Utility;
import POMRepository.Login1Page;
import POMRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBysAnnotation {

	public static void main(String[] args) throws Throwable {
		
          WebDriverManager.chromedriver().setup();
          WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		File_Utility flib=new File_Utility();
	//	String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");

		driver.get("http://localhost:8888/");
		Login1Page login=new Login1Page(driver);
		login.loginToApplication(USERNAME, PASSWORD);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

	
		
	
	
	}

}
