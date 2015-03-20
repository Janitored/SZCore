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
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.Tutorial;
import com.StravitZone.Core.GUI.SoupGames;

public class Soup implements Listener {

	Location ffafight = new Location(Bukkit.getWorld("world"), 100, 100, 100);
	Location snipefight = new Location(Bukkit.getWorld("world"), 100, 100, 100);
	Location debufffight = new Location(Bukkit.getWorld("world"), 100, 100, 100);
	Location swiftfight = new Location(Bukkit.getWorld("world"), 100, 100, 100);

	Location mcsgfight = new Location(Bukkit.getWorld("world"), 100, 100, 100);
	Location soupwait = new Location(Bukkit.getWorld("world"), 100, 100, 100);

	private void ffagear(Player player) {
		player.getInventory().clear();
		player.getInventory().addItem(ffagear);
		player.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
		player.getInventory().setChestplate(
				new ItemStack(Material.GOLD_CHESTPLATE));
		player.getInventory().setLeggings(
				new ItemStack(Material.GOLD_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
	}

	private void snipegear(Player player) {
		player.getInventory().clear();
		player.getInventory().addItem(snipegear);
		player.getInventory().setChestplate(
				new ItemStack(Material.LEATHER_CHESTPLATE));
	}

	private void debuffgear(Player player) {

		final Potion poison = new Potion(PotionType.POISON);
		poison.setSplash(true);

		final Potion slow = new Potion(PotionType.SLOWNESS);
		slow.setSplash(true);

		final Potion weak = new Potion(PotionType.WEAKNESS);
		weak.setSplash(true);

		player.getInventory().clear();
		player.getInventory().addItem(debuffgear);

		player.getInventory().addItem(poison.toItemStack(1));
		player.getInventory().addItem(poison.toItemStack(1));
		player.getInventory().addItem(poison.toItemStack(1));

		player.getInventory().addItem(slow.toItemStack(1));
		player.getInventory().addItem(slow.toItemStack(1));
		player.getInventory().addItem(slow.toItemStack(1));
		player.getInventory().addItem(slow.toItemStack(1));
		player.getInventory().addItem(slow.toItemStack(1));

		player.getInventory().addItem(weak.toItemStack(1));
		player.getInventory().addItem(weak.toItemStack(1));
		player.getInventory().addItem(weak.toItemStack(1));
		player.getInventory().addItem(weak.toItemStack(1));
		player.getInventory().addItem(weak.toItemStack(1));
		player.getInventory().addItem(weak.toItemStack(1));
		player.getInventory().addItem(weak.toItemStack(1));

		player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
		player.getInventory().setChestplate(
				new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		player.getInventory()
				.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
	}

	private void swiftgear(Player player) {

		player.getInventory().clear();
		player.getInventory().addItem(swiftgear);

		player.getInventory().setHelmet(
				new ItemStack(Material.CHAINMAIL_HELMET));
		player.getInventory().setChestplate(
				new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		player.getInventory().setLeggings(
				new ItemStack(Material.CHAINMAIL_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
	}

	private void mcsggear(Player player) {
		player.getInventory().clear();
		player.getInventory().addItem(mcsggear);
		player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
		player.getInventory().setChestplate(
				new ItemStack(Material.LEATHER_CHESTPLATE));
		player.getInventory().setLeggings(
				new ItemStack(Material.LEATHER_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
	}

	ItemStack[] ffagear = { new ItemStack(Material.WOOD_SWORD),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP) };

	ItemStack[] snipegear = { new ItemStack(Material.BOW),
			new ItemStack(Material.ARROW, 64),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP) };

	ItemStack[] debuffgear = { new ItemStack(Material.WOOD_SWORD),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP) };

	ItemStack[] swiftgear = { new ItemStack(Material.WOOD_SWORD),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP) };

	ItemStack[] mcsggear = { new ItemStack(Material.STONE_SWORD),
			new ItemStack(Material.BOW), new ItemStack(Material.ARROW, 120),
			new ItemStack(Material.FISHING_ROD),
			new ItemStack(Material.GOLDEN_APPLE),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP),
			new ItemStack(Material.MUSHROOM_SOUP) };

	@EventHandler
	public void inv(InventoryClickEvent e) {
		
		if(Tutorial.inTut.contains(e.getWhoClicked())){
			e.setCancelled(true);
			return;
		}

		final Player player = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		Inventory inventory = e.getInventory();

		if (clicked == null)
			return;

		if (inventory.getName().equals(SoupGames.soup.getName())) {

			switch (clicked.getType()) {

			case MUSHROOM_SOUP:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int ffa = 8;
					public void run() {
						ffa--;
						if (ffa == 7) {
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						} else if (ffa == 6) {
							player.teleport(soupwait);
						}

						else if (ffa == 5 || ffa == 4 || ffa == 3 || ffa == 2
								|| ffa == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6" + ffa
									+ "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (ffa == 0) {
							player.teleport(ffafight);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							ffagear(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case BOW:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int snipe = 8;
					public void run() {
						snipe--;
						if (snipe == 7) {
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						} else if (snipe == 6) {
							player.teleport(soupwait);
						}

						else if (snipe == 5 || snipe == 4
								|| snipe == 3 || snipe == 2
								|| snipe == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ snipe + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (snipe == 0) {
							player.teleport(snipefight);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							snipegear(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case POTION:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int debuff = 8;
					public void run() {
						debuff--;
						if (debuff == 7) {
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						} else if (debuff == 6) {
							player.teleport(soupwait);
						}

						else if (debuff == 5 || debuff == 4
								|| debuff == 3 || debuff == 2
								|| debuff == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ debuff + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (debuff == 0) {
							player.teleport(debufffight);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							debuffgear(player);
							PlayerManager.setTribute(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case DIAMOND_BOOTS:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int swift = 8;
					public void run() {
						swift--;
						if (swift == 7) {
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						} else if (swift == 6) {
							player.teleport(soupwait);
						}

						else if (swift == 5 || swift == 4
								|| swift == 3 || swift == 2
								|| swift == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ swift + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (swift == 0) {
							player.teleport(swiftfight);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							swiftgear(player);
							PlayerManager.setTribute(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case FISHING_ROD:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int mcsg = 8;
					public void run() {
						mcsg--;
						if (mcsg == 7) {
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						} else if (mcsg == 6) {
							player.teleport(soupwait);
						}

						else if (mcsg == 5 || mcsg == 4
								|| mcsg == 3 || mcsg == 2
								|| mcsg == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ mcsg + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (mcsg == 0) {
							player.teleport(soupwait);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							mcsggear(player);
							PlayerManager.setTribute(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			}
		}
	}

}
