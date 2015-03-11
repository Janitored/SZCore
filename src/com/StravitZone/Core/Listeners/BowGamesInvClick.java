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

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Tutorial;
import com.StravitZone.Core.GUI.BowGames;

public class BowGamesInvClick implements Listener {

	int bowgametimess = 8;
	int bowgametimeoitc = 8;
	int bowgametimesumo = 8;
	int bowgametimefire = 8;
	int bowgametimetele = 8;

	Location bowgamesfightss = new Location(Bukkit.getWorld("world"), 100, 100,
			100);
	Location bowgamesfightoitc = new Location(Bukkit.getWorld("world"), 100,
			100, 100);
	Location bowgamesfightsumo = new Location(Bukkit.getWorld("world"), 100,
			100, 100);
	Location bowgamesfightfire = new Location(Bukkit.getWorld("world"), 100,
			100, 100);

	Location bowgameswait = new Location(Bukkit.getWorld("world"), 100, 100,
			100);

	@EventHandler
	public void click(InventoryClickEvent e) {
		
		if(Tutorial.tutorial != 60){
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
					public void run() {
						bowgametimess--;
						if(bowgametimess == 7){
							player.getInventory().clear();
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
						}

						else if (bowgametimess == 0) {
							player.teleport(bowgamesfightss);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							this.cancel();
							bowgametimess = 8;
						}
					}
				}.runTaskTimer(Main.getInstance(), 0, 20);

				break;

			case ARROW:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					public void run() {
						bowgametimeoitc--;
						if(bowgametimeoitc == 7){
							player.getInventory().clear();
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
						}

						else if (bowgametimeoitc == 0) {
							player.teleport(bowgamesfightoitc);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							this.cancel();
							bowgametimeoitc = 8;
						}
					}
				}.runTaskTimer(Main.getInstance(), 0, 20);

				break;

			case WOOD_SWORD:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					public void run() {
						bowgametimesumo--;
						if(bowgametimesumo == 7){
							player.getInventory().clear();
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
						}

						else if (bowgametimesumo == 0) {
							player.teleport(bowgamesfightsumo);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							this.cancel();
							bowgametimesumo = 8;
						}
					}
				}.runTaskTimer(Main.getInstance(), 0, 20);

				break;

			case FIRE:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					public void run() {
						bowgametimefire--;
						if(bowgametimefire == 7){
							player.getInventory().clear();
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
						}

						else if (bowgametimefire == 0) {
							player.teleport(bowgamesfightfire);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							this.cancel();
							bowgametimefire = 8;
						}
					}
				}.runTaskTimer(Main.getInstance(), 0, 20);

				break;

			case ENDER_PEARL:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					public void run() {
						bowgametimefire--;
						if(bowgametimefire  == 7){
							player.getInventory().clear();
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
						}

						else if (bowgametimefire == 0) {
							player.teleport(bowgamesfightfire);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							this.cancel();
							bowgametimefire = 8;
						}
					}
				}.runTaskTimer(Main.getInstance(), 0, 20);

				break;

			}
		}
	}

}
