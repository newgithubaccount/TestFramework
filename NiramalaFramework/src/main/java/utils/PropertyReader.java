package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	String baseUrl;
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public void ReadProperties()
	{
	 try (InputStream input = new FileInputStream("./env.properties")) {

         Properties prop = new Properties();

         // load a properties file
         prop.load(input);

         if(prop.getProperty("env").equals("stage1"))
        	 baseUrl=prop.getProperty("stage1url");
         else if(prop.getProperty("env").equals("stage2"))
        	 baseUrl=prop.getProperty("stage2url");
         
        

     } catch (IOException ex) {
         ex.printStackTrace();
     }

	}
}
