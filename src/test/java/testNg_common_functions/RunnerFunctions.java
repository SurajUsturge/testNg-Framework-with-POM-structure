package testNg_common_functions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameter;

import commonFunctions.CommonFunctions;
import testData.TestDataLogin;

public class RunnerFunctions  extends CommonFunctions {
	
//	Common functions - 
//	Runnerfunction- //call testdata inside the Runnerfunction => className.xpath or classname.string
//	TestCase  
	
	public void loginToPortal_with_valid_Credentials()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(TestDataLogin.url);
		driver.manage().window().maximize();
		
		enterText(TestDataLogin.usernamxpath,TestDataLogin.username);
		enterText(TestDataLogin.passwordXpath,TestDataLogin.password);
		click(TestDataLogin.submitBtnxpath);
		
		Assert.assertEquals(driver.getTitle(),"OrangeHRM" ,"not match");
		
	}
	
	
	public void registrationForm() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://vinothqaacademy.com/demo-site/");
		driver.manage().window().maximize();
		
		int attempts = 0;
		while (attempts < 2) {
		
		try {
			driver.findElement(By.xpath("//input[@id='vfb-5']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@id='vfb-7']")).sendKeys("user");

			//male radio btn
			driver.findElement(By.xpath("//input[@value='Male']")).click();
	
			//select multiple checkbox
			List<String> options=List.of("Selenium WebDriver","Java");
		
			for(String opt:options)
			{
				driver.findElement(By.xpath("//input[@value='"+opt+"']")).click();
			}
	
			Thread.sleep(5000);
			//click dropdown
			driver.findElement(By.xpath("(//span[@class='selection']//span)[1]")).click();
			
	//		get options in dropdown
			List<WebElement>opts=driver.findElements(By.xpath("(//ul[@role='listbox']//li)"));
			System.out.println("options are:");
		
				for(WebElement getopt:opts)
				{
					System.out.println(getopt.getText());
				}
		
			
			//calendar
			driver.findElement(By.xpath("(//input[@id='vfb-18'])")).sendKeys("09/09/2026");
		}
		catch (StaleElementReferenceException e) {
			attempts++;
			System.out.println("exception got");
		}
	 }
	}
	
	public void alertshandling() throws InterruptedException
	{
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		//simple alert btn
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(3000);

		//		timer alert 5sec
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		Alert timerAlert =wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(timerAlert.getText());
		timerAlert.accept();
		Thread.sleep(3000);

		//		//confirmation alert
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		System.out.println(alert.getText());
		alert.dismiss();
		Thread.sleep(3000);

		//		//prompt alert
		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		alert.sendKeys("admin");
		System.out.println(alert.getText());
		alert.accept();
		
	}
	
	public void Handle_Iframes()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		List<WebElement> elements = driver.findElements(By.tagName("h1"));

		for(WebElement ele:elements)
		{		//get text inside frame
			System.out.println(ele.getText());
		}
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		List<WebElement> element2 = driver.findElements(By.tagName("h1"));
		for(WebElement ele:element2)
		{		//get text inside frame
			System.out.println(ele.getText());
		}
	}

	
	public void mouseHover()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://vinothqaacademy.com/mouse-event/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("(//a[text()='Free Complete QA Video Courses'])[2]"));
		Actions action=new Actions(driver);
		//mouse hover to element
		action.moveToElement(ele).build().perform();
	}
	
	
	public void SelectMultipleCheckbox()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://vinothqaacademy.com/demo-site/");
		driver.manage().window().maximize();
		
		//select multiple checkbox
		List<String> options=List.of("Selenium WebDriver","Java");
	
		for(String opt:options)
		{
			driver.findElement(By.xpath("//input[@value='"+opt+"']")).click();
		}
	}
	
//	
	public void SelectMultipleOptionInDropdown()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.htmlelements.com/demos/dropdownlist/multiple-selection/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
	
		//click dropdown
		driver.findElement(By.xpath("//span[@smart-id='actionButton']")).click();
		
		//		get options in dropdown
			List<String> options=List.of("Breve","Carajillo");
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
				for(String getopt:options)
				{
					WebElement optio=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@smart-id='itemContainer']/span[text()='"+getopt+"']")));
					//dynamic xpath
					js.executeScript("arguments[0].scrollIntoView(true);",optio );
					optio.click();
				}	
	}
	
	public void getOptionsInDropdown()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.htmlelements.com/demos/dropdownlist/multiple-selection/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		//click dropdown
		driver.findElement(By.xpath("//span[@smart-id='actionButton']")).click();

		//		get options in dropdown
		List<WebElement>opts=driver.findElements(By.xpath("//div[@smart-id='itemContainer']/span[1]"));
		System.out.println("options are:"+opts.size());
		JavascriptExecutor js=(JavascriptExecutor)driver;
			for(int i=0;i<opts.size();i++)
			{
				WebElement test= opts.get(i);
				js.executeScript("arguments[0].scrollIntoView(true);",test );
				System.out.println(opts.get(i).getText());
			}	
	}
	
	public  void switchToChildWindows() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\Overall_project-revision\\TestNg_tutorial\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		
		//click to open new tab or window
		driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
	}
	
	//this switch window/tab function can use anywhere.
		public void switchWidnow()
		{
			String currentwidnow=driver.getWindowHandle();
			for(String windowId:driver.getWindowHandles() )
			{
			   String title = driver.switchTo().window(windowId).getTitle();
				if (title.contains("Basic Controls"))
				{	
					System.out.println(driver.getTitle());
					break;
				}
			}
		}
	
	
}
