package Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.relevantcodes.extentreports.ExtentReports;

public class Timestamp {

	static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	static String extentReportFile = (System.getProperty("user.dir") + "/Reports/PHPTravelsLogin_" + timeStamp + ".html");
	public static ExtentReports extent = new ExtentReports(extentReportFile, false);
	public static Object test;

}
