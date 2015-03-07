package com.StravitZone.Core.API;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class RankChat implements Listener{
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent e){
		
		if(e.getPlayer().hasPermission(Rank.admin)){
			e.setFormat("§c§lADMIN §c" + "%s§f: " + "%s");
		}
		
		if(e.getPlayer().hasPermission(Rank.moderator)){
			e.setFormat("§9§lMOD §9" + "%s§f: " + "%s");
		}
		
		if(e.getPlayer().hasPermission(Rank.vip)){
			e.setFormat("§6§lVIP §6" + "%s§f: " + "%s");
		}
		
		if(e.getPlayer().hasPermission(Rank.builder)){
			e.setFormat("§a§lBUILDER §a" + "%s§f: " + "%s");
		}
		
		if(e.getPlayer().hasPermission(Rank.all)){
			e.setFormat("§7" + "%s§f: " + "%s");
		}
		
	}

}