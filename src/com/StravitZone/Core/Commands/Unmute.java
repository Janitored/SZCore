package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.MuteHandlers;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Unmute extends SCommand{

	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("unmute")){
			if(!(p.hasPermission(Rank.admin) || p.hasPermission(Rank.moderator))){
				p.sendMessage(ChatManager.error_permission()
						+ " You need §9§oMODERATOR §7to use this command.");
				return true;
			}
			
			if(a.length == 0){
				p.sendMessage(ChatManager.error_general() + " Usage: /unmute <Player>");
				return true;
			}
			
			if(a.length == 1){
				Player t = Bukkit.getPlayer(a[0]);
				if(t.isOnline() && MuteHandlers.onlinemuted.contains(t)){
					p.sendMessage(ChatManager.success() + " Unmuted §e§o" + t.getName() + "§6.");
					MuteHandlers.onlinemuted.remove(t);
					return true;
				} 
				if(!t.isOnline() && MuteHandlers.muted.contains(t.getUniqueId())){
					p.sendMessage(ChatManager.success() + " Unmuted §e§o" + t.getName() + "§6.");
					MuteHandlers.muted.remove(t.getUniqueId());
					return true;
				} 
				
				if (!MuteHandlers.muted.contains(t.getUniqueId()) || !MuteHandlers.onlinemuted.contains(t)){
					p.sendMessage(ChatManager.error_general() + " That player is not muted!");
					return true;
				}
			}
			
		}
		return false;
	}
	
	

}