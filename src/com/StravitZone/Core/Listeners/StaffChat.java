package com.StravitZone.Core.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.StravitZone.Core.API.Rank;

public class StaffChat implements Listener {

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {

		Player p = e.getPlayer();

		for (Player player : Bukkit.getOnlinePlayers()) {

			if (e.getMessage().startsWith("@") && p.hasPermission(Rank.admin)
					|| p.hasPermission(Rank.moderator)) {
				e.setCancelled(true);
				if (player.hasPermission(Rank.admin)
						|| player.hasPermission(Rank.moderator)) {
					player.sendMessage("§6§lSTAFF§7: §b§l" + p.getName()
							+ "§7: §6§l" + e.getMessage().replace("@", ""));
				}
			}
		}

	}

}