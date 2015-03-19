package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.MuteHandlers;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.Player.OfflineSPlayer;
import com.StravitZone.Core.Player.SPlayer;

public class Unmute extends SCommand {

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if (c.getName().equalsIgnoreCase("unmute")) {
			if (!(p.hasPermission(Rank.admin) || p
					.hasPermission(Rank.moderator))) {
				p.sendMessage(ChatManager.error_permission()
						+ " You need §9§oMODERATOR §7to use this command.");
				return true;
			}

			if (a.length == 0) {
				p.sendMessage(ChatManager.error_general()
						+ " Usage: /unmute <Player>");
				return true;
			}

			if (a.length == 1) {
				Player t = Bukkit.getPlayer(a[0]);
				OfflinePlayer tt = Bukkit.getOfflinePlayer(a[0]);
				if(tt == null){
					s.sendMessage(ChatManager.error_general() + a[0] + " cannot be found! (Have they ever joined the server?)");
					return true;
				}
				if (tt.isOnline()) {
					SPlayer pl = new SPlayer(t);
					if (t.isOnline() && MuteHandlers.onlinemuted.contains(t)) {
						p.sendMessage(ChatManager.success() + " Unmuted §e§o"
								+ t.getName() + "§6.");
						pl.unmute(t);
						return true;
					}
				}
				else if (!(tt.isOnline()
						&& MuteHandlers.muted.contains(tt.getUniqueId()))) {
					OfflineSPlayer ttt = new OfflineSPlayer(tt);
					p.sendMessage(ChatManager.success() + " Unmuted §e§o"
							+ tt.getName() + "§6.");
					ttt.unmute(tt);
					return true;
				}

				if (!MuteHandlers.muted.contains(tt.getUniqueId())
						|| !MuteHandlers.onlinemuted.contains(t)) {
					p.sendMessage(ChatManager.error_general()
							+ " That player is not muted!");
					return true;
				}

			}
			return false;
		}
		return false;
	}
}
