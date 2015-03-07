package com.StravitZone.Core.API;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class SCommand implements CommandExecutor{
	
	public abstract boolean onCommand(CommandSender s, Command c, String st, String[] a);

}
