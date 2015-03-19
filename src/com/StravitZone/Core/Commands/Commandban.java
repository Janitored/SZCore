package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.Player.OfflineSPlayer;
import com.StravitZone.Core.Player.SPlayer;

public class Commandban extends SCommand {

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
			Player p = (Player) s;
		if (c.getName().equalsIgnoreCase("ban")) {
			if (!(p.hasPermission(Rank.moderator)
					|| p.hasPermission(Rank.admin))) {
				p.sendMessage(ChatManager.error_permission()
						+ " You need §9§oMODERATOR §7to use this command.");
				return true;
			}
			if (a.length == 0) {
				p.sendMessage(ChatManager.error_general()
						+ " Usage: /ban <User> <Reason>");
			}

			if (a.length == 1) {
				Player t = Bukkit.getPlayer(a[0]);
				p.sendMessage(ChatManager.error_general()
						+ " Please specify a reason!");
			}

			if (a.length >= 2) {
				Player t = Bukkit.getPlayer(a[0]);
				OfflinePlayer tt = Bukkit.getOfflinePlayer(a[0]);
				if(tt == null){
					s.sendMessage(ChatManager.error_general() + a[0] + " cannot be found! (Have they ever joined the server?)");
					return true;
				}
				if(tt.isOnline()){
				StringBuilder str = new StringBuilder();
				for (int i = 1; i < a.length; i++) {
					str.append(a[i] + " ");
				}

				String reason = str.toString();
				p.sendMessage(ChatManager.success() + " Banned player [§e§o"
						+ t.getName() + "§6] for the reason [§e§o" + reason
						+ "§6]");
				SPlayer o = new SPlayer(t);
				
				o.ban(t, "§4§lPUNISHMENT \n §7" + "\n §c§l" + p.getName()
						+ " §7has banned you for the reason: \n §c§l" + "\n"
						+ reason + "\n"
						+ "\n §7Appeal at §c§lwww.StravitZone.enjin.com");
				t.setBanned(true);
				
				Bukkit.broadcastMessage(ChatManager.punish_ban() + t.getName() + " has been banned for " + reason);
				}
				
				else if(!(tt.isOnline())){
					
					StringBuilder str = new StringBuilder();
					for (int i = 1; i < a.length; i++) {
						str.append(a[i] + " ");
					}

					String reason = str.toString();
					p.sendMessage(ChatManager.success() + " Banned player [§e§o"
							+ tt.getName() + "§6] for the reason [§e§o" + reason
							+ "§6]");
					OfflineSPlayer o = new OfflineSPlayer(tt);
					
					o.ban(tt);
					tt.setBanned(true);
					
					Bukkit.broadcastMessage(ChatManager.punish_ban() + tt.getName() + " has been banned for " + reason);
					
				}
				
			}
		}

		return false;
	}
}