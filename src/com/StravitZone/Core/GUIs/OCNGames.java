package com.StravitZone.Core.GUIs;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OCNGames {
	
	public static Inventory OCN = Bukkit.createInventory(null, 9, "§6§lOCN Games");
	
	static {
		ItemStack DiamondOCN = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta meta = DiamondOCN.getItemMeta();
		meta.setDisplayName("§b§lDiamond OCN");
		meta.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		DiamondOCN.setItemMeta(meta);
		OCN.setItem(0, DiamondOCN);
		
		ItemStack GoldOCN = new ItemStack(Material.GOLD_HELMET);
		ItemMeta meta2 = GoldOCN.getItemMeta();
		meta2.setDisplayName("§e§lGold OCN");
		meta2.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		GoldOCN.setItemMeta(meta2);
		OCN.setItem(2, GoldOCN);
		
		ItemStack IronOCN = new ItemStack(Material.IRON_HELMET);
		ItemMeta meta3 = IronOCN.getItemMeta();
		meta3.setDisplayName("§7§lIron OCN");
		meta3.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		IronOCN.setItemMeta(meta3);
		OCN.setItem(4, IronOCN);
		
		ItemStack ChainOCN = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemMeta meta4 = ChainOCN.getItemMeta();
		meta4.setDisplayName("§8§lChain OCN");
		meta4.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		ChainOCN.setItemMeta(meta4);
		OCN.setItem(6, ChainOCN);
		
		ItemStack LeatherOCN = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta meta5 = LeatherOCN.getItemMeta();
		meta5.setDisplayName("§6§lLeather OCN");
		meta5.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		LeatherOCN.setItemMeta(meta5);
		OCN.setItem(8, LeatherOCN);
	}

}