package com.StravitZone.Core.API;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MuteHandlers implements Listener{
	
	public static List<UUID> muted = new ArrayList<>();
	public static List<Player> onlinemuted = new ArrayList<>();
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent e){
		if(onlinemuted.contains(e.getPlayer())){
			e.getPlayer().sendMessage("§4§lPUNISHMENT");
			e.getPlayer().sendMessage("");
			e.getPlayer().sendMessage("§c§lSILENCE!");
			e.getPlayer().sendMessage("");
			e.getPlayer().sendMessage("§7You are §c§l§oMUTED!");
			e.getPlayer().sendMessage("");
			e.getPlayer().sendMessage("§7Appeal at §c§lwww.StravitZone.enjin.com");
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent e){
		if(onlinemuted.contains(e.getPlayer())){
			muted.add(e.getPlayer().getUniqueId());
		}
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e){
		if(muted.contains(e.getPlayer().getUniqueId())){
			onlinemuted.add(e.getPlayer());
		}
	}

}
