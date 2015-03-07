package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SCommand;

public class Commandrank extends SCommand {

	public boolean onCommand(CommandSender s, Command c, String label,
			String[] args) {
		if (s instanceof Player || (!(s instanceof Player))) {

			if (c.getName().equalsIgnoreCase("rank")) {
				if (!s.hasPermission(Rank.admin)) {
					s.sendMessage(ChatManager.error_permission()
							+ " You need §c§oADMIN §7to use this command.");
				} else {
					if (args.length == 0) {
						s.sendMessage(ChatManager.error_general()
								+ " Usage: /rank <User> <Rank>");
					}

					else if (args.length == 1) {
						Player target = Bukkit.getPlayer(args[0]);
						if(target == null){

							s.sendMessage(ChatManager.error_general() + " The specified player cannot be found!");
							return true;
						}
						s.sendMessage(ChatManager.error_general()
								+ " Please specify a rank!");
					}

					else if (args[1].equalsIgnoreCase("admin")) {
						Player target = Bukkit.getPlayer(args[0]);
						s.sendMessage(ChatManager.success() + " Set §e§o"
								+ target.getName()
								+ "§6§l's rank to §c§oADMIN§6§l.");
						PermissionAttachment perm = target.addAttachment(Main
								.getInstance());
						perm.setPermission(Rank.admin, true);
						perm.setPermission(Rank.moderator, false);
						perm.setPermission(Rank.vip, false);
						perm.setPermission(Rank.builder, false);
						perm.setPermission(Rank.all, false);

						target.sendMessage(ChatManager.success()
								+ "Your rank has been set to §c§oADMIN§6§l.");
					}

					else if (args[1].equalsIgnoreCase("mod")) {
						Player target = Bukkit.getPlayer(args[0]);
						s.sendMessage(ChatManager.success() + " Set §e§o"
								+ target.getName()
								+ "§6§l's rank to §9§oMODERATOR§6§l.");
						PermissionAttachment perm = target.addAttachment(Main
								.getInstance());
						perm.setPermission(Rank.admin, false);
						perm.setPermission(Rank.moderator, true);
						perm.setPermission(Rank.vip, false);
						perm.setPermission(Rank.builder, false);
						perm.setPermission(Rank.all, false);
						target.sendMessage(ChatManager.success()
								+ "Your rank has been set to §9§oMODERATOR§6§l.");
					}

					else if (args[1].equalsIgnoreCase("vip")) {
						Player target = Bukkit.getPlayer(args[0]);
						s.sendMessage(ChatManager.success() + " Set §e§o"
								+ target.getName()
								+ "§6§l's rank to §6§oVIP§6§l.");
						PermissionAttachment perm = target.addAttachment(Main
								.getInstance());
						perm.setPermission(Rank.admin, false);
						perm.setPermission(Rank.moderator, false);
						perm.setPermission(Rank.vip, true);
						perm.setPermission(Rank.builder, false);
						perm.setPermission(Rank.all, false);

						target.sendMessage(ChatManager.success()
								+ "Your rank has been set to §6§oVIP§6§l.");
					}

					else if (args[1].equalsIgnoreCase("builder")) {
						Player target = Bukkit.getPlayer(args[0]);
						s.sendMessage(ChatManager.success() + " Set §e§o"
								+ target.getName()
								+ "§6§l's rank to §a§oBUILDER§6§l.");
						PermissionAttachment perm = target.addAttachment(Main
								.getInstance());
						perm.setPermission(Rank.admin, false);
						perm.setPermission(Rank.moderator, false);
						perm.setPermission(Rank.vip, false);
						perm.setPermission(Rank.builder, true);
						perm.setPermission(Rank.all, false);

						target.sendMessage(ChatManager.success()
								+ "Your rank has been set to §a§oBUILDER§6§l.");
					}

					else if (args[1].equalsIgnoreCase("player")) {
						Player target = Bukkit.getPlayer(args[0]);
						s.sendMessage(ChatManager.success() + " Set §e§o"
								+ target.getName()
								+ "§6§l's rank to §7§oPLAYER§6§l.");
						PermissionAttachment perm = target.addAttachment(Main
								.getInstance());
						perm.setPermission(Rank.admin, false);
						perm.setPermission(Rank.moderator, false);
						perm.setPermission(Rank.vip, false);
						perm.setPermission(Rank.builder, false);
						perm.setPermission(Rank.all, true);

						target.sendMessage(ChatManager.success()
								+ "Your rank has been set to §7§oPLAYER§6§l.");
					}

					else if (args[1] != "admin" || args[1] != "mod"
							|| args[1] != "builder" || args[1] != "player"
							|| args[1] != "vip") {

						s.sendMessage(ChatManager.error_general()
								+ " That rank does not exist!");
					}
				}

				return false;
			}

		}
		return false;
	}
}