package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.API.SStats;

public class Stats extends SCommand{

	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("stats") && a.length == 0){
			p.sendMessage(ChatManager.info() + " Your stats:");
			p.sendMessage(ChatManager.info() + " Kills: " + SStats.getKills(p.getName()));
			p.sendMessage(ChatManager.info() + " Deaths: " + SStats.getDeaths(p.getName()));
			p.sendMessage(ChatManager.info() + " KDR: " + SStats.getKDR(p.getName()));
		}
		
		if(a.length == 1){
			Player t = Bukkit.getPlayer(a[0]);
			p.sendMessage(ChatManager.info() + t.getName() + "'s stats:");
			p.sendMessage(ChatManager.info() + " Kills: " + SStats.getKills(t.getName()));
			p.sendMessage(ChatManager.info() + " Deaths: " + SStats.getDeaths(t.getName()));
			p.sendMessage(ChatManager.info() + " KDR: " + SStats.getKDR(t.getName()));
		}
		
		return false;
	}

}
