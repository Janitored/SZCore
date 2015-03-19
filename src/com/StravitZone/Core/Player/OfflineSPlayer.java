package com.StravitZone.Core.Player;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.MuteHandlers;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.RankHandlers;

public class OfflineSPlayer {
	
	private OfflinePlayer p;
	
	public OfflineSPlayer(OfflinePlayer p){
		this.p = p;
	}
	
	public void addCredits(OfflinePlayer p, int amount) {

		Main.getInstance()
				.getConfig()
				.set(p.getName(),
						Integer.valueOf(Main.getInstance().getConfig()
								.getInt(p.getName())
								+ amount));

		Main.getInstance().saveConfig();

	}

	public void removeCredits(OfflinePlayer p, int amount) {

		Main.getInstance()
				.getConfig()
				.set(p.getName(),
						Integer.valueOf(Main.getInstance().getConfig()
								.getInt(p.getName())
								- amount));

		Main.getInstance().saveConfig();

	}

	public int getCredits(OfflinePlayer p) {

		return Main.getInstance().getConfig().getInt(p.getName());

	}


	public static String getRank(OfflinePlayer p) {

		if (((Permissible) p).hasPermission(Rank.admin)) {
			return "§c§lADMIN";
		}

		if (((Permissible) p).hasPermission(Rank.moderator)) {
			return "§9§lMODERATOR";
		}

		if (((Permissible) p).hasPermission(Rank.vip)) {
			return "§6§lVIP";
		}

		if (((Permissible) p).hasPermission(Rank.builder)) {
			return "§a§lBUILDER";
		}

		if (((Permissible) p).hasPermission(Rank.all)) {
			return "§9§lPLAYER";
		}
		return null;

	}

	public static void setRank(OfflinePlayer p, String rank) {

		if (rank == null) {
			
			RankHandlers.admins.remove(p.getName());
			RankHandlers.mods.remove(p.getName());
			RankHandlers.build.remove(p.getName());
			RankHandlers.vip.remove(p.getName());
			RankHandlers.all.add(p.getName());
			Main.getInstance().getConfig().set("Players." + p, RankHandlers.all);
			Main.getInstance().saveConfig();
		}

		if (rank.equalsIgnoreCase("admin")) {
			
			RankHandlers.admins.add(p.getName());
			RankHandlers.mods.remove(p.getName());
			RankHandlers.build.remove(p.getName());
			RankHandlers.vip.remove(p.getName());
			RankHandlers.all.remove(p.getName());
			Main.getInstance().getConfig().set("Admins." + p, RankHandlers.admins);
			Main.getInstance().saveConfig();
			
		}

		if (rank.equalsIgnoreCase("mod")) {
			
			RankHandlers.admins.remove(p.getName());
			RankHandlers.mods.add(p.getName());
			RankHandlers.build.remove(p.getName());
			RankHandlers.vip.remove(p.getName());
			RankHandlers.all.remove(p.getName());
			Main.getInstance().getConfig().set("Mods." + p, RankHandlers.mods);
			Main.getInstance().saveConfig();
			
		}

		if (rank.equalsIgnoreCase("builder")) {
			
			RankHandlers.admins.remove(p.getName());
			RankHandlers.mods.remove(p.getName());
			RankHandlers.build.add(p.getName());
			RankHandlers.vip.remove(p.getName());
			RankHandlers.all.remove(p.getName());
			Main.getInstance().getConfig().set("Builders." + p, RankHandlers.build);
			Main.getInstance().saveConfig();
		}

		if (rank.equalsIgnoreCase("vip")) {
			
			RankHandlers.admins.remove(p.getName());
			RankHandlers.mods.remove(p.getName());
			RankHandlers.build.remove(p.getName());
			RankHandlers.vip.add(p.getName());
			RankHandlers.all.remove(p.getName());
			Main.getInstance().getConfig().set("VIPs." + p, RankHandlers.vip);
			Main.getInstance().saveConfig();
			
		}

		if (rank.equalsIgnoreCase("player")) {
			RankHandlers.admins.remove(p.getName());
			RankHandlers.mods.remove(p.getName());
			RankHandlers.build.remove(p.getName());
			RankHandlers.vip.remove(p.getName());
			RankHandlers.all.add(p.getName());
			Main.getInstance().getConfig().set("Players." + p, RankHandlers.admins);
			Main.getInstance().saveConfig();
		}

	}

	public boolean isMuted(OfflinePlayer p) {
		return MuteHandlers.muted.contains(p.getUniqueId());
	}

	public String getIGN() {
		return p.getName();
	}

	public boolean mute(OfflinePlayer p) {
		return MuteHandlers.muted.add(p.getUniqueId());
	}

	public boolean unmute(OfflinePlayer p) {
		return MuteHandlers.muted.remove(p.getUniqueId());
	}

	public void ban(OfflinePlayer p) {
		p.setBanned(true);
	}

	public void unban(OfflinePlayer p) {
		p.setBanned(false);
	}

}
