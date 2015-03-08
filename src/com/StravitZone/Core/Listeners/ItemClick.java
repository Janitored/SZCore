package com.StravitZone.Core.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.StravitZone.Core.GUIs.BowGames;
import com.StravitZone.Core.GUIs.OCNGames;
import com.StravitZone.Core.GUIs.PotionGames;
import com.StravitZone.Core.GUIs.SoupGames;

public class ItemClick implements Listener {

	@EventHandler
	public void click(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();

		if (p.getItemInHand().getType() == Material.ARROW
				&& p.getItemInHand().getItemMeta().getDisplayName()
						.equals("�9�lSoup Games")
				&& a == Action.RIGHT_CLICK_AIR) {
			
			p.openInventory(SoupGames.soup);

		}
		
		if (p.getItemInHand().getType() == Material.ARROW
				&& p.getItemInHand().getItemMeta().getDisplayName()
						.equals("�b�lPotion Games")
				&& a == Action.RIGHT_CLICK_AIR) {
			
			p.openInventory(PotionGames.pots);

		}
		
		if (p.getItemInHand().getType() == Material.ARROW
				&& p.getItemInHand().getItemMeta().getDisplayName()
						.equals("�6�lBow Games")
				&& a == Action.RIGHT_CLICK_AIR) {
			
			p.openInventory(BowGames.bowgames);

		}
		
		if (p.getItemInHand().getType() == Material.ARROW
				&& p.getItemInHand().getItemMeta().getDisplayName()
						.equals("�e�lOCN Games")
				&& a == Action.RIGHT_CLICK_AIR) {
			
			p.openInventory(OCNGames.OCN);

		}
	}

}