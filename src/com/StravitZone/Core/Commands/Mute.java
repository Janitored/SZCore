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

public class Mute extends SCommand{
	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
	if (c.getName().equalsIgnoreCase("mute")) {
		if (!(p.hasPermission(Rank.moderator)
				|| p.hasPermission(Rank.admin))) {
			p.sendMessage(ChatManager.error_permission()
					+ " You need §9§oMODERATOR §7to use this command.");
			return true;
		}
		if (a.length == 0) {
			p.sendMessage(ChatManager.error_general()
					+ " Usage: /mute <User> <Reason>");
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
			SPlayer pl = new SPlayer(t);
			
			if(tt.isOnline()){
			
			StringBuilder str = new StringBuilder();
			for (int i = 1; i < a.length; i++) {
				str.append(a[i] + " ");
			}

			String reason = str.toString();
			p.sendMessage(ChatManager.success() + " Muted player [§e§o"
					+ t.getName() + "§6] for the reason [§e§o" + reason
					+ "§6]");
			t.sendMessage("§4§lPUNISHMENT");
			t.sendMessage("");
			t.sendMessage("§7You have been §c§l§oMUTED§7.");
			t.sendMessage("");
			t.sendMessage("§7By: §c§l" + p.getName());
			t.sendMessage("");
			t.sendMessage("§7Reason: §c§l" + reason);
			pl.mute(t);
			
			Bukkit.broadcastMessage(ChatManager.punish_mute() + t.getName() + " has been muted for " + reason);
			}
			
			else if(!(tt.isOnline())){
				
				OfflineSPlayer ttt = new OfflineSPlayer(tt);
				
				StringBuilder str = new StringBuilder();
				for (int i = 1; i < a.length; i++) {
					str.append(a[i] + " ");
				}

				String reason = str.toString();
				ttt.mute(tt);
				
				Bukkit.broadcastMessage(ChatManager.punish_mute() + tt.getName() + " has been muted for " + reason);
				
			}
			
		}
	}

	return false;
}

}
