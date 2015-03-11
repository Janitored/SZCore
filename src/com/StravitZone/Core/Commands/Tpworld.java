package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Tpworld extends SCommand {

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if (c.getName().equalsIgnoreCase("tpworld")) {
			if (!(p.hasPermission(Rank.moderator)
					|| p.hasPermission(Rank.admin) || p
						.hasPermission(Rank.builder))) {
					p.sendMessage(ChatManager.error_permission()
							+ " You need §a§oBUILDER §7to use this command.");
					return true;

			}
			
			if(a.length == 0){
				p.sendMessage(ChatManager.error_general() + " Usage: /tpworld <WorldName>");
			}
			
			if(a.length == 1){
				if(!Bukkit.getWorlds().contains(Bukkit.getWorld(a[0]))){
					p.sendMessage(ChatManager.error_general() + " That world does not exist!");
					return true;
				}
				
				Location w = new Location(Bukkit.getWorld(a[0]), 100, 100, 100);
				
				p.sendMessage(ChatManager.success() + " Teleporting...");
				
				p.teleport(w);
				
			}
			
		}
		return false;
	}

}
