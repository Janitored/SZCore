package com.StravitZone.Core.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.API.ServerManager;


public class DataReload extends SCommand{

	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("datareload")){
			if(!p.hasPermission(Rank.admin)){
				p.sendMessage(ChatManager.error_permission()
						+ " You need §c§oADMIN §7to use this command.");
				return true;
			}
			
			ServerManager.reloadData();
			
			p.sendMessage(ChatManager.success() + " Data successfully reloaded!");
			
		}
		return false;
	}

}
