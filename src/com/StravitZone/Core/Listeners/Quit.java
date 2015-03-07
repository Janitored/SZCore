package com.StravitZone.Core.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.StravitZone.Core.API.ChatManager;

public class Quit implements Listener{
	
	@EventHandler
	public void join(PlayerQuitEvent e){
		e.setQuitMessage(ChatManager.player_quit() + e.getPlayer().getName());
	}

}
