package com.StravitZone.Core.Listeners;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.CreditManager;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.SStats;
import com.StravitZone.Core.Player.SPlayer;

public class Death implements Listener {

	@EventHandler
	public void death(PlayerDeathEvent e) {

		e.getDrops().clear();

		e.setKeepLevel(false);

		e.setDroppedExp(0);

		Player killed = (Player) e.getEntity();

		Player killer = killed.getKiller();
		
		

		if (killed instanceof Player && killer instanceof Player) {
			
			PlayerManager.setSpectator(killed);

			SPlayer sp = new SPlayer(killer);

			killer.sendMessage(ChatManager.info() + " +"
					+ CreditManager.getValue() + " credits!");

			sp.addCredits(killer, CreditManager.getValue());

			SStats.addKill(killer);
			SStats.addDeath(killed);
			
			sp.showStatBoard(killer);
			sp.showStatBoard(killed);
			
			if(SStats.getKills(killer) == 1){
				sp.unlockAchievement(killer, "firstkill");
			}
			
			if(SStats.getDeaths(killed) == 1){
				sp.unlockAchievement(killed, "firstdeath");
			}

			return;
		}

		for (Player p : Bukkit.getOnlinePlayers()) {

			p.playSound(p.getLocation(), Sound.WITHER_SPAWN, 1, 1);

			if (killer instanceof Player && killer.getItemInHand() != null) {
				switch (killer.getItemInHand().getType()) {
				case DIAMOND_SWORD:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cwas slain by §9" + killer.getName()
							+ " §cusing a §9diamond sword!");
					break;

				case WOOD_SWORD:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cwas slain by §9" + killer.getName()
							+ " §cusing a §9wood sword!");
					break;

				case GOLD_SWORD:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cwas slain by §9" + killer.getName()
							+ " §cusing a §9gold sword!");
					break;

				case IRON_SWORD:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cwas slain by §9" + killer.getName()
							+ " §cusing an §9iron sword!");
					break;

				case STONE_SWORD:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cwas slain by §9" + killer.getName()
							+ " §cusing a §9stone sword!");
					break;
				case AIR:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cwas slain by §9" + killer.getName()
							+ " §cusing §9their fists!");
					break;

				default:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cwas slain by §9" + killer.getName() + "!");
					break;
				}
			}

			if (killed instanceof Player) {

				switch (killed.getLastDamageCause().getCause()) {

				case FALL:

					DecimalFormat format = new DecimalFormat("##");

					String blocksFell = format
							.format(killed.getFallDistance() / 2);

					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cfell §9(§c" + blocksFell + " §9blocks)!");
					PlayerManager.setSpectator(killed);
					break;

				case THORNS:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cwas pricked to death§9!");
					PlayerManager.setSpectator(killed);
					break;

				case LAVA:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §ctook a dip in lava");
					PlayerManager.setSpectator(killed);
					break;

				case DROWNING:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §crealized they weren't a fish");
					PlayerManager.setSpectator(killed);
					break;

				case VOID:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cforgot what's underneath bedrock");
					PlayerManager.setSpectator(killed);
					break;

				case PROJECTILE:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cwas projectiled to death!");
					PlayerManager.setSpectator(killed);
					break;

				case MAGIC:
					e.setDeathMessage("§4§l>> §9" + killed.getName()
							+ " §cwas murdered via the dark arts");
					PlayerManager.setSpectator(killed);
					break;

				}
			}

			// Killstreaks

			if (killed.getLevel() >= 5) {
				Bukkit.broadcastMessage(ChatManager.info() + killer.getName()
						+ " ended " + killed.getName() + "'s "
						+ killed.getLevel() + " killstreak!");
				killed.setLevel(0);
				return;
			}

			killed.setLevel(0);

			if (killer instanceof Player) {

				killer.setLevel(killer.getLevel() + 1);
		}

				else if (killer.getLevel() == 3 && killer instanceof Player) {
					Bukkit.broadcastMessage(ChatManager.info()
							+ killer.getName()
							+ " got a §4§lTRIPLE KILL! §b(3 kills)");
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 1);
				}

				else if (killer.getLevel() == 5 && killer instanceof Player) {
					Bukkit.broadcastMessage(ChatManager.info()
							+ killer.getName()
							+ " got a §4§lMONSTER KILL! §b(5 kills)");
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 2);
				}

				else if (killer.getLevel() == 7 && killer instanceof Player) {
					Bukkit.broadcastMessage(ChatManager.info()
							+ killer.getName()
							+ " got a §4§lMEGA KILL! §b(7 kills)");
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 3);
				}

				else if (killer.getLevel() == 10 && killer instanceof Player) {
					Bukkit.broadcastMessage(ChatManager.info()
							+ killer.getName()
							+ " got a §4§lGODLIKE KILL! §b(10 kills)");
					p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 1, 4);
				}
			}
		}
	}
