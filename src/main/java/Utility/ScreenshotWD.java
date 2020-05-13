package Utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotWD {
	static WebDriver driver;
	/*public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/"
				+ "chrome"
				+ "driver.exe");
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://10.124.130.119/CPSWeb/#/Login");
		takeAScreenShot("OnLaunch");
		PropertyReader pr =new PropertyReader();
		driver.findElement(By.xpath(pr.readProperty("Terumo_Login_Username","MyData"))).sendKeys("terumoqa36");
		driver.findElement(By.xpath(pr.readProperty("Terumo_Login_Password","MyData"))).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
		driver.findElement(By.xpath(pr.readProperty("Terumo_Clickon_Login","MyData"))).click();
		takeAScreenShot("After login");*/
	
	
	public static String  takeAScreenShot(String screenShotFileName,WebDriver driver){
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName = System.getProperty("user.dir")+"/ScreenShot/"+screenShotFileName+".png";
		try {
			FileUtils.copyFile(screenShot, new File(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
		
		
	}

}
