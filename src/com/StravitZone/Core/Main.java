package com.StravitZone.Core;



import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import com.StravitZone.Core.API.Stravit;
import com.StravitZone.Core.Commands.Setrank;

public class Main extends Stravit {
	
	private static FileConfiguration config;
	
	private Player p;


	public void onEnable() {

		PluginManager listeners = getServer().getPluginManager();
		
		getCommand("setrank").setExecutor(new Setrank());
		
		config.addDefault("isOwner", null);
		config.addDefault("isAdmin", null);
		config.addDefault("isMod", null);
		config.addDefault("isVip", null);
		config.addDefault("isBuilder", null);
		config.addDefault("isDev", null);
		config.addDefault("isDefault", p.getName());
		config.options().copyDefaults(true);
		saveConfig();
		
	}


	public void onDisable() {

	}

}
