package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.LoginObject;
import utils.Testcontextsetup;

public class Loginpage {
	Testcontextsetup Testcontextsetup;
    LoginObject LoginObject ;
	public Loginpage(Testcontextsetup Testcontextsetup) {
        this.Testcontextsetup=Testcontextsetup;
		this.LoginObject =Testcontextsetup.PageObjectManager.getLoginpage();
	}
	@Given("user is on login page")
	public void user_is_on_login_page() {
		LoginObject.Loginpage();
	}

	@When("user add login_id {string} and password {string}")
	public void user_add_login_id_and_password(String string, String string2) {
		LoginObject.LoginId(string);
		LoginObject.Password(string2);
	}

	@When("click on login button")
	public void click_on_sign_in_button() {
		LoginObject.ClickonHideButton();
		LoginObject.ClickonHideButton();
	    LoginObject.ClickonLoginButton();
	}

	@Then("user successfully logged in and navigate to task screen")
	public void user_successfully_logged_in_and_navigate_to_task_screen() {
		LoginObject.user_on_taskscreen();
	}
	@Then("user get an error message failed to login")
	public void user_get_an_error_message_failed_to_login() {
		LoginObject.GetError_message();
	}
}
