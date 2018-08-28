package com.bmpl.testengine.common.dto;

import java.util.ResourceBundle;


//PropertyReader class is used for providing the path of that config path that we created to give file path
//Common Class is made so that this PropertyReader will read from the file
public class PropertyReader {
	
	//This Resource Bundle is used to read the file from config
	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	
	
	public static String getUserFilePath(){
		//This will get the string and returns the file
		return rb.getString("userfilepath");
	}
	
	public static String getExcelPath(){
		return rb.getString("questionpath");
	}
}
