package commonFunctions;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testNg_common_functions.RunnerFunctions;

public class CommonFunctions {

	public static WebDriver driver;
	
	public static void enterText(By xpath,String text)
	{
		driver.findElement(xpath).sendKeys(text);
	}
	
	public static void click(By btnxpath)
	{
		driver.findElement(btnxpath).click();
	}
	
	public static void scroll(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
