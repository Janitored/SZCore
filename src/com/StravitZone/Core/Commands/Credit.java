package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.Player.SPlayer;

public class Credit extends SCommand{

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		SPlayer pl = new SPlayer(p);
		
		if(c.getName().equalsIgnoreCase("credit")){
			if (!p.hasPermission(Rank.admin)) {
				p.sendMessage(ChatManager.error_permission()
						+ " You need §c§oADMIN §7to use this command.");
				return true;
			}
			
			if(a.length == 0){
				p.sendMessage(ChatManager.error_general() + " Usage: /credit <add/remove> <Player> <Amount>");
				return true;
			}
			
			else if(a[0].equalsIgnoreCase("add") && a.length == 1){
				p.sendMessage(ChatManager.error_general() + " Please specify a player!");
				return true;
			}
			
			else if(a[0].equalsIgnoreCase("add") && a.length == 2){
				p.sendMessage(ChatManager.error_general() + " Please specify an amount!");
				return true;
			}
			
			else if(a[0].equalsIgnoreCase("add") && a.length == 3){
				Player t = Bukkit.getPlayer(a[1]);
				
				try{
					int amount = Integer.parseInt(a[2]);
				} catch(Exception e){
					p.sendMessage(ChatManager.error_general() + " Value must be an integer.");
					return true;
				}
				
				int amount = Integer.parseInt(a[2]);
				
				pl.addCredits(t, amount);
				
				p.sendMessage(ChatManager.success() + " Added " + amount + " credit(s) to " + t.getName());
				
			}
			
			else if(a[0].equalsIgnoreCase("remove") && a.length == 1){
				p.sendMessage(ChatManager.error_general() + " Please specify a player!");
				return true;
			}
			
			else if(a[0].equalsIgnoreCase("remove") && a.length == 2){
				p.sendMessage(ChatManager.error_general() + " Please specify an amount!");
				return true;
			}
			
			else if(a[0].equalsIgnoreCase("remove") && a.length == 3){
				Player t = Bukkit.getPlayer(a[1]);
				
				try{
					int amount = Integer.parseInt(a[2]);
				} catch(Exception e){
					p.sendMessage(ChatManager.error_general() + " Value must be an integer.");
					return true;
				}
				
				int amount = Integer.parseInt(a[2]);
				
				pl.removeCredits(t, amount);
				
				p.sendMessage(ChatManager.success() + " Took " + amount + " credit(s) from " + t.getName());
				
			}
			
		}
		
		return false;
	}

}
