package com.StravitZone.Core.API;

import java.util.List;

import com.StravitZone.Core.Main;

public class CreditManager {
	
	public static Integer value = Main.rankdata.getInt("Value");
	
	public static void multiplyCredits(int multiplier){
		
		Main.rankdata.set("Value", multiplier);
		
	}
	
	public static int getValue(){
		return value;
	}

}
