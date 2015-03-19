package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.Player.SPlayer;

public class Lookup extends SCommand {

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		
		SPlayer pl = new SPlayer(p);
		
		if (c.getName().equalsIgnoreCase("who")) {
			if (!(p.hasPermission(Rank.admin) || p
					.hasPermission(Rank.moderator))) {
				p.sendMessage(ChatManager.error_permission()
						+ " You need §9§oMODERATOR §7to use this command.");
			
				return true;
			}

			if (a.length == 0) {
				p.sendMessage(ChatManager.error_general()
						+ " Usage: /who <User>");
			}

			if (a.length == 1) {
				Player t = Bukkit.getPlayer(a[0]);
				
				OfflinePlayer ot = Bukkit.getOfflinePlayer(a[0]);

				if (!ot.isOnline()) {
					p.sendMessage(ChatManager.success() + " Information for "
							+ ot.getName() + "...");
					p.sendMessage(ChatManager.info() + " Status: §4Offline");
					if(ot.isBanned()){
						p.sendMessage(ChatManager.info() + " Banned: True");
					} else {
						p.sendMessage(ChatManager.info() + " Banned: §4False");
					}
					
					if(pl.isOfflineMuted(ot)){
						p.sendMessage(ChatManager.info() + " Muted: True");
					}else{
						p.sendMessage(ChatManager.info() + " Muted: §4False");
					}
					
					return true;
				}

				if (t.isOnline()) {

					p.sendMessage(ChatManager.success() + " Information for "
							+ t.getName() + "...");
					p.sendMessage(ChatManager.info() + " IP: " + t.getAddress());
					p.sendMessage(ChatManager.info() + " Rank: "
							+ pl.getRank(t));
					p.sendMessage(ChatManager.info() + " Status: Online");
					if(t.isBanned()){
						p.sendMessage(ChatManager.info() + " Banned: True");
					} else {
						p.sendMessage(ChatManager.info() + " Banned: §4False");
					}
					
					if(pl.isMuted(t)){
						p.sendMessage(ChatManager.info() + " Muted: True");
					}else{
						p.sendMessage(ChatManager.info() + " Muted: §4False");
					}
					p.sendMessage(ChatManager.info()
							+ " Location: "
							+ t.getWorld().getName() + ", "
									+ t.getLocation().getBlockX() + ", "
									+ t.getLocation().getBlockY() + ", "
									+ t.getLocation().getBlockZ());
					return true;

				}

			}
		}
		return false;
	}

}