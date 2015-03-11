package com.StravitZone.Core.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Hunger implements Listener{
	
	@EventHandler
	public void hunger(FoodLevelChangeEvent e){
		
		e.setCancelled(true);
		
	}

}
