package com.StravitZone.Core.API;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;

import com.StravitZone.Core.Main;

public class ServerManager {
	
	public static void restart() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				List<String> args = ManagementFactory.getRuntimeMXBean()
						.getInputArguments();
				List<String> command = new ArrayList<String>();
				command.add(System.getProperty("java.home") + File.separator
						+ "bin" + File.separator + "java.exe");
				for (int i = 0; i < args.size(); i++) {
					command.add(args.get(i));
				}
				command.add("-jar");
				command.add(new File(Bukkit.class.getProtectionDomain()
						.getCodeSource().getLocation().getFile())
						.getAbsolutePath());
				try {
					new ProcessBuilder(command).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Bukkit.shutdown();
	}
	
	public static boolean isLocked(){
		return Bukkit.getServer().hasWhitelist() == true;
	}
	
	public static void lockServer(){
		Bukkit.getServer().setWhitelist(true);
	}
	
	public static void unlockServer(){
		Bukkit.getServer().setWhitelist(false);
	}
	
	public static void generateWorlds(){
		
		// Main Hub
		
		Bukkit.getServer().createWorld(new WorldCreator("Hub"));
		
		// Game Waiting Lobbies
		
		Bukkit.getServer().createWorld(new WorldCreator("OCNWait"));
		Bukkit.getServer().createWorld(new WorldCreator("BowWait"));
		Bukkit.getServer().createWorld(new WorldCreator("PotionWait"));
		Bukkit.getServer().createWorld(new WorldCreator("SoupWait"));
		
		// Potion Game Worlds
		
		Bukkit.getServer().createWorld(new WorldCreator("Kohi"));
		Bukkit.getServer().createWorld(new WorldCreator("NoDebuff"));
		Bukkit.getServer().createWorld(new WorldCreator("PotAndSoup"));
		Bukkit.getServer().createWorld(new WorldCreator("TeleSnipe"));
		Bukkit.getServer().createWorld(new WorldCreator("NoHeal"));
		Bukkit.getServer().createWorld(new WorldCreator("NoSplash"));
		
		// Bow Game Worlds
		
		Bukkit.getServer().createWorld(new WorldCreator("TeleSnipe"));
		Bukkit.getServer().createWorld(new WorldCreator("SumoSnipe"));
		Bukkit.getServer().createWorld(new WorldCreator("SharpShooter"));
		Bukkit.getServer().createWorld(new WorldCreator("OITC"));
		Bukkit.getServer().createWorld(new WorldCreator("TeleSnipe"));
		Bukkit.getServer().createWorld(new WorldCreator("FlameSnipe"));
		
		// Soup Game Worlds
		
		Bukkit.getServer().createWorld(new WorldCreator("SoupFFA"));
		Bukkit.getServer().createWorld(new WorldCreator("SoupAndSnipe"));
		Bukkit.getServer().createWorld(new WorldCreator("TeleSnipe"));
		Bukkit.getServer().createWorld(new WorldCreator("SoupAndDebuff"));
		Bukkit.getServer().createWorld(new WorldCreator("SoupAndSwift"));
		Bukkit.getServer().createWorld(new WorldCreator("SoupMCSG"));
		
	}
	
	public static void reloadData(){
		
		// Rank Data
		
		Main.rankdata = YamlConfiguration.loadConfiguration(Main.rankData);
		
		// Credits Data
		
		Main.creditsdata = YamlConfiguration.loadConfiguration(Main.creditsData);
		
		// Stats Data
		
		Main.stats = YamlConfiguration.loadConfiguration(Main.statsFile);
		
		// Credit Value Data
		
		Main.creditvalues = YamlConfiguration.loadConfiguration(Main.creditValues);
		
	}

}
