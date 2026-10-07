package dataProviders_TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestMethod extends DataProviders_inTestNg{
	
	//dataprovider is user to enter multiple users data in forms 
	
	@Test(dataProvider = "loginData")
	public void loginToPortal(By usernameXpath, By passwordXpath,String username, String password)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(usernameXpath).sendKeys(username);
		System.out.println(username);
		driver.findElement(passwordXpath).sendKeys(password);
		System.out.println(password);
		driver.findElement(By.xpath("//button")).click();

	}
	
	
	
}
