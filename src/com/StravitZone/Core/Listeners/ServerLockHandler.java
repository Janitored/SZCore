package com.StravitZone.Core.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.ServerManager;
import com.StravitZone.Core.Commands.Lock;

public class ServerLockHandler implements Listener {

	@EventHandler
	public void login(PlayerLoginEvent e) {
		if (ServerManager.isLocked()
				&& !Lock.allowed.contains(e.getPlayer().getUniqueId())) {
			e.disallow(
					Result.KICK_WHITELIST,
					ChatManager.error_general()
							+ " StravitZone is currently on lockdown! Check back later.");
		}

		else if (ServerManager.isLocked()
				&& Lock.allowed.contains(e.getPlayer().getUniqueId())) {
			e.allow();
		}

		else if (!ServerManager.isLocked()) {
			if(!(e.getPlayer().hasPermission(Rank.admin) || e.getPlayer().hasPermission(Rank.builder))){
				e.disallow(Result.KICK_WHITELIST, ChatManager.error_general() + " §cOnly players with §4§lDEV§c+ are permitted to join at this time.");
			}
		}
	}

}