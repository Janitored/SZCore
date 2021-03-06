package com.StravitZone.Core.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.API.Tutorial;

public class Tut extends SCommand{
	
	public static List<Player> one = new ArrayList<Player>();
	
	public static List<Player> tutFinished = new ArrayList<>();
	
	public static List<UUID> tutFinishedOff = new ArrayList<>();


	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("tutorial")){
			
			if(tutFinished.contains(p)){
				p.sendMessage(ChatManager.error_general() + " You have already finished the tutorial!");
				return true;
			}
			
			if(!one.contains(p) && !Tutorial.inTut.contains(p)){
			p.sendMessage(ChatManager.success() + " Are you sure? Type /tutorial again to confirm.");
			one.add(p);
			return true;
			} 
			if(one.contains(p)){
				one.remove(p);
				Tutorial.activate(p);
				return true;
			} 
			if(Tutorial.inTut.contains(p) && !one.contains(p)){
				p.sendMessage(ChatManager.error_general() + " You are already in the tutorial!");
				return true;
			}
			
			if(Tutorial.inTut.size() == 1 && !Tutorial.inTut.contains(p) && one.contains(p) && !tutFinished.contains(p)){
				p.sendMessage(ChatManager.error_general() + " Tutorials can handle one player at a time, please standby.");
				return true;
			}
			
		}
		return false;
	}
	
	

}
