package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Broadcast extends SCommand {

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if (c.getName().equalsIgnoreCase("broadcast")) {
			if (!p.hasPermission(Rank.admin)) {
				s.sendMessage(ChatManager.error_permission()
						+ " You need §c§oADMIN §7to use this command.");
				return true;
			}

			if (a.length == 0) {
				s.sendMessage(ChatManager.error_general()
						+ " Usage: /broadcast <Message>");
				return true;
			}

			if (a.length >= 1) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < a.length; i++) {
						sb.append(a[i] + " ");
					}

					String message = sb.toString();
					
					player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 3);

					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("§4§lBROADCAST");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("§6" + p.getName() + " §esays...");
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("§b" + message);
					Bukkit.broadcastMessage("");
					Bukkit.broadcastMessage("");
					return true;
				}

			}
			return false;
		}
		return false;

	}
}