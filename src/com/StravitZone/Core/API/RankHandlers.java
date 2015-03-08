package com.StravitZone.Core.API;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

import com.StravitZone.Core.Main;

public class RankHandlers implements Listener {

	private List<UUID> admin = new ArrayList<>();
	private List<UUID> mod = new ArrayList<>();
	private List<UUID> builder = new ArrayList<>();
	private List<UUID> vip = new ArrayList<>();
	private List<UUID> all = new ArrayList<>();

	@EventHandler
	public void leave(PlayerQuitEvent e) {

		Player p = e.getPlayer();

		if (p.hasPermission(Rank.admin)) {
			admin.add(p.getUniqueId());
		}

		if (p.hasPermission(Rank.moderator)) {
			mod.add(p.getUniqueId());
		}

		if (p.hasPermission(Rank.builder)) {
			builder.add(p.getUniqueId());
		}

		if (p.hasPermission(Rank.vip)) {
			vip.add(p.getUniqueId());
		}

		if (p.hasPermission(Rank.all)) {
			all.add(p.getUniqueId());
		}

	}

	@EventHandler
	public void join(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		PermissionAttachment perm = p.addAttachment(Main.getInstance());

		if (admin.contains(p.getUniqueId())) {
			perm.setPermission(Rank.admin, true);
		}

		if (mod.contains(p.getUniqueId())) {
			perm.setPermission(Rank.moderator, true);
		}

		if (builder.contains(p.getUniqueId())) {
			perm.setPermission(Rank.builder, true);
		}

		if (vip.contains(p.getUniqueId())) {
			perm.setPermission(Rank.vip, true);
		}

		if (all.contains(p.getUniqueId())) {
			perm.setPermission(Rank.all, true);
		}
		
		if(p.isOp()){
			perm.setPermission(Rank.admin, true);
		}

	}

}
