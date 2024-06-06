package utilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class PropertyFilereader {
	
	
	
	public static String getpropertyvalue(String key) throws IOException{
		
		FileInputStream fis=new FileInputStream("/Users/simaaktar/eclipse-workspace/SeleniumDemos/src/test/java/resources/configuration.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		

		
	}


}
