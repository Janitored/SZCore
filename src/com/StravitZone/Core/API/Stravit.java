package com.StravitZone.Core.API;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class Stravit extends JavaPlugin{
	
	
	private static Stravit plugin;
	
	public Stravit(){
		plugin = this;
	}
	
	public static Stravit getInstance(){
		return plugin;
	}
    
	
	public abstract void onEnable();
	public abstract void onDisable();

}