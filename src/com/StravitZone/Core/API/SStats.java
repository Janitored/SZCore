package com.StravitZone.Core.API;

import java.text.DecimalFormat;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.StravitZone.Core.Main;

public class SStats implements Listener {

	public static void saveStats() {
		try {
			Main.stats.save(Main.statsFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getKills(Player player) {
	return Main.stats.getInt("Players." + player.getName() + ".Kills");

	}

	public static void addKill(Player player) {
		Main.stats.set("Players." + player.getName() + ".Kills", Main.stats.getInt("Players." + player.getName() + ".Kills") + 1);
		saveStats();
	}

	public static int getDeaths(Player player) {

			return Main.stats.getInt("Players." + player.getName() + ".Deaths");
	}
	
	public static double getKDR(Player player){
		if(getKills(player) == 0 || getDeaths(player) == 0){
			return 0.0;
		} else {
		return getKills(player) / getDeaths(player);
		}
	}

	public static void addDeath(Player player) {
		Main.stats.set("Players." + player.getName() + ".Deaths", Main.stats.getInt("Players." + player.getName() + ".Deaths") + 1);
		saveStats();
	}

}
