package com.StravitZone.Core.API;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class StravitCommand implements CommandExecutor{
	
	public abstract boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);

}
