package com.StravitZone.Core.Item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackFactory {
	
	public static void fireBow(Player p){
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
		p.getInventory().addItem(bow);
		p.getInventory().addItem(new ItemStack(Material.ARROW, 64));
	}
	
	public static void oitcBow(Player p){
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 500);
		p.getInventory().addItem(bow);
		p.getInventory().addItem(new ItemStack(Material.ARROW, 64));
	}
	
	public static void sumoBow(Player p){
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 4);
		p.getInventory().addItem(bow);
		p.getInventory().addItem(new ItemStack(Material.ARROW, 64));
	}
	
	public static void sharpBow(Player p){
		ItemStack bow = new ItemStack(Material.BOW);
		bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
		p.getInventory().addItem(bow);
		p.getInventory().addItem(new ItemStack(Material.ARROW, 64));
	}

}