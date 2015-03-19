package com.StravitZone.Core.API;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.StravitZone.Core.Main;

public class BossBar {

	private static Random r = new Random();

	private static List<String> list = new ArrayList<>();

	public static void enable() {
		
		// Message 1

		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&1&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&2&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&3&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&4&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&5&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&6&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&7&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&8&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&9&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&a&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&b&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&c&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&d&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&e&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&f&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&1&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&2&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&3&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		
		// Message 2
		
		/*list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));*/
		
		// Message 3
		
		/*list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));*/
		
		// Message 4
		
		/*list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));*/
		
		// Message 5
		
		/*list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));
		list.add(colorize("&0&lSTRAVITZONE §7-§f &lVersion 3.0 RELEASED!"));*/

		showBarChanging();

	}

	private static String colorize(String input) {
		return ChatColor.translateAlternateColorCodes('&', input);
	}

	public static void showBarChanging() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(),
				new Runnable() {
					public void run() {
						String message = (String) list.get(r.nextInt(list
								.size()));

						for (Player p : Bukkit.getOnlinePlayers()) {
							BarAPI.setMessage(p, message);
						}
					}
				}, 0L, 4L);
	}

}
