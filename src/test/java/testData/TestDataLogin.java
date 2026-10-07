package testData;

import org.openqa.selenium.By;

public class TestDataLogin {

	public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public static String username="Admin";
	public static String password= "admin123";
	public static By usernamxpath=By.xpath("//input[@name='username']");
	public static By passwordXpath=By.xpath("//input[@name='password']");
	public static By submitBtnxpath=By.xpath("//button");
}
