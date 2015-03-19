package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Unban extends SCommand{

	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("unban")){
			if(!(p.hasPermission(Rank.admin) || p.hasPermission(Rank.moderator))){
				p.sendMessage(ChatManager.error_permission()
						+ " You need §9§oMODERATOR §7to use this command.");
				return true;
			}
			
			if(a.length == 0){
				p.sendMessage(ChatManager.error_general() + " Usage: /unban <Player>");
				return true;
			}
			
			if(a.length == 1){
				OfflinePlayer t = Bukkit.getOfflinePlayer(a[0]);
				
				if(t == null){
					s.sendMessage(ChatManager.error_general() + a[0] + " cannot be found! (Have they ever joined the server?)");
					return true;
				}
				
				if(t.isBanned()){
					p.sendMessage(ChatManager.success() + " Unbanned §e§o" + t.getName() + "§6.");
					t.setBanned(false);
					return true;
				} else {
					p.sendMessage(ChatManager.error_general() + " That player is not banned!");
					return true;
				}
			}
		}
		return false;
	}

}