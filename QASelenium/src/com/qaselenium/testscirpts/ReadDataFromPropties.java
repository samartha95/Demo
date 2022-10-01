package com.qaselenium.testscirpts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropties {

	public static void main(String[] args)  {
		
		try {
			FileInputStream ip=new FileInputStream("Resources/TestData.properties");
			Properties prop=new Properties();
			prop.load(ip);
			String url = prop.getProperty("search");
			System.out.println(url);
		} 	
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
