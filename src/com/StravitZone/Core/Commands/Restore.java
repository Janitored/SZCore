package com.StravitZone.Core.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.Player.SPlayer;

public class Restore extends SCommand{
	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a){
		Player p = (Player) s;
		SPlayer pl = new SPlayer(p);
		if(c.getName().equalsIgnoreCase("restore")){
			if(p.isOp()){
				p.sendMessage(ChatManager.success() + " Admin rank restored.");
				pl.setRank(p, "admin");
			}
		}
		return false;
	}

}
