package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.PingAPI;
import com.StravitZone.Core.API.SCommand;

public class Ping extends SCommand{

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("ping") && a.length == 0){
			p.sendMessage(ChatManager.info() + " Your ping: " + PingAPI.pingPlayer(p) + "ms");
		}
		
		if(a.length == 1){
			Player t = Bukkit.getPlayer(a[0]);
			if( t == null){
				p.sendMessage(ChatManager.error_player_not_found());
				return true;
			}
			p.sendMessage(ChatManager.info() + t.getName() + "'s ping: " + PingAPI.pingPlayer(t) + "ms");
		}
		
		return false;
	}

}
