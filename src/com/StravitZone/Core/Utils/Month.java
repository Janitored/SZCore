package com.StravitZone.Core.Utils;

import java.util.Date;

public class Month {
	
	private static Date d = new Date();
	
	
		public static boolean isJanuary(){
			
			return d.getMonth() == 1;

		}
		
		public static boolean isFebuary(){
			
			return d.getMonth() == 2;
			
		}
		
		public static boolean isMarch(){
			
			return d.getMonth() == 3;
			
		}
		
		public static boolean isApril(){
			
			return d.getMonth() == 4;
			
		}
		
		public static boolean isMay(){
			
			return d.getMonth() == 5;
			
		}	
		
		public static boolean isJune(){
			
			return d.getMonth() == 6;
			
		}
		
		public static boolean isJuly(){
			
			return d.getMonth() == 7;
			
		}
		
		public static boolean isAugust(){
			
			return d.getMonth() == 8;
			
		}
		
		public static boolean isSeptember(){
			
			return d.getMonth() == 9;
			
		}
		
		public static boolean isOctober(){
			
			return d.getMonth() == 10;
			
		}
		
		public static boolean isNovember(){
			
			return d.getMonth() == 11;
			
		}
		
		public static boolean isDecember(){
			
			return d.getMonth() == 12;
			
		}
		
		public static int getMonth(){
			return d.getMonth();
		}
	

}
