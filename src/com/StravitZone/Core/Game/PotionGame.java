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
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.Tutorial;
import com.StravitZone.Core.GUI.PotionGames;

public class PotionGame implements Listener{

	Location potgamefightkohi = new Location(Bukkit.getWorld("world"), 100, 100,
			100);
	Location potgamefightnodebuff = new Location(Bukkit.getWorld("world"), 100,
			100, 100);
	Location potgamefightpotandsoup = new Location(Bukkit.getWorld("world"), 100,
			100, 100);
	Location potgamefightnoheal = new Location(Bukkit.getWorld("world"), 100,
			100, 100);
	Location potgamefightnosplash = new Location(Bukkit.getWorld("world"), 100,
			100, 100);

	Location potgameswait = new Location(Bukkit.getWorld("world"), 100, 100,
			100);
	
	ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
	ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
	ItemStack leg = new ItemStack(Material.DIAMOND_LEGGINGS);
	ItemStack boot = new ItemStack(Material.DIAMOND_BOOTS);
	ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
	ItemStack bow = new ItemStack(Material.BOW);
	
	Potion heal = new Potion(PotionType.INSTANT_HEAL, 2);
	
	Potion weak = new Potion(PotionType.WEAKNESS, 1);
	
	Potion poison = new Potion(PotionType.POISON, 1);
	
	Potion slow = new Potion(PotionType.SLOWNESS, 2);
	
	private void kohigear(Player p){
		
		heal.setSplash(true);
		weak.setSplash(true);
		poison.setSplash(true);
		slow.setSplash(true);
		
		
		
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		boot.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
		
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
		bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
		
		p.getInventory().setHelmet(helmet);
		p.getInventory().setChestplate(chest);
		p.getInventory().setLeggings(leg);
		p.getInventory().setBoots(boot);
		
		p.getInventory().addItem(bow);
		p.getInventory().addItem(sword);
		
		
		p.getInventory().addItem(new ItemStack(Material.ARROW, 56));
		
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
	}
	
	private void nodebuffgear(Player p){
		
		heal.setSplash(true);
		
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		boot.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
		
		p.getInventory().setHelmet(helmet);
		p.getInventory().setChestplate(chest);
		p.getInventory().setLeggings(leg);
		p.getInventory().setBoots(boot);
		p.getInventory().addItem(bow);
		p.getInventory().addItem(sword);
		
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
		bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
		p.getInventory().addItem(new ItemStack(Material.ARROW, 56));
		
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
	}
	
	private void potandsoupgear(Player p){
		heal.setSplash(true);
		weak.setSplash(true);
		poison.setSplash(true);
		slow.setSplash(true);
		
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		boot.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
		
		p.getInventory().setHelmet(helmet);
		p.getInventory().setChestplate(chest);
		p.getInventory().setLeggings(leg);
		p.getInventory().setBoots(boot);
		p.getInventory().addItem(bow);
		p.getInventory().addItem(sword);
		
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
		bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
		p.getInventory().addItem(new ItemStack(Material.ARROW, 56));
		
		p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
		
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		
	}
	
	private void nohealgear(Player p){
		heal.setSplash(true);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		boot.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
		
		p.getInventory().setHelmet(helmet);
		p.getInventory().setChestplate(chest);
		p.getInventory().setLeggings(leg);
		p.getInventory().setBoots(boot);
		p.getInventory().addItem(bow);
		p.getInventory().addItem(sword);
		
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
		bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
		p.getInventory().addItem(new ItemStack(Material.ARROW, 56));
		
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
	}
	
	private void nosplashgear(Player p){
		heal.setSplash(false);
		weak.setSplash(false);
		poison.setSplash(false);
		slow.setSplash(false);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		boot.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
		sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
		
		p.getInventory().setHelmet(helmet);
		p.getInventory().setChestplate(chest);
		p.getInventory().setLeggings(leg);
		p.getInventory().setBoots(boot);
		p.getInventory().addItem(bow);
		p.getInventory().addItem(sword);
		
		bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
		bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
		p.getInventory().addItem(new ItemStack(Material.ARROW, 56));
		
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		p.getInventory().addItem(heal.toItemStack(1));
		
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		p.getInventory().addItem(weak.toItemStack(1));
		
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		p.getInventory().addItem(poison.toItemStack(1));
		
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
		p.getInventory().addItem(slow.toItemStack(1));
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

		if (inventory.getName().equals(PotionGames.pots.getName())) {

			switch (clicked.getType()) {

			case POTION:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int pottimekohi = 8;
					public void run() {
						pottimekohi--;
						if(pottimekohi == 7){
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						}
						else if (pottimekohi == 6) {
							player.teleport(potgameswait);
						}

						else if (pottimekohi == 5 || pottimekohi == 4
								|| pottimekohi == 3 || pottimekohi == 2
								|| pottimekohi == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ pottimekohi + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (pottimekohi == 0) {
							player.teleport(potgamefightkohi);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							kohigear(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case DIAMOND_SWORD:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int pottimenodebuff = 8;
					public void run() {
						pottimenodebuff--;
						if(pottimenodebuff == 7){
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						}
						else if (pottimenodebuff == 6) {
							player.teleport(potgameswait);
						}

						else if (pottimenodebuff == 5 || pottimenodebuff == 4
								|| pottimenodebuff == 3 || pottimenodebuff == 2
								|| pottimenodebuff == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ pottimenodebuff + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (pottimenodebuff == 0) {
							player.teleport(potgamefightnodebuff);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							nodebuffgear(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case MUSHROOM_SOUP:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int pottimepotandsoup = 8;
					public void run() {
						pottimepotandsoup--;
						if(pottimepotandsoup == 7){
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						}
						else if (pottimepotandsoup == 6) {
							player.teleport(potgameswait);
						}

						else if (pottimepotandsoup == 5 || pottimepotandsoup == 4
								|| pottimepotandsoup == 3 || pottimepotandsoup == 2
								|| pottimepotandsoup == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ pottimepotandsoup + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (pottimepotandsoup == 0) {
							player.teleport(potgamefightpotandsoup);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							potandsoupgear(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case REDSTONE:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int pottimenoheal = 8;
					public void run() {
						pottimenoheal--;
						if(pottimenoheal == 7){
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						}
						else if (pottimenoheal == 6) {
							player.teleport(potgameswait);
						}

						else if (pottimenoheal == 5 || pottimenoheal == 4
								|| pottimenoheal == 3 || pottimenoheal == 2
								|| pottimenoheal == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ pottimenoheal + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (pottimenoheal == 0) {
							player.teleport(potgamefightnoheal);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							nohealgear(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			case WATER_BUCKET:
				e.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatManager.success() + " Teleporting...");

				new BukkitRunnable() {
					int pottimenosplash = 8;
					public void run() {
						pottimenosplash--;
						if(pottimenosplash  == 7){
							player.getInventory().clear();
							PlayerManager.setWaiting(player);
						}
						else if (pottimenosplash == 6) {
							player.teleport(potgameswait);
						}

						else if (pottimenosplash == 5 || pottimenosplash == 4
								|| pottimenosplash == 3 || pottimenosplash == 2
								|| pottimenosplash == 1) {
							player.sendMessage(ChatManager.announcement()
									+ " You will get your items in §6"
									+ pottimenosplash + "s");
							player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
						}

						else if (pottimenosplash == 0) {
							player.teleport(potgamefightnosplash);
							player.playSound(player.getLocation(),
									Sound.LEVEL_UP, 1, 3);
							player.sendMessage(ChatManager.success()
									+ " Fight!");
							PlayerManager.setTribute(player);
							nosplashgear(player);
						}
					}
				}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

				break;

			}
		}
	}

}
