package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Kick extends SCommand{
	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
	if (c.getName().equalsIgnoreCase("kick")) {
		if (!(p.hasPermission(Rank.moderator)
				|| p.hasPermission(Rank.admin))) {
			p.sendMessage(ChatManager.error_permission()
					+ " You need §9§oMODERATOR §7to use this command.");
			return true;
		}
		if (a.length == 0) {
			p.sendMessage(ChatManager.error_general()
					+ " Usage: /kick <User> <Reason>");
		}

		if (a.length == 1) {
			Player t = Bukkit.getPlayer(a[0]);
			p.sendMessage(ChatManager.error_general()
					+ " Please specify a reason!");
		}

		if (a.length >= 2) {
			Player t = Bukkit.getPlayer(a[0]);
			if(t == null){
				p.sendMessage(ChatManager.error_general()
						+ " The specified player cannot be found!");
				return true;
			}
			StringBuilder str = new StringBuilder();
			for (int i = 1; i < a.length; i++) {
				str.append(a[i] + " ");
			}

			String reason = str.toString();
			p.sendMessage(ChatManager.success() + " Kicked player [§e§o"
					+ t.getName() + "§6] for the reason [§e§o" + reason
					+ "§6]");
			t.kickPlayer("§4§lPUNISHMENT \n §7" + "\n §c§l" + p.getName()
					+ " §7has kicked you for the reason: \n §c§l" + "\n"
					+ reason);
		}
	}

	return false;
}

}
