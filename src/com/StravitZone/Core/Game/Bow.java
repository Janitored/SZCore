package com.StravitZone.Core.Game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.Tutorial;
import com.StravitZone.Core.GUI.BowGames;
import com.StravitZone.Core.Item.ItemStackFactory;

public class Bow implements Listener {

	Location bowgamesfightss = new Location(Bukkit.getWorld("world"), 100, 100,
			100);
	Location bowgamesfightoitc = new Location(Bukkit.getWorld("world"), 100,
			100, 100);
	Location bowgamesfightsumo = new Location(Bukkit.getWorld("world"), 100,
			100, 100);
	Location bowgamesfightfire = new Location(Bukkit.getWorld("world"), 100,
			100, 100);
	Location bowgamesfighttele = new Location(Bukkit.getWorld("world"), 100,
			100, 100);

	Location bowgameswait = new Location(Bukkit.getWorld("world"), 100, 100,
			100);
	
	private void sharpgear(Player p){
		p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
	}
	
	private void sumogear(Player p){
		p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
	}
	
	private void firegear(Player p){
		p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
	}
	
	private void telegear(Player p){
		p.getInventory().addItem(new ItemStack(Material.BOW));
		p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
	}

	@EventHandler
	public void click(InventoryClickEvent e) {
		
		if(Tutorial.inTut.contains(e.getWhoClicked())){
			e.setCancelled(true);
			return;
		}
		
		final Player player = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		Inventory inventory = e.getInventory();
		
		if(clicked == null) return;

		if (inventory.getName().equals(BowGames.bowgames.getName())) {

			switch (clicked.getType()) {

			case BOW:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int bowgametimess = 8;
					public void run() {
						bowgametimess--;
						if(bowgametimess == 7){
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						}
						else if (bowgametimess == 6) {
							player.teleport(bowgameswait);
						}

						else if (bowgametimess == 5 || bowgametimess == 4
								|| bowgametimess == 3 || bowgametimess == 2
								|| bowgametimess == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ bowgametimess + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (bowgametimess == 0) {
							player.teleport(bowgamesfightss);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							sharpgear(player);
							ItemStackFactory.sharpBow(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case ARROW:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int bowgametimeoitc = 8;
					public void run() {
						bowgametimeoitc--;
						if(bowgametimeoitc == 7){
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						}
						else if (bowgametimeoitc == 6) {
							player.teleport(bowgameswait);
						}

						else if (bowgametimeoitc == 5 || bowgametimeoitc == 4
								|| bowgametimeoitc == 3 || bowgametimeoitc == 2
								|| bowgametimeoitc == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ bowgametimeoitc + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (bowgametimeoitc == 0) {
							player.teleport(bowgamesfightoitc);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							ItemStackFactory.oitcBow(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case WOOD_SWORD:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int bowgametimesumo = 8;
					public void run() {
						bowgametimesumo--;
						if(bowgametimesumo == 7){
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						}
						else if (bowgametimesumo == 6) {
							player.teleport(bowgameswait);
						}

						else if (bowgametimesumo == 5 || bowgametimesumo == 4
								|| bowgametimesumo == 3 || bowgametimesumo == 2
								|| bowgametimesumo == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ bowgametimesumo + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (bowgametimesumo == 0) {
							player.teleport(bowgamesfightsumo);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							sumogear(player);
							ItemStackFactory.sumoBow(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case FIRE:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int bowgametimefire = 8;
					public void run() {
						bowgametimefire--;
						if(bowgametimefire == 7){
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						}
						else if (bowgametimefire == 6) {
							player.teleport(bowgameswait);
						}

						else if (bowgametimefire == 5 || bowgametimefire == 4
								|| bowgametimefire == 3 || bowgametimefire == 2
								|| bowgametimefire == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ bowgametimefire + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (bowgametimefire == 0) {
							player.teleport(bowgamesfightfire);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							ItemStackFactory.fireBow(player);
							firegear(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case ENDER_PEARL:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int bowgametimetele = 8;
					public void run() {
						bowgametimetele--;
						if(bowgametimetele  == 7){
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						}
						else if (bowgametimetele == 6) {
							player.teleport(bowgameswait);
						}

						else if (bowgametimetele == 5 || bowgametimetele == 4
								|| bowgametimetele == 3 || bowgametimetele == 2
								|| bowgametimetele == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ bowgametimetele + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (bowgametimetele == 0) {
							player.teleport(bowgamesfighttele);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							
							
							
							telegear(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			}
		}
	}

}
