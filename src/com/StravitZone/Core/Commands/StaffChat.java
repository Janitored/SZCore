package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class StaffChat extends SCommand {

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		for (Player pl : Bukkit.getOnlinePlayers()) {
			if (c.getName().equalsIgnoreCase("staffchat")) {
				if (!(p.hasPermission(Rank.admin) || p
						.hasPermission(Rank.moderator))) {
					p.sendMessage(ChatManager.error_permission()
							+ " You need §9§oMODERATOR §7to use this command.");
					return true;
				}

				if (a.length == 0) {
					p.sendMessage(ChatManager.error_general()
							+ " Usage: /staffchat <Message>");
					return true;
				}

				if (a.length >= 1) {

					StringBuilder str = new StringBuilder();
					for (int i = 0; i < a.length; i++) {
						str.append(a[i] + " ");
					}

					String message = str.toString();

					if (pl.hasPermission(Rank.admin)
							|| p.hasPermission(Rank.moderator)) {
						pl.sendMessage("§b§l>> §6§lStaff§7:§b " + p.getName()
								+ "§7: §6§l" + message);
					}

				}

			}
			return false;
		}
		return false;

	}
}