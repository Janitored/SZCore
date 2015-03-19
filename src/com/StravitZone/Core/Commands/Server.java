package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.API.ServerManager;

public class Server extends SCommand {

	int stoptime = 183;

	Location hub = new Location(Bukkit.getWorld("world"), 100, 100, 100);

	public boolean onCommand(CommandSender s, Command c, String st,
			final String[] a) {
		final Player p = (Player) s;
		if (c.getName().equalsIgnoreCase("server")) {
			if (!p.hasPermission(Rank.admin)) {
				p.sendMessage(ChatManager.error_permission()
						+ " You need §c§oADMIN §7to use this command.");
				return true;
			}

			if (a.length == 0) {
				p.sendMessage(ChatManager.error_general()
						+ " Usage: /server <stop/shutdown/reload/restart/lock>");
				return true;
			}

			else if (a[0].equalsIgnoreCase("stop") && a.length == 1) {
				if (stoptime < 183) {
					p.sendMessage(ChatManager.error_general()
							+ " The server is already queued for shutdown!");
					return true;
				}
				new BukkitRunnable() {
					public void run() {

						stoptime--;

						if (stoptime == 180) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 3 minutes!");
						}

						else if (stoptime == 120) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 2 minutes!");
						}

						else if (stoptime == 60) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 1 minute!");
						}

						else if (stoptime == 50) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 50 seconds!");
						}

						else if (stoptime == 40) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 40 seconds!");
						}

						else if (stoptime == 30) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 30 seconds!");
						}

						else if (stoptime == 20) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 20 seconds!");
						}

						else if (stoptime == 10) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 10 seconds!");
						}

						else if (stoptime == 5) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 5 seconds!");
						}

						else if (stoptime == 3) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 3 seconds!");
						}

						else if (stoptime == 2) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 2 seconds!");
						}

						else if (stoptime == 1) {
							Bukkit.broadcastMessage(ChatManager.info()
									+ " The server will be shutting down in 1 second!");
						}

						else if (stoptime == 0) {
							Bukkit.shutdown();
						}

					}
				}.runTaskTimer(Main.getInstance(), 0, 20);
			}

			else if (a[0].equalsIgnoreCase("shutdown")) {
				Bukkit.shutdown();
			}

			else if (a[0].equalsIgnoreCase("reload")) {
				for (Player pl : Bukkit.getOnlinePlayers()) {
					Bukkit.broadcastMessage(ChatManager.info()
							+ " The server is now reloading, this is NOT lag. All player have been sent to the hub.");
					pl.teleport(hub);
					Bukkit.reload();
				}

			}

			else if (a[0].equalsIgnoreCase("restart")) {
				ServerManager.restart();
			}

			else if (a[0].equalsIgnoreCase("lock")) {
				for (Player plr : Bukkit.getOnlinePlayers()) {
					if (!ServerManager.isLocked()) {
						ServerManager.lockServer();
						p.sendMessage(ChatManager.success()
								+ " The server is now locked. Type /server lock to unlock, or /lock to edit lockdown credentials.");
						if (!plr.hasPermission(Rank.admin)) {
							plr.kickPlayer(ChatManager.error_general()
									+ " StravitZone has been put on lockdown mode!");
						}
						return true;

					}

					else if (ServerManager.isLocked()) {
						ServerManager.unlockServer();
						p.sendMessage(ChatManager.success()
								+ " The server is now unlocked.");
					}
				}

			}
			return false;
		}
		return false;

	}
}
