package AppHooks;


import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.Testcontextsetup;

public class Hooks {
	Testcontextsetup Testcontextsetup;
	public Hooks (Testcontextsetup Testcontextsetup) {
		this.Testcontextsetup=Testcontextsetup;
	}
@After 
public void AfterScenario() throws IOException {
//	 Testcontextsetup.PageObjectManager.driver.quit();
//     Testcontextsetup.testbase.WebDriverManager().quit();
}

@AfterStep
public void AddScreenShot(Scenario scenario) throws IOException {
	WebDriver driver=Testcontextsetup.testbase.WebDriverManager();
	if(scenario.isFailed()) {
		
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotName);
	}
}
} 
