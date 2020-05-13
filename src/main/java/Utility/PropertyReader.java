package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public  String readProperty(String key, String fileName) {
		File file = new File(System.getProperty("user.dir") + "/InputData/" + fileName + ".properties");
		try {
			FileInputStream fis = new FileInputStream(file);

			Properties prop = new Properties();
			prop.load(fis);
			return (prop.getProperty(key));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Not Found";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Not found";
		}
	}
}
