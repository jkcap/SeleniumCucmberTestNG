package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POMLogin {
	private static WebElement element = null;
	
	@FindBy(xpath=".//*[@id='rememberUn']")
	public static WebElement clk_Chcbox;
	
	@FindBy(xpath=".//*[@id='username']")
	public static WebElement Login_enter_email;
	
	@FindBy(xpath=".//*[@id='password']")
	public static WebElement Login_enter_pwd;
	
	@FindBy(xpath=".//*[@id='Login']")
	public static WebElement clk_on_Login;
	
	
	

}
