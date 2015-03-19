package com.StravitZone.Core.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.RankHandlers;
import com.StravitZone.Core.API.SCommand;
import com.StravitZone.Core.Player.OfflineSPlayer;
import com.StravitZone.Core.Player.SPlayer;

public class Commandrank extends SCommand {

	@SuppressWarnings("static-access")
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
						s.sendMessage(ChatManager.error_general()
								+ " Please specify a rank!");
					}

					else if (args[1].equalsIgnoreCase("admin")) {
						Player target = Bukkit.getPlayer(args[0]);
						OfflinePlayer tt = Bukkit.getOfflinePlayer(args[0]);
						if(tt.isOnline()){
						SPlayer t = new SPlayer(target);
						s.sendMessage(ChatManager.success() + " Set §e§o" + target.getName() + "§6§l's rank to §c§oADMIN§6§l.");
						t.setRank(target, "admin");
						target.sendMessage(ChatManager.success()
								+ "Your rank has been set to §c§oADMIN§6§l.");
						target.setOp(true);
						}
						
						else if(!(tt.isOnline())){
							OfflineSPlayer ttt = new OfflineSPlayer(tt);
							
							s.sendMessage(ChatManager.success() + " Set §e§o" + tt.getName() + "§6§l's rank to §c§oADMIN§6§l.");
							
							ttt.setRank(tt, "admin");
							tt.setOp(true);
						}
						
					}

					else if (args[1].equalsIgnoreCase("mod")) {
						Player target = Bukkit.getPlayer(args[0]);
						OfflinePlayer tt = Bukkit.getOfflinePlayer(args[0]);
						s.sendMessage(ChatManager.success() + " Set §e§o"
								+ target.getName()
								+ "§6§l's rank to §9§oMODERATOR§6§l.");
						SPlayer t = new SPlayer(target);
						t.setRank(target, "mod");
						target.sendMessage(ChatManager.success()
								+ "Your rank has been set to §9§oMODERATOR§6§l.");
						target.setOp(false);
						
						if(tt.isOnline()){
							s.sendMessage(ChatManager.success() + " Set §e§o"
									+ target.getName()
									+ "§6§l's rank to §9§oMODERATOR§6§l.");
							RankHandlers.mods.add(t.getIGN());
							Main.getInstance().getConfig().set("Mods." + target, RankHandlers.mods);
							target.setOp(false);
						}
						
						else if(!(tt.isOnline())){
							OfflineSPlayer ttt = new OfflineSPlayer(tt);
							
							s.sendMessage(ChatManager.success() + " Set §e§o"
									+ tt.getName()
									+ "§6§l's rank to §9§oMODERATOR§6§l.");
							
							ttt.setRank(tt, "mod");
							tt.setOp(false);
						}
						
					}

					else if (args[1].equalsIgnoreCase("vip")) {
						Player target = Bukkit.getPlayer(args[0]);
						OfflinePlayer tt = Bukkit.getOfflinePlayer(args[0]);
						SPlayer t = new SPlayer(target);
						if(tt.isOnline()){
						s.sendMessage(ChatManager.success() + " Set §e§o"
								+ target.getName()
								+ "§6§l's rank to §6§oVIP§6§l.");
						t.setRank(target, "vip");

						target.sendMessage(ChatManager.success()
								+ "Your rank has been set to §6§oVIP§6§l.");
						target.setOp(false);
						}
						
						else if(!(tt.isOnline())){
							OfflineSPlayer ttt = new OfflineSPlayer(tt);
							
							s.sendMessage(ChatManager.success() + " Set §e§o"
									+ tt.getName()
									+ "§6§l's rank to §6§oVIP§6§l.");
							
							ttt.setRank(tt, "vip");
							tt.setOp(false);
						}
						
					}

					else if (args[1].equalsIgnoreCase("builder")) {
						Player target = Bukkit.getPlayer(args[0]);
						SPlayer t = new SPlayer(target);
						OfflinePlayer tt = Bukkit.getOfflinePlayer(args[0]);
						
						if(tt.isOnline()){
							s.sendMessage(ChatManager.success() + " Set §e§o"
									+ target.getName()
									+ "§6§l's rank to §a§oBUILDER§6§l.");
							t.setRank(target, "builder");
							target.setOp(false);
						}
						
						else if(!(tt.isOnline())){
							OfflineSPlayer ttt = new OfflineSPlayer(tt);
							
							s.sendMessage(ChatManager.success() + " Set §e§o"
									+ tt.getName()
									+ "§6§l's rank to §a§oBUILDER§6§l.");
							
							ttt.setRank(tt, "builder");
							tt.setOp(false);
						}
						
					}

					else if (args[1].equalsIgnoreCase("player")) {
						Player target = Bukkit.getPlayer(args[0]);
						OfflinePlayer tt = Bukkit.getOfflinePlayer(args[0]);
						SPlayer t = new SPlayer(target);
						
						
						
						if(tt.isOnline()){
						s.sendMessage(ChatManager.success() + " Set §e§o"
								+ target.getName()
								+ "§6§l's rank to §7§oPLAYER§6§l.");
						t.setRank(target, "player");

						target.sendMessage(ChatManager.success()
								+ "Your rank has been set to §7§oPLAYER§6§l.");
						target.setOp(false);
						
						}
						
						else if(!(tt.isOnline())){
							
							
							OfflineSPlayer ttt = new OfflineSPlayer(tt);
							
							s.sendMessage(ChatManager.success() + " Set §e§o"
									+ tt.getName()
									+ "§6§l's rank to §7§oPLAYER§6§l.");
							
							ttt.setRank(tt, "player");
							tt.setOp(false);
						}
						
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