package com.StravitZone.Core.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import com.StravitZone.Core.Main;
import com.StravitZone.Core.API.ChatManager;
import com.StravitZone.Core.API.Rank;

public class Join implements Listener {

	@EventHandler
	public void join(PlayerJoinEvent e) {

		ScoreboardManager manager = Bukkit.getScoreboardManager();
		
		int credits = Main.getInstance().getConfig().getInt(e.getPlayer().getName());

		Scoreboard mainboard = manager.getNewScoreboard();

		Objective objective = mainboard.registerNewObjective("test", "dummy");
		
		objective.setDisplayName("§6§lStravitZone");
		
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score score = objective.getScore("§5§lCredits:");
		score.setScore(credits);

		ItemStack bow = new ItemStack(Material.ARROW);
		ItemMeta o = bow.getItemMeta();
		o.setDisplayName("§6§lBow Games");
		bow.setItemMeta(o);

		ItemStack ocn = new ItemStack(Material.ARROW);

		ItemMeta o2 = ocn.getItemMeta();
		o2.setDisplayName("§e§lOCN Games");
		ocn.setItemMeta(o2);

		ItemStack pot = new ItemStack(Material.ARROW);

		ItemMeta o3 = pot.getItemMeta();
		o3.setDisplayName("§b§lPotion Games");
		pot.setItemMeta(o3);

		ItemStack soup = new ItemStack(Material.ARROW);

		ItemMeta o4 = soup.getItemMeta();
		o4.setDisplayName("§9§lSoup Games");
		soup.setItemMeta(o4);

		e.setJoinMessage(ChatManager.player_join() + e.getPlayer().getName());

		e.getPlayer().getInventory().setItem(0, bow);
		e.getPlayer().getInventory().setItem(1, ocn);
		e.getPlayer().getInventory().setItem(7, pot);
		e.getPlayer().getInventory().setItem(8, soup);
		e.getPlayer().setScoreboard(mainboard);

		if (!e.getPlayer().hasPlayedBefore()) {
			PermissionAttachment perm = e.getPlayer().addAttachment(
					Main.getInstance());
			perm.setPermission(Rank.all, true);
			e.getPlayer().getInventory().setItem(0, bow);
			e.getPlayer().getInventory().setItem(1, ocn);
			e.getPlayer().getInventory().setItem(7, pot);
			e.getPlayer().getInventory().setItem(8, soup);
			e.getPlayer().setScoreboard(mainboard);
		}

	}
}
