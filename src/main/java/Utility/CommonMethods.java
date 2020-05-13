package Utility;


import java.util.Collections;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class CommonMethods {
	

	public static WebDriver driver, driver1;

	public static PropertyReader pr = new PropertyReader();

	static ExtentReports extent = new ExtentReports(System.getProperty("user.dir")+"/Reports/PHPTravelsLogin.html");

	   /* Launch Browser by parameterization of TestNG */
		public static WebDriver LuanchDriver() {
			String browser =  pr.readProperty("Browser", "MyData");
			// If the browser is Firefox, then do this
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir") + "/lib/" + "gecko" + "driver.exe");
				driver = new FirefoxDriver();
				// If browser is Chrome, then do this
			} else if (browser.equalsIgnoreCase("chrome")) {
				// Here I am setting up the path for my ChromeDriver
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/" + "chrome" + "driver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("start-maximized");
					options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
					options.setExperimentalOption("useAutomationExtension", false);
					driver = new ChromeDriver(options);
					}
					driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
					driver.manage().window().maximize();
						//driver.get("https://r39ci-enc-dev-ed.my.salesforce.com/");
					driver.get( pr.readProperty("URL", "MyData"));
						/* Validate Website is open or not */
						//driver1 = Validations.launchverify(driver);
					return driver;

					}
	
		public static WebDriver loginverify(WebDriver driver) {
			ExtentTest test = extent.startTest("User Authentication");
			 ExtentTest childTest = extent.startTest("Login");
			 test.assignCategory("Functional");
		String title = driver.getTitle();
		System.out.print("title" + title);
		if (title.contains("Salesforce - Developer Edition")) {

			childTest.log(LogStatus.PASS, "Login Snapshot :" + childTest
					.addScreenCapture(Utility.ScreenshotWD.takeAScreenShot("Login Succesfully", driver)));
			test.appendChild(childTest);
			extent.endTest(test);
			extent.flush();
		}

		else {

			childTest.log(LogStatus.PASS, "Login Snapshot : " + childTest
					.addScreenCapture(Utility.ScreenshotWD.takeAScreenShot("Login not Succesfully", driver)));
			test.appendChild(childTest);
			extent.endTest(test);
			extent.flush();
		}
		return driver;
		}
}