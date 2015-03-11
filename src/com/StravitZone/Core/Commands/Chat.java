package com.StravitZone.Core.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Chat extends SCommand {
	
	public static ArrayList<Player> locked = new ArrayList<>();

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		for(Player pl : Bukkit.getOnlinePlayers()){
			
			if(c.getName().equalsIgnoreCase("clearchat")){
				
				if(!(p.hasPermission(Rank.moderator) || p.hasPermission(Rank.admin))){
					s.sendMessage(ChatManager.error_permission()
							+ " You need §9§oMODERATOR §7to use this command.");
					return true;
				}
				
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("§4§lTHE CHAT HAS BEEN CLEARED!");
				
				
			}
			
			if(c.getName().equalsIgnoreCase("lockchat")){
				if(!(p.hasPermission(Rank.moderator) || p.hasPermission(Rank.admin))){
					s.sendMessage(ChatManager.error_permission()
							+ " You need §9§oMODERATOR §7to use this command.");
					return true;
				}
				
				if(!locked.contains(pl)){
				
				Bukkit.broadcastMessage("§4§lTHE CHAT HAS BEEN LOCKED!");
				
				locked.add(pl);
				
				} else if(locked.contains(pl)){
					Bukkit.broadcastMessage("§4§lTHE CHAT HAS BEEN UNLOCKED!");
					locked.remove(pl);
					return true;
				}
				
				
				
			}
		}
		return false;
	}
}
