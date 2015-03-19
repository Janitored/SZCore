package com.StravitZone.Core.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.API.ServerManager;

public class Lock extends SCommand{
	
	public static List<UUID> allowed = new ArrayList<UUID>();

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("lock")){
			if(!p.hasPermission(Rank.admin)){
				p.sendMessage(ChatManager.error_permission()
						+ " You need §c§oADMIN §7to use this command.");
				return true;
			}
			
			if(!ServerManager.isLocked()){
				p.sendMessage(ChatManager.error_general() + " The server is not locked! Type /server lock to lock the server.");
				return true;
			}
			
			if(ServerManager.isLocked() && a.length == 0){
				p.sendMessage(ChatManager.error_general() + " Available credentials: addUser, removeUser, list");
			}
			
			else if(a[0].equalsIgnoreCase("addUser") && a.length == 1){
				p.sendMessage(ChatManager.error_general() + " Please specify a player!");
			}
			
			else if(a.length == 2 && a[0].equalsIgnoreCase("addUser")){
				OfflinePlayer t = Bukkit.getOfflinePlayer(a[1]);
				if(allowed.contains(t.getUniqueId())){
					p.sendMessage(ChatManager.error_general() + " That player is already on the allow list!");
					return true;
				}
				allowed.add(t.getUniqueId());
				p.sendMessage(ChatManager.success() + " Player " + t.getName() + " has been added to the allowed list.");
			}
			
			else if(a[0].equalsIgnoreCase("removeUser") && a.length == 1){
				p.sendMessage(ChatManager.error_general() + " Please specify a player!");
			}
			
			else if(a.length == 2 && a[0].equalsIgnoreCase("removeUser")){
				OfflinePlayer t = Bukkit.getOfflinePlayer(a[1]);
				if(!allowed.contains(t.getUniqueId())){
					p.sendMessage(ChatManager.error_general() + " That user is not on the allow list!");
					return true;
				}
				allowed.remove(t.getUniqueId());
				p.sendMessage(ChatManager.success() + " Player " + t.getName() + " has been removed from the allowed list.");
			}
			
			else if(a[0].equalsIgnoreCase("list")){
				if(allowed.isEmpty()){
					p.sendMessage(ChatManager.error_general() + " No UUIDs have been added to the allow list!");
					return true;
				}
				
				else if(allowed.size() > 0){
					p.sendMessage(ChatManager.success() + " Allowed UUIDs:");
					p.sendMessage(ChatManager.success() + allowed.toString());
				}
				
			}
			
		}
		return false;
	}

}
