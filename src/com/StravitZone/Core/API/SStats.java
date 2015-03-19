package com.StravitZone.Core.API;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.StravitZone.Core.Main;

public class SStats implements Listener {

	public static void saveStats() {
		try {
			Main.stats.save(Main.statsFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getKills(String player) {
	return Main.stats.getInt("Players." + player + ".Kills");

	}

	public static void addKill(String player) {
		Main.stats.set("Players." + player + ".Kills", getKills(player) + 1);
		saveStats();
	}

	public static int getDeaths(String player) {

			return Main.stats.getInt("Players." + player + ".Deaths");
	}
	
	public static double getKDR(String player){
		if(getKills(player) == 0 && getDeaths(player) == 0){
			return 0.0;
		} else {
			return getKills(player) / getDeaths(player);
		}
	}

	public static void addDeath(String player) {
		Main.stats.set("Players." + player + ".Deaths", getDeaths(player) + 1);
		saveStats();
	}

}
