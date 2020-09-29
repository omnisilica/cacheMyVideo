package com.case_study_sa.controller;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class CurrentDate {
	
	private static LocalDateTime currentDateNow = null;

		public static String parseDate() {    
			   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now(); 
			   currentDateNow = now;
			   System.out.println(dtf.format(now));  
			   return currentDateNow.toString();
			  }  

}

