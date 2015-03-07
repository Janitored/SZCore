package com.StravitZone.Core.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.GUIs.OCNGames;

public class OCNInvClick implements Listener {

	int ocntimediamond = 8;
	int ocntimegold = 8;
	int ocntimeiron = 8;
	int ocntimechain = 8;
	int ocntimeleather = 8;

	Location ocnwait = new Location(Bukkit.getWorld("world"), 100, 100, 100);
	Location ocnfightdiamond = new Location(Bukkit.getWorld("world"), 100, 100,
			100);
	Location ocnfightgold = new Location(Bukkit.getWorld("world"), 100, 100,
			100);
	Location ocnfightiron = new Location(Bukkit.getWorld("world"), 100, 100,
			100);
	Location ocnfightchain = new Location(Bukkit.getWorld("world"), 100, 100,
			100);
	Location ocnfightleather = new Location(Bukkit.getWorld("world"), 100, 100,
			100);

	@EventHandler
	public void click(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		Inventory inventory = e.getInventory();

		if (inventory.getName().equals(OCNGames.OCN.getName())) {
			
			if(clicked == null) return;

			switch (clicked.getType()) {

			case DIAMOND_HELMET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					public void run() {
						ocntimediamond--;
						if (ocntimediamond == 6) {
							player.teleport(ocnwait);
						}

						else if (ocntimediamond == 5 || ocntimediamond == 4
								|| ocntimediamond == 3 || ocntimediamond == 2
								|| ocntimediamond == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ ocntimediamond + " §a§lsecond(s)");
						}

						else if (ocntimediamond == 0) {
							player.teleport(ocnfightdiamond);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							this.cancel();
							ocntimediamond = 8;
						}
					}
				}.runTaskTimer(Main.getInstance(), 0, 20);

				break;

			case GOLD_HELMET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					public void run() {
						ocntimegold--;
						if (ocntimegold == 6) {
							player.teleport(ocnwait);
						}

						else if (ocntimegold == 5 || ocntimegold == 4
								|| ocntimegold == 3 || ocntimegold == 2
								|| ocntimegold == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ ocntimegold + " §a§lsecond(s)");
						}

						else if (ocntimegold == 0) {
							player.teleport(ocnfightgold);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							this.cancel();
							ocntimegold = 8;
						}
					}
				}.runTaskTimer(Main.getInstance(), 0, 20);

				break;

			case IRON_HELMET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					public void run() {
						ocntimeiron--;
						if (ocntimeiron == 6) {
							player.teleport(ocnwait);
						}

						else if (ocntimeiron == 5 || ocntimeiron == 4
								|| ocntimeiron == 3 || ocntimeiron == 2
								|| ocntimeiron == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ ocntimeiron + " §a§lsecond(s)");
						}

						else if (ocntimeiron == 0) {
							player.teleport(ocnfightiron);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							this.cancel();
							ocntimeiron = 8;
						}
					}
				}.runTaskTimer(Main.getInstance(), 0, 20);

				break;

			case CHAINMAIL_HELMET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					public void run() {
						ocntimechain--;
						if (ocntimechain == 6) {
							player.teleport(ocnwait);
						}

						else if (ocntimechain == 5 || ocntimechain == 4
								|| ocntimechain == 3 || ocntimechain == 2
								|| ocntimechain == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ ocntimechain + " §a§lsecond(s)");
						}

						else if (ocntimechain == 0) {
							player.teleport(ocnfightchain);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							this.cancel();
							ocntimechain = 8;
						}
					}
				}.runTaskTimer(Main.getInstance(), 0, 20);

				break;

			case LEATHER_HELMET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					public void run() {
						ocntimeleather--;
						if (ocntimeleather == 6) {
							player.teleport(ocnwait);
						}

						else if (ocntimeleather == 5 || ocntimeleather == 4
								|| ocntimeleather == 3 || ocntimeleather == 2
								|| ocntimeleather == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ ocntimeleather + " §a§lsecond(s)");
						}

						else if (ocntimeleather == 0) {
							player.teleport(ocnfightleather);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							this.cancel();
							ocntimeleather = 8;
						}
					}
				}.runTaskTimer(Main.getInstance(), 0, 20);

				break;

			}

		}
	}

}