package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Worlds extends SCommand{
	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("worlds")){
			if(!(p.hasPermission(Rank.admin) || p.hasPermission(Rank.builder))){
				p.sendMessage(ChatManager.error_permission()
						+ " You need §a§oBUILDER §7to use this command.");
				return true;
			}
			
			p.sendMessage(ChatManager.success() + " Current worlds:");
			p.sendMessage(ChatManager.success() + Bukkit.getWorlds());
			
		}
		return false;
	}

}
