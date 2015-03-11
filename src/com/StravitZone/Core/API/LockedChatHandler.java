package com.StravitZone.Core.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.StravitZone.Core.Commands.Chat;

public class LockedChatHandler extends Chat implements Listener {

	@EventHandler
	public void locked(AsyncPlayerChatEvent e) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (Chat.locked.contains(p)) {
				e.setCancelled(true);
				e.getPlayer()
						.sendMessage(
								ChatManager.error_general()
										+ " You may not speak while the chat is locked!");
				return;
			}
			
			if(p.hasPermission(Rank.admin) || p.hasPermission(Rank.moderator)){
				e.setCancelled(false);
			}
			
		}
	}

}
