package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Addworld extends SCommand{

	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("addworld")){
			if(!(p.hasPermission(Rank.admin) || p.hasPermission(Rank.builder))){
				p.sendMessage(ChatManager.error_permission()
						+ " You need §a§oBUILDER §7to use this command.");
				return true;
			}
			
			if(a.length == 0){
				p.sendMessage(ChatManager.error_general() + " Usage: /addworld <WorldName>");
				return true;
			}
			
			if(a.length == 1){
				if(Bukkit.getWorlds().contains(Bukkit.getWorld(a[0]))){
					p.sendMessage(ChatManager.error_general() + " That world already exists!");
					return true;
				}
				
				p.sendMessage(ChatManager.success() + " Creating world §e§o" + a[0] + "§6...");
				
				Bukkit.getServer().createWorld(new WorldCreator(a[0]));
				
				Bukkit.getWorlds().add(Bukkit.getWorld(a[0]));
				
				Bukkit.getWorld(a[0]).save();
				
				p.sendMessage(ChatManager.success() + " Created world §e§o" + a[0] + "§6!");
				
			}
			
		}
		return false;
	}

}
