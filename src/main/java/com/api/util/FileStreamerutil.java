package com.api.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileStreamerutil {

	public static Properties prop;
	
	public FileStreamerutil()
	{

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\RIYAZ BASHA SHAIK\\eclipse-workspace\\ProjectAPI\\src\\main\\java\\com\\api\\util\\Datavalues.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e){

			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
