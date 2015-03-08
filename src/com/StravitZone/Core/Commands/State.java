package com.StravitZone.Core.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.PluginState;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class State extends SCommand{

	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		
		if(c.getName().equalsIgnoreCase("about")){
			p.sendMessage(ChatManager.success() + " §e§lRunning §6SZCore §e§lversion §6" + Main.getInstance().getDescription().getVersion());
			p.sendMessage(ChatManager.success() + " §e§lCurrent plugin state: " + PluginState.getState());
		}
		
		if(c.getName().equalsIgnoreCase("setstate")){
			if(!p.hasPermission(Rank.admin)){
				s.sendMessage(ChatManager.error_permission()
						+ " You need §c§oADMIN §7to use this command.");
				return true;
			} else {
				if(a.length == 0){
					p.sendMessage(ChatManager.error_general() + " Usage: /setstate <PluginState>");
					return true;
				}
				
				else if(a[0].equalsIgnoreCase("beta")){
					PluginState.setState(PluginState.BETA);
					p.sendMessage(ChatManager.success() + " Plugin state set to §e§oBETA§6.");
				}
				
				else if(a[0].equalsIgnoreCase("alpha")){
					PluginState.setState(PluginState.ALPHA);
					p.sendMessage(ChatManager.success() + " Plugin state set to §e§oALPHA§6.");
				}
				
				else if(a[0].equalsIgnoreCase("release")){
					PluginState.setState(PluginState.RELEASE);
					p.sendMessage(ChatManager.success() + " Plugin state set to §e§oRELEASE§6.");
				}
				
			}
		}
		return false;
	}

}