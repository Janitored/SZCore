package com.StravitZone.Core.Game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.Tutorial;
import com.StravitZone.Core.GUI.OCNGames;

public class OCN implements Listener {

	private void diamondgear(Player player) {
		player.getInventory().clear();
		player.getInventory().addItem(ocndiamondgear);
		player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
		player.getInventory().setChestplate(
				new ItemStack(Material.DIAMOND_CHESTPLATE));
		player.getInventory().setLeggings(
				new ItemStack(Material.DIAMOND_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
	}

	private void irongear(Player player) {
		player.getInventory().clear();
		player.getInventory().addItem(ocnirongear);
		player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
		player.getInventory().setChestplate(
				new ItemStack(Material.IRON_CHESTPLATE));
		player.getInventory()
				.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
	}

	private void goldgear(Player player) {
		player.getInventory().clear();
		player.getInventory().addItem(ocngoldgear);
		player.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
		player.getInventory().setChestplate(
				new ItemStack(Material.GOLD_CHESTPLATE));
		player.getInventory()
				.setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
	}

	private void chaingear(Player player) {
		player.getInventory().clear();
		player.getInventory().addItem(ocnchaingear);
		player.getInventory().setHelmet(
				new ItemStack(Material.CHAINMAIL_HELMET));
		player.getInventory().setChestplate(
				new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		player.getInventory().setLeggings(
				new ItemStack(Material.CHAINMAIL_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
	}

	private void leathergear(Player player) {
		player.getInventory().clear();
		player.getInventory().addItem(ocnleathergear);
		player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
		player.getInventory().setChestplate(
				new ItemStack(Material.LEATHER_CHESTPLATE));
		player.getInventory().setLeggings(
				new ItemStack(Material.LEATHER_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
	}

	ItemStack[] ocndiamondgear = { new ItemStack(Material.DIAMOND_SWORD),
			new ItemStack(Material.BOW), new ItemStack(Material.ARROW, 120) };
	ItemStack[] ocnirongear = { new ItemStack(Material.IRON_SWORD),
			new ItemStack(Material.BOW), new ItemStack(Material.ARROW, 120) };
	ItemStack[] ocngoldgear = { new ItemStack(Material.GOLD_SWORD),
			new ItemStack(Material.BOW), new ItemStack(Material.ARROW, 120) };
	ItemStack[] ocnchaingear = { new ItemStack(Material.STONE_SWORD),
			new ItemStack(Material.BOW), new ItemStack(Material.ARROW, 120) };
	ItemStack[] ocnleathergear = { new ItemStack(Material.WOOD_SWORD),
			new ItemStack(Material.BOW), new ItemStack(Material.ARROW, 120) };

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
		
		if(Tutorial.inTut.contains(e.getWhoClicked())){
			e.setCancelled(true);
			return;
		}
		
		final Player player = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		Inventory inventory = e.getInventory();

		if (inventory.getName().equals(OCNGames.OCN.getName())) {

			if (clicked == null)
				return;

			switch (clicked.getType()) {

			case DIAMOND_HELMET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int ocntimediamond = 8;
					public void run() {
						ocntimediamond--;
						if (ocntimediamond == 7) {
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						} else if (ocntimediamond == 6) {
							player.teleport(ocnwait);
						}

						else if (ocntimediamond == 5 || ocntimediamond == 4
								|| ocntimediamond == 3 || ocntimediamond == 2
								|| ocntimediamond == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ ocntimediamond + "s");
							player.playSound(player.getLocation(), Sound.CLICK,
									1, 1);
						}

						else if (ocntimediamond == 0) {
							player.teleport(ocnfightdiamond);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							diamondgear(player);
						}

					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case GOLD_HELMET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int ocntimegold = 8;
					public void run() {
						ocntimegold--;
						if (ocntimegold == 7) {
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						} else if (ocntimegold == 6) {
							player.teleport(ocnwait);
						}

						else if (ocntimegold == 5 || ocntimegold == 4
								|| ocntimegold == 3 || ocntimegold == 2
								|| ocntimegold == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ ocntimegold + "s");
							player.playSound(player.getLocation(), Sound.CLICK,
									1, 1);
						}

						else if (ocntimegold == 0) {
							player.teleport(ocnfightgold);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							goldgear(player);
							PlayerManager.setTribute(player);
						}

					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case IRON_HELMET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int ocntimeiron = 8;
					public void run() {
						ocntimeiron--;
						if (ocntimeiron == 7) {
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						} else if (ocntimeiron == 6) {
							player.teleport(ocnwait);
						}

						else if (ocntimeiron == 5 || ocntimeiron == 4
								|| ocntimeiron == 3 || ocntimeiron == 2
								|| ocntimeiron == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ ocntimeiron + "s");
							player.playSound(player.getLocation(), Sound.CLICK,
									1, 1);
						}

						else if (ocntimeiron == 0) {
							player.teleport(ocnfightiron);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							irongear(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case CHAINMAIL_HELMET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int ocntimechain = 8;
					public void run() {
						ocntimechain--;
						if (ocntimechain == 7) {
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						} else if (ocntimechain == 6) {
							player.teleport(ocnwait);
						}

						else if (ocntimechain == 5 || ocntimechain == 4
								|| ocntimechain == 3 || ocntimechain == 2
								|| ocntimechain == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ ocntimechain + "s");
							player.playSound(player.getLocation(), Sound.CLICK,
									1, 1);
						}

						else if (ocntimechain == 0) {
							player.teleport(ocnfightchain);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							chaingear(player);
							PlayerManager.setTribute(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case LEATHER_HELMET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int ocntimeleather = 8;
					public void run() {
						ocntimeleather--;
						if (ocntimeleather == 7) {
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						} else if (ocntimeleather == 6) {
							player.teleport(ocnwait);
						}

						else if (ocntimeleather == 5 || ocntimeleather == 4
								|| ocntimeleather == 3 || ocntimeleather == 2
								|| ocntimeleather == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ ocntimeleather + "s");
							player.playSound(player.getLocation(), Sound.CLICK,
									1, 1);
						}

						else if (ocntimeleather == 0) {
							player.teleport(ocnfightleather);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							leathergear(player);
							PlayerManager.setTribute(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			}

		}
	}

}