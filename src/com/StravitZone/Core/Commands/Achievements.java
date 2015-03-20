package com.StravitZone.Core.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.AchievementManager;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.SCommand;

public class Achievements extends SCommand{

	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("achievements")){
			p.sendMessage(ChatManager.info() + " Achievements:");
			p.sendMessage(ChatManager.info() + " Newcomer: Join the server for the first time");
			if(AchievementManager.completedNewcomer(p)){
				p.sendMessage(ChatManager.info() + " Status: §a§lCOMPLETED");
			} else {
				p.sendMessage(ChatManager.info() + " Status: §4§lNOT COMPLETED");
			}
			p.sendMessage(ChatManager.info() + " First Kill: Kill your first victim!");
			if(AchievementManager.completedfirstKill(p)){
				p.sendMessage(ChatManager.info() + " Status: §a§lCOMPLETED");
			} else {
				p.sendMessage(ChatManager.info() + " Status: §4§lNOT COMPLETED");
			}
			p.sendMessage(ChatManager.info() + " First Death: Die for the first time!");
			if(AchievementManager.completedfirstDeath(p)){
				p.sendMessage(ChatManager.info() + " Status: §a§lCOMPLETED");
			} else {
				p.sendMessage(ChatManager.info() + " Status: §4§lNOT COMPLETED");
			}
			
		}
		return false;
	}

}