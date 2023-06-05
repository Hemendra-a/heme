package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

    public class LoginObject {
	public WebDriver driver;
	public LoginObject(WebDriver driver) {
    		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//*[@id='first-input']")
	private WebElement LoginId;
	@FindBy(xpath="//*[@id='password']")
	private WebElement Password;
	@FindBy(xpath="//*[@type='button']")
	private WebElement ClickonhideButton;
	@FindBy(xpath="//*[@type='submit']")
	private WebElement ClickonLoginButton;
	@FindBy(xpath="/html/body/div[2]/div/div[1]/div/div/div[1]/h3")
	private WebElement LoginFailed;
//	@FindBy(xpath="//*[text()='Ok']")
//	private WebElement ClickOn_Okbutton;
	@FindBy(xpath="//*[@title='Cancel']")
	private WebElement ClickOn_Cancelbutton;
	
	public void Loginpage ()  {
		TestBase.executionDelay(5);
        String url=driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue(url.contains("test"));
	}
	public void LoginId(String loginId) {
		LoginId.isEnabled();
		System.out.println(loginId);
		TestBase.executionDelay(2);
		LoginId.sendKeys(loginId);
 
	}

	public void Password(String pass) {
		 Password.isEnabled();
		 System.out.println(pass);
		 TestBase.executionDelay(2);
		 Password.sendKeys(pass);
		
		
	}
	public void ClickonHideButton() {
//		 Thread.sleep(1000);
		TestBase.executionDelay(1);
		ClickonhideButton.click();
	}
	public void ClickonLoginButton() {
		 ClickonLoginButton.isEnabled();
//		 TestBase.waitForElementToBeClickable(ClickonLoginButton, driver, 50).click();
		 ClickonLoginButton.click();
	}
	public void user_on_taskscreen() {
		 
		 System.out.println("user successfully logged in and navigate to task screen");
	}
	
	public void GetError_message() {
//	     WebDriverWait wait=new WebDriverWait(driver,20); 
//		 String text=wait.until(ExpectedConditions.visibilityOf( LoginFailed)).getText();
//		 wait.until(ExpectedConditions.visibilityOf( ClickOn_Okbutton)).click();
		 String text=TestBase.waitForElementToBeVisible(LoginFailed, driver, 50).getText();
		 TestBase.waitForElementToBeClickable(ClickOn_Cancelbutton, driver, 50).click();
		 System.out.println(text);
	}
}
