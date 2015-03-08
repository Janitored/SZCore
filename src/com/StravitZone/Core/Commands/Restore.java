package com.StravitZone.Core.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Restore extends SCommand{
	
	public boolean onCommand(CommandSender s, Command c, String st, String[] a){
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("restore")){
			PermissionAttachment perm = p.addAttachment(Main
					.getInstance());
			if(!(p.hasPermission(Rank.admin) || p.isOp())){
				p.sendMessage(ChatManager.error_permission()
						+ " You need §c§oADMIN §7to use this command.");
			} else if(!p.hasPermission(Rank.admin) && p.isOp()){
				p.sendMessage(ChatManager.success() + " Admin rank restored.");
				perm.setPermission(Rank.admin, true);
			}
		}
		return false;
	}

}
