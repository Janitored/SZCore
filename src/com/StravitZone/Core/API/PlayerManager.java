package com.StravitZone.Core.API;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.Item.ItemStackFactory;

public class PlayerManager implements Listener {

	private static List<Player> specs = new ArrayList<>();
	private static List<Player> tributes = new ArrayList<>();
	private static List<Player> waiting = new ArrayList<>();

	@EventHandler
	public void interact(PlayerInteractEvent e) {

		if (isSpectator(e.getPlayer())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void interact(BlockBreakEvent e) {

		if (isSpectator(e.getPlayer())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void interact(EntityDamageByEntityEvent e) {

		if (isSpectator((Player)e.getDamager())) {
			e.setCancelled(true);
		}

		if (isSpectator((Player)e.getEntity())
				&& isTribute((Player)e.getDamager())) {
			e.setCancelled(true);

		}

	}

	@EventHandler
	public void command(PlayerCommandPreprocessEvent e) {
		if (isSpectator(e.getPlayer())) {
			e.setCancelled(true);
		}

		if (e.getMessage().equalsIgnoreCase("/team")) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void damage(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();

			if (isSpectator(p)) {
				e.setCancelled(true);
			}

			if (isWaiting(p)) {
				e.setCancelled(true);
			}
		}

	static Location hub = new Location(Bukkit.getWorld("world"), 100, 100, 100);

	public static void setSpectator(final Player player) {

		player.sendMessage(ChatManager.success()
				+ " You are now in §e§oSpectator §6mode.");
		
		specs.add(player);

		tributes.remove(player);

		waiting.remove(player);

		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
				100000, 100000));

		player.setGameMode(GameMode.SURVIVAL);

		player.setHealth(20.0);

		player.setAllowFlight(true);
		player.setFlying(true);
		
		new BukkitRunnable(){
			int i = 10;
			public void run(){
				i--;
				if(i == 3){
					player.sendMessage(ChatManager.info() + " You will return to hub in 3 seconds..");
					player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
				}
				
				if(i == 2){
					player.sendMessage(ChatManager.info() + " You will return to hub in 2 seconds..");
					player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
				}
				
				if(i == 1){
					player.sendMessage(ChatManager.info() + " You will return to hub in 1 second..");
					player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
				}
				
				if(i == 0){
					player.teleport(hub);
					setTribute(player);
				}
			}
		}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

	}

	public static void setTribute(Player player) {

		player.sendMessage(ChatManager.success()
				+ " You are now in §e§oTribute §6mode.");

		specs.remove(player);

		waiting.remove(player);

		tributes.add(player);

		player.removePotionEffect(PotionEffectType.INVISIBILITY);

		player.setGameMode(GameMode.SURVIVAL);

		player.setAllowFlight(false);
		player.setFlying(false);

	}

	public static void setWaiting(Player player) {

		player.sendMessage(ChatManager.success()
				+ " You are now in §e§oWaiting §6mode.");

		specs.remove(player);
		tributes.remove(player);

		waiting.add(player);

		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
				100000, 100000));

		player.setAllowFlight(false);
		player.setFlying(false);
	}

	public static boolean isSpectator(Player p) {

		return specs.contains(p);

	}

	public static boolean isTribute(Player p) {

		return tributes.contains(p);

	}

	public static boolean isWaiting(Player p) {

		return waiting.contains(p);
	}

}
