package com.StravitZone.Core.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvPProtection implements Listener{
	
	@EventHandler
	public void damage(EntityDamageByEntityEvent e){
		
		Player p = (Player) e.getEntity();
		
		if(p.getWorld().getName().equals("Hub")){
			e.setCancelled(true);
		}
		
		if(p.getWorld().getName().equals("WaitOCN")){
			e.setCancelled(true);
		}
		
		if(p.getWorld().getName().equals("WaitBow")){
			e.setCancelled(true);
		}
		
		if(p.getWorld().getName().equals("WaitPot")){
			e.setCancelled(true);
		}
		
		if(p.getWorld().getName().equals("WaitSoup")){
			e.setCancelled(true);
		}
	}

}
