package hard_assertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AssertTrue_assertion {
 
	
	@DataProvider(name="loginCred")
	public Object[][] getdata()
	{
		return new Object[][] {
			{"Admin","admin123"}
		};
	}
	
@Test (dataProvider ="loginCred")
  public void case1(String username,String password) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			
			driver.findElement(By.xpath("//button")).click();
			Thread.sleep(5000);
			Boolean isdisplayed=driver.findElement(By.xpath("//h6")).isDisplayed();
			
			//assertTrue - check conditino return true value...
//			check isdisplayed variable return true value. 
			Assert.assertTrue(isdisplayed,"not displayed");
//			this line check vairable return true value if it return false then then "not displayed "message will displayed.

		}

}
