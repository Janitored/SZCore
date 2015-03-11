package com.StravitZone.Core.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {

	@EventHandler
	public void death(PlayerDeathEvent e) {
		
		e.getDrops().clear();

		for (Player p : Bukkit.getOnlinePlayers()) {

			Player killed = (Player) e.getEntity();

			Player killer = killed.getKiller();

			e.setDeathMessage("§4§l>> §9" + killed.getName()
					+ " §cwas slain by §9" + killer.getName());

			p.playSound(p.getLocation(), Sound.WITHER_SPAWN, 1, 1);

			if (killer.getItemInHand().getType() != null) {
				e.setDeathMessage("§4§l>> §9" + killed.getName()
						+ " §cwas slain by §9" + killer.getName()
						+ " §cusing §9"
						+ killer.getItemInHand().getItemMeta().getDisplayName()
						+ "§9!");
				p.playSound(p.getLocation(), Sound.WITHER_SPAWN, 1, 1);

			}
			
		}

	}

}