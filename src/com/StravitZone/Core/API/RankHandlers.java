package com.StravitZone.Core.API;

import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.Player.SPlayer;

public class RankHandlers implements Listener {

	public static FileConfiguration rankdata;

	public static List<String> admins = Main.rankdata.getStringList("Admins.");
	public static List<String> mods = Main.rankdata.getStringList("Mods.");
	public static List<String> build = Main.rankdata.getStringList("Builders.");
	public static List<String> vip = Main.rankdata.getStringList("VIPs.");
	public static List<String> all = Main.rankdata.getStringList("Players.");

	@EventHandler
	public void leave(PlayerQuitEvent e) {

		if (e.getPlayer().hasPermission(Rank.admin)) {

			if (!admins.contains(e.getPlayer().getName())) {
				admins.add(e.getPlayer().getName());
				mods.remove(e.getPlayer().getName());
				build.remove(e.getPlayer().getName());
				vip.remove(e.getPlayer().getName());
				all.remove(e.getPlayer().getName());
				Main.rankdata.set("Admins." + e.getPlayer(), admins);
				try {
					Main.rankdata.save(Main.rankData);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		if (e.getPlayer().hasPermission(Rank.moderator)) {
			if (!mods.contains(e.getPlayer().getName())) {
				mods.add(e.getPlayer().getName());
				admins.remove(e.getPlayer().getName());
				build.remove(e.getPlayer().getName());
				vip.remove(e.getPlayer().getName());
				all.remove(e.getPlayer().getName());
				Main.rankdata
						.set("Mods." + e.getPlayer(), mods);
				try {
					Main.rankdata.save(Main.rankData);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		if (e.getPlayer().hasPermission(Rank.builder)) {
			if (!build.contains(e.getPlayer().getName())) {
				build.add(e.getPlayer().getName());
				admins.remove(e.getPlayer().getName());
				mods.remove(e.getPlayer().getName());
				vip.remove(e.getPlayer().getName());
				all.remove(e.getPlayer().getName());
				Main.rankdata
						.set("Builders." + e.getPlayer(), build);
				try {
					Main.rankdata.save(Main.rankData);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		if (e.getPlayer().hasPermission(Rank.vip)) {
			if (!vip.contains(e.getPlayer().getName())) {
				vip.add(e.getPlayer().getName());
				admins.remove(e.getPlayer().getName());
				mods.remove(e.getPlayer().getName());
				build.remove(e.getPlayer().getName());
				all.remove(e.getPlayer().getName());
				Main.rankdata
						.set("VIPs." + e.getPlayer(), vip);
				try {
					Main.rankdata.save(Main.rankData);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
		}

		if (e.getPlayer().hasPermission(Rank.all)) {
			if (!all.contains(e.getPlayer().getName())) {
				all.add(e.getPlayer().getName());
				admins.remove(e.getPlayer().getName());
				mods.remove(e.getPlayer().getName());
				build.remove(e.getPlayer().getName());
				vip.remove(e.getPlayer().getName());
				Main.rankdata
						.set("Players." + e.getPlayer(), all);
				try {
					Main.rankdata.save(Main.rankData);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

	}

	@SuppressWarnings("static-access")
	@EventHandler
	public void join(PlayerJoinEvent e) {

		SPlayer p = new SPlayer(e.getPlayer());

		if (e.getPlayer().hasPermission(Rank.all) &&  e.getPlayer().isOp() && admins.contains(e.getPlayer().getName())) {
			p.setRank(e.getPlayer(), "admin");
		}

		if (e.getPlayer().hasPermission(Rank.all) && mods.contains(e.getPlayer().getName())) {
			p.setRank(e.getPlayer(), "mod");
		}

		if (e.getPlayer().hasPermission(Rank.all) && mods.contains(e.getPlayer().getName())) {
			p.setRank(e.getPlayer(), "builder");
		}

		if (e.getPlayer().hasPermission(Rank.all) && vip.contains(e.getPlayer().getName())) {
			p.setRank(e.getPlayer(), "vip");
		}

		if (e.getPlayer().hasPermission(Rank.all) && all.contains(e.getPlayer().getName())) {
			p.setRank(e.getPlayer(), "player");
		}

	}

}
