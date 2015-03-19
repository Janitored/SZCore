package com.StravitZone.Core.CreditBoosters;

import com.StravitZone.Core.API.CreditManager;
import com.StravitZone.Core.Utils.Day;

public class FridayBoosters {
	
	public FridayBoosters(){
		if(Day.isFriday()){
			CreditManager.multiplyCredits(4);
		}
	}

}
