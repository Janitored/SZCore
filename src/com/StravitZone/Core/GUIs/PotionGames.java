package com.StravitZone.Core.GUIs;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PotionGames {
	
	public static Inventory pots = Bukkit.createInventory(null, 9, "§b§lPotion Games");
	
	static {
		ItemStack kohi = new ItemStack(Material.POTION);
		ItemMeta a = kohi.getItemMeta();
		a.setDisplayName("§b§lKohi");
		a.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		kohi.setItemMeta(a);
		pots.setItem(0, kohi);
		
		ItemStack nodebuff = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta y= nodebuff.getItemMeta();
		y.setDisplayName("§c§lNo Debuff");
		y.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		nodebuff.setItemMeta(y);
		pots.setItem(2, nodebuff);
		
		ItemStack potandsoup = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta b = potandsoup.getItemMeta();
		b.setDisplayName("§e§lPot & Soup");
		b.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		potandsoup.setItemMeta(b);
		pots.setItem(4, potandsoup);
		
		ItemStack noheal = new ItemStack(Material.REDSTONE);
		ItemMeta o = noheal.getItemMeta();
		o.setDisplayName("§4§lNo Heal");
		o.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		noheal.setItemMeta(o);
		pots.setItem(6, noheal);
		
		ItemStack drink = new ItemStack(Material.WATER_BUCKET);
		ItemMeta q = drink.getItemMeta();
		q.setDisplayName("§2§lNo Splash");
		q.setLore(Arrays.asList("", "§6§lRIGHT CLICK §eto join!", ""));
		drink.setItemMeta(q);
		pots.setItem(8, drink);
	}
}


