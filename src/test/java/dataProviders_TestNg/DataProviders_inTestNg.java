package dataProviders_TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class DataProviders_inTestNg {
	
	//using dataproviders - we can enter credentials of multiple users and login user in multiple users.
	//means we same procedure can do in multiple browser continueously.
	
	@DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            { By.xpath("//input[@name='username']"),By.xpath("//input[@name='password']"),
            	"Admin", "admin123"  },
            {By.xpath("//input[@name='username']"),By.xpath("//input[@name='password']"),
            	"locked_out_user", "secret_sauce" }
            
        };
    }
	
	
	//format of dataprovider
	@DataProvider(name="logindata")
	public Object[][] getdata()
	{
		return new Object[][] {
			{},
			{}
		};
	}
	
	
}
