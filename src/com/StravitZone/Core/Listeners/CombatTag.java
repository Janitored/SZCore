package com.StravitZone.Core.Listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.Event.PlayerDamageByPlayerEvent;

public class CombatTag implements Listener {

	private int tagtime = 30;

	private int bantime = 60;

	private List<Player> tagged = new ArrayList<>();

	private List<UUID> banned = new ArrayList<>();

	@EventHandler
	public void hit(PlayerDamageByPlayerEvent e) {

		final Player damager = e.getDamager();
		
		if(!(damager instanceof Player)) return;

		final Player damaged = e.getDamaged();

		if (!(damager instanceof Player) && damaged instanceof Player)
			return;

		if (damager instanceof Player && damaged instanceof Player) {
			
			if(!(tagged.contains(damager) && tagged.contains(damaged))){

			tagged.add(damager);
			tagged.add(damaged);
			
			damager.sendMessage(ChatManager.info() + " You are now combat tagged with " + damaged.getName() + ", do /ct to view your combat tag status.");
			
			damaged.sendMessage(ChatManager.info() + damager.getName() + " has combat tagged you! Do /ct to view your combat tag status.");
			
			

			new BukkitRunnable() {
				public void run() {

					tagtime--;

					if (tagtime == 0 && tagged.contains(damager)
							&& tagged.contains(damaged)) {
						damager.sendMessage(ChatManager.success()
								+ " You are no longer combat tagged.");
						damaged.sendMessage(ChatManager.success()
								+ " You are no longer combat tagged.");

						tagged.remove(damager);
						tagged.remove(damaged);

						this.cancel();
						tagtime = 30;
					}

				}
			}.runTaskTimer(Main.getInstance(), 0, 20);

		}
		}

	}

	@EventHandler
	public void quit(final PlayerQuitEvent e) {

		if (tagged.contains(e.getPlayer()) && tagtime > 0) {
			Bukkit.broadcastMessage(ChatManager.announcement()
					+ e.getPlayer().getName()
					+ " has been banned for 1 minute for combat logging!");
			e.getPlayer().setBanned(true);
			banned.add(e.getPlayer().getUniqueId());
			new BukkitRunnable() {
				public void run() {

					bantime--;

					if (bantime == 0
							&& banned.contains(e.getPlayer().getUniqueId())) {
						e.getPlayer().setBanned(false);
						banned.remove(e.getPlayer().getUniqueId());
					}

				}
			}.runTaskTimer(Main.getInstance(), 0, 20);
		}

	}

	@EventHandler
	public void login(PlayerLoginEvent e) {
		if (banned.contains(e.getPlayer().getUniqueId())) {
			e.disallow(
					Result.KICK_BANNED,
					ChatManager.error_general()
							+ " You are §4§nBANNED §c§ofor §4§l1 minute §c§ofor combat logging!");
		} else {
			e.allow();
		}
	}
	
	@EventHandler
	public void command(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/hub")){
			if(tagged.contains(e.getPlayer())){
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatManager.error_general() + " You may not return to hub while combat tagged.");
				return;
			}
		}

	}

}