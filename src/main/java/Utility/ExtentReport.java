package Utility;

	import java.io.File;
import java.text.SimpleDateFormat;
	import java.util.Calendar;

import com.relevantcodes.extentreports.ExtentReports;

// import com.relevantcodes.extentreports.ExtentReports;


	 
	public class ExtentReport {
	

		public static String createreport(String FilePath) {

			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			ExtentReports extent= new ExtentReports(
					System.getProperty("user.dir") + "/Reports/PHPTravelsLogin_" + timeStamp + ".html",true);
			extent
	        .addSystemInfo("Host Name", "Jignesh")
	        .addSystemInfo("Environment", "QA")
	        .addSystemInfo("User Name", "Jignesh Kalaria");
	        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			return FilePath ;

		}
	}



