package com.StravitZone.Core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;

import com.StravitZone.Core.API.AutoBroadcaster;
import com.StravitZone.Core.API.BossBar;
import com.StravitZone.Core.API.LockedChatHandler;
import com.StravitZone.Core.API.MOTD;
import com.StravitZone.Core.API.MuteHandlers;
import com.StravitZone.Core.API.PlayerManager;
import com.StravitZone.Core.API.RankChat;
import com.StravitZone.Core.API.RankHandlers;
import com.StravitZone.Core.API.SStats;
import com.StravitZone.Core.API.ServerManager;
import com.StravitZone.Core.API.Stravit;
import com.StravitZone.Core.Commands.Addworld;
import com.StravitZone.Core.Commands.Broadcast;
import com.StravitZone.Core.Commands.Chat;
import com.StravitZone.Core.Commands.Commandban;
import com.StravitZone.Core.Commands.Commandrank;
import com.StravitZone.Core.Commands.Credit;
import com.StravitZone.Core.Commands.Credits;
import com.StravitZone.Core.Commands.DataReload;
import com.StravitZone.Core.Commands.Deleteworld;
import com.StravitZone.Core.Commands.Game;
import com.StravitZone.Core.Commands.Giveaway;
import com.StravitZone.Core.Commands.Kick;
import com.StravitZone.Core.Commands.Lock;
import com.StravitZone.Core.Commands.Lookup;
import com.StravitZone.Core.Commands.Mute;
import com.StravitZone.Core.Commands.Ping;
import com.StravitZone.Core.Commands.Restore;
import com.StravitZone.Core.Commands.Server;
import com.StravitZone.Core.Commands.StaffChat;
import com.StravitZone.Core.Commands.Stats;
import com.StravitZone.Core.Commands.Team;
import com.StravitZone.Core.Commands.Tpworld;
import com.StravitZone.Core.Commands.Tut;
import com.StravitZone.Core.Commands.Unban;
import com.StravitZone.Core.Commands.Unmute;
import com.StravitZone.Core.Commands.Worlds;
import com.StravitZone.Core.Game.Bow;
import com.StravitZone.Core.Game.GameManager;
import com.StravitZone.Core.Game.OCN;
import com.StravitZone.Core.Game.Soup;
import com.StravitZone.Core.Listeners.BanJoin;
import com.StravitZone.Core.Listeners.CombatTag;
import com.StravitZone.Core.Listeners.Death;
import com.StravitZone.Core.Listeners.Hunger;
import com.StravitZone.Core.Listeners.ItemClick;
import com.StravitZone.Core.Listeners.Join;
import com.StravitZone.Core.Listeners.Quit;
import com.StravitZone.Core.Listeners.ServerLockHandler;
import com.StravitZone.Core.Listeners.TutorialHandler;

public class Main extends Stravit {

	public static File statsFile;
	public static FileConfiguration stats;

	public static File rankData;
	public static FileConfiguration rankdata;

	public static File creditsData;
	public static FileConfiguration creditsdata;
	
	public static File creditValues;
	public static FileConfiguration creditvalues;

	public void onEnable() {

		PluginManager listeners = getServer().getPluginManager();

		AutoBroadcaster.enable();

		BossBar.enable();

		ServerManager.generateWorlds();

		// Config

		creditsData = new File(this.getDataFolder(), "creditsdata.yml");
		creditsdata = YamlConfiguration.loadConfiguration(creditsData);

		if (!creditsData.exists()) {
			creditsdata.options().copyDefaults(true);
		}

		statsFile = new File(getDataFolder(), "stats.yml");
		stats = YamlConfiguration.loadConfiguration(statsFile);

		if (!statsFile.exists()) {
			stats.options().copyDefaults(true);
		}

		rankData = new File(getDataFolder(), "rankdata.yml");
		rankdata = YamlConfiguration.loadConfiguration(rankData);

		if (!rankData.exists()) {
			rankdata.options().copyDefaults(true);
		}
		
		creditValues = new File(getDataFolder(), "creditvalues.yml");
		creditvalues = YamlConfiguration.loadConfiguration(creditValues);
		
		if (!creditValues.exists()) {
			creditvalues.options().copyDefaults(true);
		}

		// Loading Data

		try {
			creditsdata.load(creditsData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}

		try {
			stats.load(statsFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}

		try {
			rankdata.load(rankData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
		try {
			creditvalues.load(creditValues);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}

		// Listeners

		listeners.registerEvents(new RankChat(), this);
		listeners.registerEvents(new MOTD(), this);
		listeners.registerEvents(new Join(), this);
		listeners.registerEvents(new Quit(), this);
		listeners.registerEvents(new OCN(), this);
		listeners.registerEvents(new Bow(), this);
		listeners.registerEvents(new ItemClick(), this);
		listeners.registerEvents(new MuteHandlers(), this);
		listeners.registerEvents(new BanJoin(), this);
		listeners.registerEvents(new Death(), this);
		listeners.registerEvents(new LockedChatHandler(), this);
		listeners.registerEvents(new TutorialHandler(), this);
		listeners.registerEvents(new Soup(), this);
		listeners.registerEvents(new PlayerManager(), this);
		listeners.registerEvents(new CombatTag(), this);
		listeners.registerEvents(new Hunger(), this);
		listeners.registerEvents(new RankHandlers(), this);
		listeners.registerEvents(new ServerLockHandler(), this);
		listeners.registerEvents(new GameManager(), this);
		listeners.registerEvents(new SStats(), this);

		// Commands

		getCommand("rank").setExecutor(new Commandrank());
		getCommand("ban").setExecutor(new Commandban());
		getCommand("kick").setExecutor(new Kick());
		getCommand("mute").setExecutor(new Mute());
		getCommand("unmute").setExecutor(new Unmute());
		getCommand("unban").setExecutor(new Unban());
		getCommand("restore").setExecutor(new Restore());
		getCommand("addworld").setExecutor(new Addworld());
		getCommand("tpworld").setExecutor(new Tpworld());
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("lockchat").setExecutor(new Chat());
		getCommand("clearchat").setExecutor(new Chat());
		getCommand("game").setExecutor(new Game());
		getCommand("giveaway").setExecutor(new Giveaway());
		getCommand("tutorial").setExecutor(new Tut());
		getCommand("worlds").setExecutor(new Worlds());
		getCommand("staffchat").setExecutor(new StaffChat());
		getCommand("deleteworld").setExecutor(new Deleteworld());
		getCommand("team").setExecutor(new Team());
		getCommand("who").setExecutor(new Lookup());
		getCommand("ping").setExecutor(new Ping());
		getCommand("server").setExecutor(new Server());
		getCommand("lock").setExecutor(new Lock());
		getCommand("credits").setExecutor(new Credits());
		getCommand("credit").setExecutor(new Credit());
		getCommand("stats").setExecutor(new Stats());
		getCommand("datareload").setExecutor(new DataReload());

	}

	public void onDisable() {

		// Saving Data

		try {
			creditsdata.save(creditsData);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			rankdata.save(rankData);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			stats.save(statsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			creditvalues.save(creditValues);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
