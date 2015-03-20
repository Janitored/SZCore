package com.StravitZone.Core.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.RankHandlers;
import com.StravitZone.Core.Player.SPlayer;

public class Join implements Listener {

	int joinwait = 3;

	
	@SuppressWarnings("static-access")
	@EventHandler
	public void join(final PlayerJoinEvent e) {

		Player p = e.getPlayer();
		
		SPlayer pl = new SPlayer(p);
        
		

		PlayerManager.setTribute(p);
		
		pl.showStatBoard(p);


	

		final ItemStack bow = new ItemStack(Material.ARROW);
		ItemMeta o = bow.getItemMeta();
		o.setDisplayName("§6§lBow Games");
		bow.setItemMeta(o);

		final ItemStack ocn = new ItemStack(Material.ARROW);

		ItemMeta o2 = ocn.getItemMeta();
		o2.setDisplayName("§e§lOCN Games");
		ocn.setItemMeta(o2);

		final ItemStack pot = new ItemStack(Material.ARROW);

		ItemMeta o3 = pot.getItemMeta();
		o3.setDisplayName("§b§lPotion Games");
		pot.setItemMeta(o3);

		final ItemStack soup = new ItemStack(Material.ARROW);

		ItemMeta o4 = soup.getItemMeta();
		o4.setDisplayName("§9§lSoup Games");
		soup.setItemMeta(o4);

		e.setJoinMessage(ChatManager.player_join() + e.getPlayer().getName());

		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "clear "
				+ e.getPlayer().getName());
		
		new BukkitRunnable(){
			public void run(){
				
				joinwait--;
				
				if(joinwait == 0){
					
					e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.NOTE_PLING, 1, 2);
					
					e.getPlayer().sendMessage("§6o----------------------------------------------o");
					e.getPlayer().sendMessage("");
					e.getPlayer().sendMessage("§e§lWelcome to §6§lSTRAVITZONE§e§l, §6§l" + e.getPlayer().getName() + "§e§l!");
					e.getPlayer().sendMessage("");
					e.getPlayer().sendMessage("§e§lUse your §6§lGAME ARROWS§e§l to select a gamemode!");
					e.getPlayer().sendMessage("");
					e.getPlayer().sendMessage("§e§lHelp support us by purchasing §6§lVIP §e§lat our shop!");
					e.getPlayer().sendMessage("");
					e.getPlayer().sendMessage("§6o----------------------------------------------o");
					
					
					e.getPlayer().getInventory().setItem(0, bow);
					e.getPlayer().getInventory().setItem(1, ocn);
					e.getPlayer().getInventory().setItem(7, pot);
					e.getPlayer().getInventory().setItem(8, soup);
					
					this.cancel();
					joinwait = 3;
				}
				
			}
		}.runTaskTimerAsynchronously(Main.getInstance(), 0, 20);

		if (!e.getPlayer().hasPlayedBefore()) {

			SPlayer sp = new SPlayer(e.getPlayer());

			e.getPlayer()
					.sendMessage(
							ChatManager.info()
									+ " Welcome! You've been given a welcome gift of 20 credits!");

			sp.addCredits(e.getPlayer(), 20);

			sp.setRank(e.getPlayer(), "player");

			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "clear "
					+ e.getPlayer().getName());
		}

		if (!(RankHandlers.admins.contains(e.getPlayer())
				|| RankHandlers.mods.contains(e.getPlayer())
				|| RankHandlers.build.contains(e.getPlayer())
				|| RankHandlers.vip.contains(e.getPlayer()) || RankHandlers.all
					.contains(e.getPlayer()))) {
			
			SPlayer sp = new SPlayer(e.getPlayer());
			
			sp.setRank(e.getPlayer(), "player");
			
			

		}

	}
	
	
}