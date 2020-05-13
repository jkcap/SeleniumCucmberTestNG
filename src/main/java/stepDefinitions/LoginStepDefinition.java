package stepDefinitions;




import org.openqa.selenium.WebDriver;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;

import Utility.fileReader1;

import Utility.CommonMethods;
import Utility.POMLogin;



public class LoginStepDefinition{

	 public static WebDriver driver,driver1;
	 POMLogin pom = new POMLogin();
	 fileReader1 ff = new fileReader1();
		String[][] xData = ff.filereadxls("jignesh", "login");
	    int i = 1;
		

	
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
		/* System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/" + "chrome" + "driver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
	        driver.get("https://www.freecrm.com/index.html");
	 }
*/
        driver1 = CommonMethods.LuanchDriver();
	 }
	
	
	
	 //Reg Exp:
	 //1. \"([^\"]*)\"
	 //2. \"(.*)\"
	
	// @Then("^user enters \"(.*)\" and \"(.*)\"$")
	 @Then("^user enters username and password\\.$")
	 public void user_enters_username_and_password()  {
		 PageFactory.initElements(driver1, POMLogin.class);
		 POMLogin.Login_enter_email.sendKeys(xData[i][0]);
		 POMLogin.Login_enter_pwd.sendKeys(xData[i][1]);
	 //driver.findElement(By.name("username")).sendKeys(username);
	 //driver.findElement(By.name("password")).sendKeys(password);
		
	 }
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() {
		 POMLogin.clk_on_Login.click();
	 }
	
	
	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page(){
	CommonMethods.loginverify(driver);
	 }
	 
	 

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	
	
	

}
