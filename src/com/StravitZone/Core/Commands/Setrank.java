package com.StravitZone.Core.Commands;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.StravitZone.Core.API.Rank;
import com.StravitZone.Core.API.Stravit;
import com.StravitZone.Core.API.StravitCommand;

public class Setrank extends StravitCommand {
	
	
	public static Map<Player, UUID> owner = new HashMap<>();
	public static Map<Player, UUID> admin = new HashMap<>();
	public static Map<Player, UUID> dev = new HashMap<>();
	public static Map<Player, UUID> vip = new HashMap<>();
	public static Map<Player, UUID> builder = new HashMap<>();
	public static Map<Player, UUID> mod = new HashMap<>();
	public static Map<Player, UUID> all = new HashMap<>();
	

	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("setrank")) {
				if (!p.hasPermission(Rank.ADMIN)) {
					p.sendMessage(Stravit.getPrefix()
							+ " §c§lERROR: You need §c§oADMIN §c§lfor this command.");
				} else if(p.hasPermission(Rank.ADMIN) || p.hasPermission(Rank.OWNER) || p.hasPermission(Rank.DEVELOPER)){
					if(args.length == 0){
					p.sendMessage(Stravit.getPrefix() + " §c§lERROR: Usage: /setrank <User> <Rank>");
					}
					
					else if(args.length == 1){
						Player target = Bukkit.getPlayer(args[0]);
						p.sendMessage(Stravit.getPrefix() + " §c§lERROR: Please specify a rank!");
					}
					
					else if(args[1].equalsIgnoreCase("owner")){
						Player target = Bukkit.getPlayer(args[0]);
						p.sendMessage(Stravit.getPrefix() + " §a§lSet §a§o" + target.getName() + "§a§l's rank to §4§oOWNER§a§l.");
						target.setDisplayName("§4[OWNER] §f" + target.getName());
						target.sendMessage(Stravit.getPrefix() + " §a§lYour rank has been set to §4§oOWNER§a§l.");
						owner.put(target, target.getUniqueId());
					}
					
					else if(args[1].equalsIgnoreCase("admin")){
						Player target = Bukkit.getPlayer(args[0]);
						p.sendMessage(Stravit.getPrefix() + " §a§lSet §a§o" + target.getName() + "§a§l's rank to §c§oADMIN§a§l.");
						target.setDisplayName("§c[ADMIN] §f" + target.getName());
						target.sendMessage(Stravit.getPrefix() + " §a§lYour rank has been set to §c§oADMIN§a§l.");
						admin.put(target, target.getUniqueId());
					}
					
					else if(args[1].equalsIgnoreCase("dev")){
						Player target = Bukkit.getPlayer(args[0]);
						p.sendMessage(Stravit.getPrefix() + " §a§lSet §a§o" + target.getName() + "§a§l's rank to §e§oDEVELOPER§a§l.");
						target.setDisplayName("§e[DEV] §f" + target.getName());
						target.sendMessage(Stravit.getPrefix() + " §a§lYour rank has been set to §e§oDEVELOPER§a§l.");
						dev.put(target, target.getUniqueId());
					}
					
					else if(args[1].equalsIgnoreCase("mod")){
						Player target = Bukkit.getPlayer(args[0]);
						p.sendMessage(Stravit.getPrefix() + " §a§lSet §a§o" + target.getName() + "§a§l's rank to §9§oMOD§a§l.");
						target.setDisplayName("§9[MOD] §f" + target.getName());
						target.sendMessage(Stravit.getPrefix() + " §a§lYour rank has been set to §9§oMOD§a§l.");
						mod.put(target, target.getUniqueId());
					}
					
					else if(args[1].equalsIgnoreCase("vip")){
						Player target = Bukkit.getPlayer(args[0]);
						p.sendMessage(Stravit.getPrefix() + " §a§lSet §a§o" + target.getName() + "§a§l's rank to §6§oVIP§a§l.");
						target.setDisplayName("§6[VIP] §f" + target.getName());
						target.sendMessage(Stravit.getPrefix() + " §a§lYour rank has been set to §6§oVIP§a§l.");
						vip.put(target, target.getUniqueId());
					}
					
					else if(args[1].equalsIgnoreCase("builder")){
						Player target = Bukkit.getPlayer(args[0]);
						p.sendMessage(Stravit.getPrefix() + " §a§lSet §a§o" + target.getName() + "§a§l's rank to §a§oBUILDER§a§l.");
						target.setDisplayName("§a[BUILDER] §f" + target.getName());
						target.sendMessage(Stravit.getPrefix() + " §a§lYour rank has been set to §a§oBUILDER§a§l.");
						builder.put(target, target.getUniqueId());
					}
					
					else if(args[1].equalsIgnoreCase("player")){
						Player target = Bukkit.getPlayer(args[0]);
						p.sendMessage(Stravit.getPrefix() + " §a§lSet §a§o" + target.getName() + "§a§l's rank to §7§oPLAYER§a§l.");
						target.setDisplayName("§7" + target.getName());
						target.sendMessage(Stravit.getPrefix() + " §a§lYour rank has been set to §7§oPLAYER§a§l.");
						all.put(target, target.getUniqueId());
					}
					
				}
			}
		return true;
	}

}