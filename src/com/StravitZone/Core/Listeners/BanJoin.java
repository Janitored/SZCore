package com.StravitZone.Core.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class BanJoin implements Listener {

	@EventHandler
	public void login(PlayerLoginEvent e) {
		if(e.getPlayer().isBanned()){
		e.disallow(Result.KICK_BANNED, "§4§lPUNISHMENT " + "\n" + "§7You are currently §c§l§oBANNED§7." + "\n" + "§7Appeal at §c§lwww.StravitZone.enjin.com");
		} else {
			e.allow();
		}
	}

}