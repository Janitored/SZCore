package com.StravitZone.Core.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Tutorial;

public class TutorialHandler extends Tutorial implements Listener {

	@EventHandler
	public void move(PlayerMoveEvent e) {
		if (Tutorial.tutorial != 60 && Tutorial.inTut.contains(e.getPlayer())) {
			e.setTo(e.getFrom());
		}
	}

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		if (Tutorial.tutorial != 60 && Tutorial.inTut.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void interact(PlayerInteractEvent e) {
		if (Tutorial.tutorial != 60 && Tutorial.inTut.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void click(InventoryClickEvent e) {
		if (Tutorial.tutorial != 60
				&& Tutorial.inTut.contains(e.getWhoClicked())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void quit(PlayerQuitEvent e) {
		if (Tutorial.inTut.contains(e.getPlayer())) {
			Tutorial.inTut.remove(e.getPlayer());
		}
	}
	
	@EventHandler
	public void command(PlayerCommandPreprocessEvent e){
		if (e.getMessage().startsWith("/")
				&& Tutorial.inTut.contains(e.getPlayer())) {
			e.setCancelled(true);
			e.getPlayer()
					.sendMessage(
							ChatManager.error_general()
									+ " You may not use commands while in the tutorial.");
			return;
		}

	}

}
