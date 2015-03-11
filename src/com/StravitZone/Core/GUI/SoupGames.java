package com.StravitZone.Core.GUI;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SoupGames {
	
	public static Inventory soup = Bukkit.createInventory(null, 9, "§a§lSoup Games");
	
	static {
		ItemStack soupffa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta s = soupffa.getItemMeta();
		s.setDisplayName("§e§lSoup FFA");
		s.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		soupffa.setItemMeta(s);
		soup.setItem(0, soupffa);
		
		ItemStack soupsnipe = new ItemStack(Material.BOW);
		ItemMeta q = soupsnipe.getItemMeta();
		q.setDisplayName("§6§lSoup n' Snipe");
		q.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		soupsnipe.setItemMeta(q);
		soup.setItem(2, soupsnipe);
		
		ItemStack soupdebuff = new ItemStack(Material.POTION);
		ItemMeta p = soupdebuff.getItemMeta();
		p.setDisplayName("§b§lSoup & Debuff");
		p.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		soupdebuff.setItemMeta(p);
		soup.setItem(4, soupdebuff);
		
		ItemStack soupswift = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta y= soupswift.getItemMeta();
		y.setDisplayName("§c§lSoup and Swift");
		y.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		soupswift.setItemMeta(y);
		soup.setItem(6, soupswift);
		
		ItemStack soupmcsg = new ItemStack(Material.FISHING_ROD);
		ItemMeta v = soupmcsg.getItemMeta();
		v.setDisplayName("§a§lSoup MCSG");
		v.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		soupmcsg.setItemMeta(v);
		soup.setItem(8, soupmcsg);
	}

}