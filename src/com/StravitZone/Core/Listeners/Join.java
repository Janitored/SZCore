package com.StravitZone.Core.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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
import com.StravitZone.Core.API.Tutorial;

public class Join implements Listener {
	
	int animation = 15;

	@EventHandler
	public void join(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();

		Scoreboard mainboard = manager.getNewScoreboard();

		final Objective objective = mainboard.registerNewObjective("test",
				"dummy");

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		int credits = Main.getInstance().getConfig().getInt(p.getName());

		Score welcome = objective.getScore("§3" + p.getName());
		welcome.setScore(5);

		Score space = objective.getScore("§c----------");
		space.setScore(4);

		Score score = objective.getScore("§5Credits:");
		score.setScore(credits);

		Score space2 = objective.getScore("§c----------");
		space2.setScore(2);

		Score score2 = objective.getScore("§aPlayers:");
		score2.setScore(Bukkit.getServer().getOnlinePlayers().length);

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
		
		p.setScoreboard(mainboard);

		e.getPlayer().getInventory().setItem(0, bow);
		e.getPlayer().getInventory().setItem(1, ocn);
		e.getPlayer().getInventory().setItem(7, pot);
		e.getPlayer().getInventory().setItem(8, soup);

		if (!e.getPlayer().hasPlayedBefore()) {
			PermissionAttachment perm = e.getPlayer().addAttachment(
					Main.getInstance());
			perm.setPermission(Rank.all, true);
			e.getPlayer().getInventory().setItem(0, bow);
			e.getPlayer().getInventory().setItem(1, ocn);
			e.getPlayer().getInventory().setItem(7, pot);
			e.getPlayer().getInventory().setItem(8, soup);
		}
		
		new BukkitRunnable() {
			public void run() {

				animation--;

				if (animation == 15) {
					objective.setDisplayName("§6§lStravitZone");
				}

				if (animation == 14) {
					objective.setDisplayName("§e§lS§6§ltravitZone");
				}

				if (animation == 13) {
					objective.setDisplayName("§e§lST§6§lravitZone");
				}
				if (animation == 12) {
					objective.setDisplayName("§e§lSTR§6§lavitZone");
				}

				if (animation == 11) {
					objective.setDisplayName("§e§lSTRA§6§lvitZone");
				}

				if (animation == 10) {
					objective.setDisplayName("§e§lSTRAV§6§litZone");
				}

				if (animation == 9) {
					objective.setDisplayName("§e§lSTRAVI§6§ltZone");
				}

				if (animation == 8) {
					objective.setDisplayName("§e§lSTRAVIT§6§lZone");
				}

				if (animation == 7) {
					objective.setDisplayName("§e§lSTRAVITZ§6§lone");
				}

				if (animation == 6) {
					objective.setDisplayName("§e§lSTRAVITZO§6§lne");
				}

				if (animation == 5) {
					objective.setDisplayName("§e§lSTRAVITZON§6§ln");
				}

				if (animation == 4) {
					objective.setDisplayName("§e§lSTRAVITZONE");
				}

				if (animation == 3) {
					objective.setDisplayName("§6§lStravitZone");
				}

				if (animation == 2) {
					objective.setDisplayName("§e§lStravitZone");
				}

				if (animation == 1) {
					objective.setDisplayName("§6§lStravitZone");
				}

				if (animation == 0) {
					objective.setDisplayName("§e§lStravitZone");
				}
				
				if(animation == -1){
					objective.setDisplayName("§6§lStravitZone");
					
				}
				if(animation == -2){
					objective.setDisplayName("§e§lStravitZone");
					
				}
				if(animation == -3){
					objective.setDisplayName("§6§lStravitZone");
					
				}
				if(animation == -4){
					objective.setDisplayName("§6§lStravitZone");
					
				}
				if(animation == -5){
					objective.setDisplayName("§6§lStravitZone");
				}
				
				if(animation == -6){
					this.cancel();
					animation = 15;
				}

			}
		}.runTaskTimer(Main.getInstance(), 1, 5);
		
	}
}
