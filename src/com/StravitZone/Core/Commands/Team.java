package com.StravitZone.Core.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.Player.SPlayer;

public class Team extends SCommand{

	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		SPlayer sp = new SPlayer(p);
		if(c.getName().equalsIgnoreCase("team")){
			sp.message(p, ChatManager.info() + " Your team is " + sp.getTeam(p));
		}
		return false;
	}

}
