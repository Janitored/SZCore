package com.StravitZone.Core.API;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingAPI {
	
	 public static int getPing(Player who){
	        return ((CraftPlayer)who).getHandle().ping;
	    }
	 
	 public static int pingPlayer(Player who) {
	        try {
	            String bukkitversion = Bukkit.getServer().getClass().getPackage()
	                    .getName().substring(23);
	            Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit."
	                    + bukkitversion + ".entity.CraftPlayer");
	            Object handle = craftPlayer.getMethod("getHandle").invoke(who);
	            Integer ping = (Integer) handle.getClass().getDeclaredField("ping")
	                    .get(handle);
	            return ping.intValue();
	        } catch (ClassNotFoundException | IllegalAccessException
	                | IllegalArgumentException | InvocationTargetException
	                | NoSuchMethodException | SecurityException
	                | NoSuchFieldException e) {
	            return -1;
	        }
	    }
	 

}
