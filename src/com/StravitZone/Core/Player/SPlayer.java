package com.StravitZone.Core.Player;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.MuteHandlers;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.SStats;

public class SPlayer {

	private Player p;

	public SPlayer(Player p) {

		this.p = p;

	}

	public void addCredits(Player p, int amount) {

		Main.creditsdata
				.set(p.getName(),
						Integer.valueOf(Main.creditsdata
								.getInt(p.getName())
								+ amount));

		try {
			Main.creditsdata.save(Main.creditsData);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void removeCredits(Player p, int amount) {

		Main.creditsdata
				.set(p.getName(),
						Integer.valueOf(Main.creditsdata
								.getInt(p.getName())
								- amount));

		try {
			Main.creditsdata.save(Main.creditsData);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getCredits(Player p) {

		return Main.creditsdata.getInt(p.getName());

	}

	public String getTeam(Player p) {

		if (PlayerManager.isSpectator(p)) {
			return "§e§oSpectators";
		}

		if (PlayerManager.isTribute(p)) {
			return "§e§oTributes";
		}

		if (PlayerManager.isWaiting(p)) {
			return "§e§oWaiting";
		}

		return null;

	}

	public static String getRank(Player p) {

		if (p.hasPermission(Rank.admin)) {
			return "§c§lADMIN";
		}

		if (p.hasPermission(Rank.moderator)) {
			return "§9§lMODERATOR";
		}

		if (p.hasPermission(Rank.vip)) {
			return "§6§lVIP";
		}

		if (p.hasPermission(Rank.builder)) {
			return "§a§lBUILDER";
		}

		if (p.hasPermission(Rank.all)) {
			return "§9§lPLAYER";
		}
		return null;

	}

	public static void setRank(Player p, String rank) {

		if (rank == null) {
			PermissionAttachment perm = p.addAttachment(Main.getInstance());

			perm.setPermission(Rank.admin, false);
			perm.setPermission(Rank.moderator, false);
			perm.setPermission(Rank.vip, false);
			perm.setPermission(Rank.builder, false);
			perm.setPermission(Rank.all, true);
		}

		if (rank.equalsIgnoreCase("admin")) {
			PermissionAttachment perm = p.addAttachment(Main.getInstance());

			perm.setPermission(Rank.admin, true);
			perm.setPermission(Rank.moderator, false);
			perm.setPermission(Rank.vip, false);
			perm.setPermission(Rank.builder, false);
			perm.setPermission(Rank.all, false);
		}

		if (rank.equalsIgnoreCase("mod")) {
			PermissionAttachment perm = p.addAttachment(Main.getInstance());

			perm.setPermission(Rank.admin, false);
			perm.setPermission(Rank.moderator, true);
			perm.setPermission(Rank.vip, false);
			perm.setPermission(Rank.builder, false);
			perm.setPermission(Rank.all, false);
		}

		if (rank.equalsIgnoreCase("builder")) {
			PermissionAttachment perm = p.addAttachment(Main.getInstance());

			perm.setPermission(Rank.admin, false);
			perm.setPermission(Rank.moderator, false);
			perm.setPermission(Rank.vip, false);
			perm.setPermission(Rank.builder, true);
			perm.setPermission(Rank.all, false);
		}

		if (rank.equalsIgnoreCase("vip")) {
			PermissionAttachment perm = p.addAttachment(Main.getInstance());

			perm.setPermission(Rank.admin, false);
			perm.setPermission(Rank.moderator, false);
			perm.setPermission(Rank.vip, true);
			perm.setPermission(Rank.builder, false);
			perm.setPermission(Rank.all, false);
		}

		if (rank.equalsIgnoreCase("player")) {
			PermissionAttachment perm = p.addAttachment(Main.getInstance());

			perm.setPermission(Rank.admin, false);
			perm.setPermission(Rank.moderator, false);
			perm.setPermission(Rank.vip, false);
			perm.setPermission(Rank.builder, false);
			perm.setPermission(Rank.all, true);
		}

	}

	public static Permission hasRank(Player p, Permission r) {

		return r;

	}

	public boolean isMuted(Player p) {
		return MuteHandlers.onlinemuted.contains(p);
	}

	public boolean isOfflineMuted(OfflinePlayer p) {
		return MuteHandlers.muted.contains(p);
	}

	public void message(Player p, String msg) {
		p.sendMessage(msg);
	}

	public String getIGN() {
		return p.getName();
	}

	public boolean mute(Player p) {
		return MuteHandlers.onlinemuted.add(p);
	}

	public boolean offlineMute(OfflinePlayer p) {
		return MuteHandlers.muted.add(p.getUniqueId());
	}

	public boolean offlineunMute(OfflinePlayer p) {
		return MuteHandlers.muted.remove(p.getUniqueId());
	}

	public boolean unmute(Player p) {
		return MuteHandlers.onlinemuted.remove(p);
	}

	public void ban(Player p, String reason) {
		p.kickPlayer(reason);
		p.setBanned(true);
	}

	public void unban(Player p) {
		p.setBanned(false);
	}

	public void kick(Player p, String reason) {
		p.kickPlayer(reason);
	}

	public void showStatBoard(Player p) {
		
		SPlayer pl = new SPlayer(p);

		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard statboard = manager.getNewScoreboard();
		
		Objective obj = statboard.registerNewObjective("StravitZone",
				"dummy");

		Score kill = obj.getScore("§a§lKills: ");
		kill.setScore(SStats.getKills(p.getName()));
		
		obj.setDisplayName("§6§lSZ §7- §bYour Stats");
		
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score death = obj.getScore("§4§lDeaths: ");
		
		death.setScore(SStats.getDeaths(p.getName()));
		
		Score credits = obj.getScore("§9§lCredits: ");
		
		credits.setScore(pl.getCredits(p));
		
		p.setScoreboard(statboard);
		
		

	}
}