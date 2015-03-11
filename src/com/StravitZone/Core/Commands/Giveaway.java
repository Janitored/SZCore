package com.StravitZone.Core.Commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Giveaway extends SCommand {

	private int giveaway = 15;

	public boolean onCommand(CommandSender s, Command c, String st, String[] a) {
		final Player p = (Player) s;
		if (c.getName().equalsIgnoreCase("giveaway")) {
			if (!p.hasPermission(Rank.admin)) {
				p.sendMessage(ChatManager.error_permission()
						+ " You need §c§oADMIN §7to use this command.");
				return true;
			}
			
			if(giveaway > 0){
				p.sendMessage(ChatManager.error_general() + " There is giveaway in progress!");
				return true;
			}
			
			p.sendMessage(ChatManager.success() + " Setting up giveaway...");

			new BukkitRunnable() {
				public void run() {

					for (Player pl : Bukkit.getOnlinePlayers()) {

						giveaway--;

						if (giveaway == 13) {

							Bukkit.broadcastMessage(ChatManager.announcement()
									+ p.getName()
									+ " has started a giveaway. Get ready!");

						}

						else if (giveaway == 10) {

							Bukkit.broadcastMessage(ChatManager.announcement()
									+ " Winner will be announced in 10 seconds!");

						}

						else if (giveaway == 5) {

							Bukkit.broadcastMessage(ChatManager.announcement()
									+ " Winner will be announced in 5 seconds!");

						}

						else if (giveaway == 3) {

							Bukkit.broadcastMessage(ChatManager.announcement()
									+ " Winner will be announced in 3 seconds!");

						}

						else if (giveaway == 2) {

							Bukkit.broadcastMessage(ChatManager.announcement()
									+ " Winner will be announced in 2 seconds!");

						}

						else if (giveaway == 1) {

							Bukkit.broadcastMessage(ChatManager.announcement()
									+ " Winner will be announced in 1 second!");

						}

						else if (giveaway == 0) {

							Bukkit.broadcastMessage(ChatManager.announcement()
									+ " The winner of the giveaway is...");

						}

						else if (giveaway == -1) {

						}

						else if (giveaway == -2) {

							Player random = Bukkit.getOnlinePlayers()[new Random()
									.nextInt(Bukkit.getOnlinePlayers().length)];

							Bukkit.broadcastMessage(ChatManager.announcement()
									+ random.getName() + "!");

							pl.playSound(pl.getLocation(), Sound.WITHER_SPAWN,
									1, 1);
							
							this.cancel();
							
							giveaway = 15;

						}

					}
				}
			}.runTaskTimer(Main.getInstance(), 0, 20);

		}
		return false;
	}

}
