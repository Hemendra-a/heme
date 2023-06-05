package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public LoginObject LoginObject;
	public WebDriver driver;
	public PageObjectManager (WebDriver driver) {
		this.driver=driver;
	}

	public LoginObject getLoginpage() {
		LoginObject =new LoginObject(driver);
		return LoginObject;
		
	}

	
	
	
}
