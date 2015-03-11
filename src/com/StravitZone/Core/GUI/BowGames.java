package com.StravitZone.Core.GUI;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BowGames {
	
	public static Inventory bowgames = Bukkit.createInventory(null, 9, "§5§lBow Games");
	
	static {
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta m = bow.getItemMeta();
		m.setDisplayName("§a§lSharp Shooter");
		m.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		bow.setItemMeta(m);
		bowgames.setItem(0, bow);
		
		ItemStack oitc = new ItemStack(Material.ARROW);
		ItemMeta u = oitc.getItemMeta();
		u.setDisplayName("§1§lOne in The Chamber");
		u.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		oitc.setItemMeta(u);
		bowgames.setItem(2, oitc);
		
		ItemStack sumo = new ItemStack(Material.WOOD_SWORD);
		ItemMeta c = sumo.getItemMeta();
		c.setDisplayName("§4§lSumo Snipe");
		c.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		sumo.setItemMeta(c);
		bowgames.setItem(4, sumo);
		
		ItemStack fire = new ItemStack(Material.FIRE);
		ItemMeta i = fire.getItemMeta();
		i.setDisplayName("§c§lFlame Snipe");
		i.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		fire.setItemMeta(i);
		bowgames.setItem(6, fire);
		
		ItemStack tp = new ItemStack(Material.ENDER_PEARL);
		ItemMeta t = tp.getItemMeta();
		t.setDisplayName("§9§lTele-snipe");
		t.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		tp.setItemMeta(t);
		bowgames.setItem(8, tp);
	}

}