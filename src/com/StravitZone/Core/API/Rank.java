package com.StravitZone.Core.API;

import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import com.StravitZone.Core.Main;

public class Rank {
	
	public static Permission admin = new Permission("sz.admin");
	public static Permission moderator = new Permission("sz.mod");
	public static Permission vip = new Permission("sz.donor.vip");
	public static Permission builder = new Permission("sz.builder");
	public static Permission all = new Permission("sz.default");

}
