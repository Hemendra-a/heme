package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;

public WebDriver WebDriverManager() throws IOException{
	FileInputStream fis=new FileInputStream("src/test/resources/global.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String value=prop.getProperty("QAUrl");
	if(driver==null) {
		if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();//driver get the life
	driver.manage().window().maximize();
	

	
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();//driver get the life
			driver.manage().window().maximize();
		}

   
	driver.get(value);//url 
	
	}
	return driver;
   
}
public static void executionDelay(int n) {
	try {
		Thread.sleep(n * 1000);
	} catch (InterruptedException e) {

		e.printStackTrace();
	}
}
public static WebElement waitForElementToBeClickable(WebElement webelement, WebDriver driver, int seconds) {
	WebDriverWait wait = new WebDriverWait(driver, seconds);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
	return element;

}

public static WebElement waitForElementToBeVisible(WebElement webelement, WebDriver driver, int seconds) {
	WebDriverWait wait = new WebDriverWait(driver, seconds);
	WebElement element = wait.until(ExpectedConditions.visibilityOf(webelement));
	return element;

}
}

