package com.StravitZone.Core.Utils;

import java.util.Date;

public class Day {
	
	private static Date d = new Date();
	
	public static boolean isMonday(){
		return d.getDay() == 1;
	}
	
	public static boolean isTuesday(){
		return d.getDay() == 2;
	}
	
	public static boolean isWednesday(){
		return d.getDay() == 3;
	}
	
	public static boolean isThursday(){
		return d.getDay() == 4;
	}
	
	public static boolean isFriday(){
		return d.getDay() == 5;
	}
	
	public static boolean isSaturday(){
		return d.getDay() == 6;
	}
	
	public static boolean isSunday(){
		return d.getDay() == 7;
	}
	
	public static int getDay(){
		return d.getDay();
	}

}
