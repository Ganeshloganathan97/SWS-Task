package SWS_Item_Creation;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class swsconfigur_reader {

	  Properties properties;
	  
	  public swsconfigur_reader() {
		  
		        try {
		            // Adjust the path if needed. This assumes the properties file is in the project root.
		            FileInputStream fis = new FileInputStream("C:\\Users\\LOGANATHANGA\\OneDrive - Agilysys, Inc\\Ganesh\\Automation Testing\\Eclipse\\Selenium_Test\\src\\SWS_Item_Creation\\swsconfig.properties");
		            properties = new Properties();
		            properties.load(fis);
		        } catch (IOException e) {
		            System.out.println("Sorry, unable to find swsconfig.properties");
		            e.printStackTrace();
		        }
		    }
	    	
	    	 /*try {
	             // Load the config.properties file from the classpath
	             InputStream input = getClass().getClassLoader().getResourceAsStream("swsconfig.properties");
	             if (input == null) 
	             {
	                 System.out.println("Sorry, unable to find swsconfig.properties");
	                 return;
	             }

	             properties = new Properties();
	             properties.load(input);
	             input.close();
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	     }*/
	  
	// Method to get the URL from the config.properties file
	    public String getUrl() {
	        return properties.getProperty("url");
	    }
	  
	    public String getUsername() {
	        return properties.getProperty("username");
	    }

	    // Method to get password
	    public String getPassword() {
	        return properties.getProperty("password");
	    }
	    
	    public String getusernameTextfield() {
	    	return properties.getProperty("usernameTextfield");
	    }
	    
	    public String getpasswordfield() {
	    	return properties.getProperty("passwordfield");
	    }
}
