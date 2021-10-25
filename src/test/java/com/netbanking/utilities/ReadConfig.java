package com.netbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
   Properties prop;
   
   public ReadConfig() throws IOException
   {
	   prop = new Properties();
	   FileInputStream file = new FileInputStream(".\\configuration\\config.properties");
	   prop.load(file);
   }
   
   public String getbrowser()
   {
	   return prop.getProperty("browser");
   }
   
   public String getchromepath()
   {
	   return prop.getProperty("chromepath");
   }
   
   public String getfirefoxpath()
   {
	   return prop.getProperty("firefoxpath");
   }
   
   public String getiepath()
   {
	   return prop.getProperty("iepath");
   }
   
   public String getedgepath()
   {
	   return prop.getProperty("edgepath");
   }
   
   public String getusername()
   {
	   return prop.getProperty("username");
   }
   
   public String getpaswword()
   {
	   return prop.getProperty("password");
   }
   
   public String getbaseurl()
   {
	   return prop.getProperty("baseurl");
   }
}
