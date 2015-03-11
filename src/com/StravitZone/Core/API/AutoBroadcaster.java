package com.StravitZone.Core.API;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;

public class AutoBroadcaster {

	private static int broadcast = 13;

	public static void enable() {

		new BukkitRunnable() {
			public void run() {

				for (Player p : Bukkit.getOnlinePlayers()) {

					broadcast--;

					if (broadcast == 10) {
						Bukkit.broadcastMessage(ChatManager.announcement()
								+ " Welcome to StravitZone 3.0!");
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
					}

					else if (broadcast == 6) {
						Bukkit.broadcastMessage(ChatManager.announcement()
								+ " Use your §a§lGame Arrows §bto play a gamemode!");
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
					}

					else if (broadcast == 2) {
						Bukkit.broadcastMessage(ChatManager.announcement()
								+ " Return to hub using §a§l/hub");
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
					}

					else if (broadcast == -2) {
						Bukkit.broadcastMessage(ChatManager.announcement()
								+ " Have questions/concerns? Ask our staff!");
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
						broadcast = 12;
					}
				}

			}
		}.runTaskTimer(Main.getInstance(), 250, 250);
	}

}
