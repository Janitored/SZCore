package com.StravitZone.Core.API;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class Stravit extends JavaPlugin{
	
	
	private static Stravit plugin;
	
	private static String prefix = "§6§lSZ §c>>";
	
	public Stravit(){
		plugin = this;
	}
	
	public static Stravit getInstance(){
		return plugin;
	}
	
	public static String getPrefix(){
		return prefix;
	}
	
	public abstract void onEnable();
	public abstract void onDisable();

}