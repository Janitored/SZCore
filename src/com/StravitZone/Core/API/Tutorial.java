package com.StravitZone.Core.API;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.StravitZone.Core.Main;
import com.StravitZone.Core.Commands.Tut;
import com.StravitZone.Core.GUI.BowGames;
import com.StravitZone.Core.GUI.OCNGames;
import com.StravitZone.Core.GUI.PotionGames;
import com.StravitZone.Core.GUI.SoupGames;

public class Tutorial {

	public static int tutorial = 60;
	
	public static List<Player> inTut = new ArrayList<Player>();

	public static void activate(final Player p) {
		
		inTut.add(p);

		new BukkitRunnable() {
			public void run() {

				tutorial--;

				if (tutorial == 58) {
					p.sendMessage(ChatManager.announcement()
							+ " Welcome to StravitZone!");
				}

				if (tutorial == 55) {
					p.sendMessage(ChatManager.announcement()
							+ " This simple and quick tutorial will guide you through the basics!");
				}

				if (tutorial == 53) {
					p.sendMessage(ChatManager.announcement()
							+ " So lets begin.");
				}

				if (tutorial == 51) {
					p.sendMessage(ChatManager.announcement()
							+ " As you can see, you have 4 arrows in your inventory, each being a different game.");
				}

				if (tutorial == 48) {
					p.sendMessage(ChatManager.announcement()
							+ " So lets have a look in each game selector.");
				}

				if (tutorial == 46) {
					p.openInventory(BowGames.bowgames);
				}

				if (tutorial == 45) {
					p.openInventory(OCNGames.OCN);
				}

				if (tutorial == 44) {
					p.openInventory(PotionGames.pots);
				}

				if (tutorial == 43) {
					p.openInventory(SoupGames.soup);
				}

				if (tutorial == 42) {
					p.closeInventory();
					
					p.sendMessage(ChatManager.announcement()
							+ " Looks fun, huh? And there's plenty to play!");
				}

				if (tutorial == 36) {
					p.sendMessage(ChatManager.announcement()
							+ " Just click on one of these arrows and select a gamemode!");
				}

				if (tutorial == 33) {
					p.sendMessage(ChatManager.announcement()
							+ " That's all! Hope you found this helpful, and have a great stay!");
				}

				if (tutorial == 34) {

				}

				if (tutorial == 32) {

					this.cancel();
					tutorial = 60;
					Tut.one.remove(p);
					inTut.remove(p);
					Tut.tutFinished.add(p);

				}

			}
		}.runTaskTimer(Main.getInstance(), 0, 20);

	}

}
