package com.StravitZone.Core.API;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.StravitZone.Core.Main;

public class AchievementManager implements Listener{
	
	private static List<String> newcomer = Main.achieve.getStringList("CompletedNewcomer.");
	private static List<String> firstkill = Main.achieve.getStringList("CompletedFirstKill.");
	private static List<String> firstdeath = Main.achieve.getStringList("CompletedFirstDeath.");
	
	public static List<Player> compnew = new ArrayList<Player>();
	public static List<Player> compfk = new ArrayList<Player>();
	public static List<Player> compfd = new ArrayList<Player>();
	
	public static boolean completedNewcomer(Player p){
		return newcomer.contains(p.getName());
	}
	
	public static boolean completedfirstKill(Player p){
		return firstkill.contains(p.getName());
	}
	
	public static boolean completedfirstDeath(Player p){
		return firstdeath.contains(p.getName());
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent e){
		if(compnew.contains(e.getPlayer().getUniqueId())){
			compnew.remove(e.getPlayer());
			newcomer.add(e.getPlayer().getName());
			Main.achieve.set("CompletedNewcomer." + e.getPlayer(), newcomer);
			try{
				Main.achieve.save(Main.achievements);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		if(compfk.contains(e.getPlayer().getUniqueId())){
			compfk.remove(e.getPlayer());
			firstkill.add(e.getPlayer().getName());
			Main.achieve.set("CompletedFirstKill." + e.getPlayer(), firstkill);
			try{
				Main.achieve.save(Main.achievements);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		if(compfd.contains(e.getPlayer().getUniqueId())){
			compfd.remove(e.getPlayer());
		  firstdeath.add(e.getPlayer().getName());
			Main.achieve.set("CompletedFirstDeath." + e.getPlayer(), firstdeath);
			try{
				Main.achieve.save(Main.achievements);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	

}
