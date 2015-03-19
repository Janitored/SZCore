package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Deleteworld extends SCommand{

	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("deleteworld")){
			
			if(!(p.hasPermission(Rank.admin) || p.hasPermission(Rank.builder))){
				p.sendMessage(ChatManager.error_permission()
						+ " You need §a§oBUILDER §7to use this command.");
				return true;
			}
			
			if(a.length == 0){
				p.sendMessage(ChatManager.error_general() + " Usage: /deleteworld <WorldName>");
				return true;
			}
			
			if(a.length == 1){
				if(!Bukkit.getWorlds().contains(Bukkit.getWorld(a[0]))){
					p.sendMessage(ChatManager.error_general() + " That world does not exist!");
					return true;
				}
				
				p.sendMessage(ChatManager.success() + " Deleting world §e§o" + a[0] + "§6...");

				Bukkit.getServer().unloadWorld(a[0], true);
				
				p.sendMessage(ChatManager.success() + " Deleted world §e§o" + a[0] + "§6!");
				
			}
			
		}
		return false;
	}

}
