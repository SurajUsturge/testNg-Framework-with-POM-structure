package softAssertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertEqual {
	
	@DataProvider(name="loginCred")
	public Object[][] getdata()
	{
		return new Object[][]
				{
					{"Admin","admin123"}
				};
		}
	
  @Test(dataProvider = "loginCred")
  public void f(String username,String password) throws InterruptedException {
	  
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
		
		//assert equal assertion checks expected and actual value is equal 
		String actualValue=driver.findElement(By.xpath("//h6")).getText();
		
		 String ExpectedValue="dashbaord";
	        
//		 need to create object to user softassertion in testNg.
		 SoftAssert softAssert = new SoftAssert();

	        softAssert.assertEquals(actualValue, ExpectedValue,"not matching text");
	        softAssert.assertAll();//--  alway invoke assertAll(),this return exception if one of assertion failed in test case.
//			 other test case will be shown as passed.
	        System.out.println("assertion failed");
  }
}
