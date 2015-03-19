package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.Player.SPlayer;

public class Credits extends SCommand{

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		SPlayer pl = new SPlayer(p);
		
		if(c.getName().equalsIgnoreCase("credits") && a.length == 0){
			pl.message(p, ChatManager.info() + " Balance: " + pl.getCredits(p) + " credits");
			return true;
		}
		
		if(a.length == 1){
			Player t = Bukkit.getPlayer(a[0]);
			pl.message(p, ChatManager.info() + t.getName() + "'s balance: " + pl.getCredits(t) + " credits");
			return true;
		}
		
		
		return false;
	}

}
