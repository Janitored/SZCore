package com.StravitZone.Core.API;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.StravitZone.Core.Commands.Setrank;

public class RankHandlers implements Listener{
	
	@EventHandler
	public void leave(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		if(Setrank.owner.containsKey(p)){
			Stravit.getInstance().getConfig().getStringList("isOwner").add(p.getName());
		}
		
		if(Setrank.admin.containsKey(p)){
			Stravit.getInstance().getConfig().getStringList("isAdmin").add(p.getName());
		}
		
		if(Setrank.mod.containsKey(p)){
			Stravit.getInstance().getConfig().getStringList("isMod").add(p.getName());
		}
		
		if(Setrank.builder.containsKey(p)){
			Stravit.getInstance().getConfig().getStringList("isBuilder").add(p.getName());
		}
		
		if(Setrank.vip.containsKey(p)){
			Stravit.getInstance().getConfig().getStringList("isVip").add(p.getName());
		}
		
		if(Setrank.dev.containsKey(p)){
			Stravit.getInstance().getConfig().getStringList("isDev").add(p.getName());
		}
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		if(Stravit.getInstance().getConfig().getStringList("isOwner").contains(p)){
			
		}
	}

}
