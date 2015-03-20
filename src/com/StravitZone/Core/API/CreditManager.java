package com.StravitZone.Core.API;

import java.util.List;

import com.StravitZone.Core.Main;

public class CreditManager {
	
	public static Integer value = Main.creditvalues.getInt("Value");
	
	public static void multiplyCredits(int multiplier){
		
		Main.creditvalues.set("Value", multiplier);
		
	}
	
	public static int getValue(){
		return value;
	}

}
