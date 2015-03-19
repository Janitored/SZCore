package com.StravitZone.Core.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.SCommand;

public class Game extends SCommand {

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		Player p = (Player) s;
		if (c.getName().equalsIgnoreCase("game")) {
			p.sendMessage("§6§l>> §e§lRunning §6§l"
					+ Main.getInstance().getDescription().getName()
					+ " §e§lbuild §6§l"
					+ Main.getInstance().getDescription().getVersion()
					+ "§e§l.");
			p.sendMessage("§6§l>> §e§lDeveloped by §6§lJanitored§e§l.");
		}
		return false;
	}

}