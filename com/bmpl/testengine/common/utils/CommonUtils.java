package com.bmpl.testengine.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;


public interface CommonUtils {
	public static String getPrintStackTrace(Exception e){
		//StringWriter writes upon the string
		StringWriter sw = new StringWriter();
		//PrintWriter integrates with StringWriter
		PrintWriter pw = new PrintWriter(sw);
		//This line used to write in catch block then it will writes in the console prints upon the console
		e.printStackTrace(pw);
		//it will converts to tostring method into some meaningful data
		return sw.toString();
	}
}
