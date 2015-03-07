package com.StravitZone.Core.API;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTD implements Listener{
	
	@EventHandler
	public void motd(ServerListPingEvent e){
		int motd = new Random().nextInt(5);
		if(motd == 1){
			e.setMotd("§6§lStravitZone §b§l> §c3.0!");
		}
		if(motd == 2){
			e.setMotd("§6§lStravitZone §b§l> §cThe art of Janitored_!");
		}
		
		if(motd == 3){
			e.setMotd("§6§lStravitZone §b§l> §cwhy are you still refreshing?");
		}
		
		if(motd == 4){
			e.setMotd("§6§lStravitZone §b§l> §clol");
		}
		
		if(motd == 5){
			e.setMotd("§6§lStravitZone §b§l> §cwhat?");
		}
		
		e.setMaxPlayers(Bukkit.getOnlinePlayers().length + 1);
	}

}