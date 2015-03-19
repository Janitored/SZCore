package com.StravitZone.Core.Game;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class GameManager implements Listener{
	
	// TeleSnipe handler
	
	@EventHandler
	public void projectile(ProjectileHitEvent e){
		Projectile pr = e.getEntity();
		
		Player p = (Player) pr.getShooter();
		
		if(pr instanceof Arrow){
			if(pr.getShooter() instanceof Player){
				if(p.getWorld().getName().equals("TeleSnipe")){
					p.teleport(pr.getLocation());
				}
			}
		}
		
	}
	
	// Soup Heal Handler
	
	@EventHandler
	public void interact(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Action a = e.getAction();
		
		if(p.getItemInHand().getType() == Material.MUSHROOM_SOUP){
			if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
				p.playSound(p.getLocation(), Sound.EAT, 1, 1);
				p.getItemInHand().setType(Material.BOWL);
				p.setHealth(p.getHealth() + 3.2);
			}
		}
		
	}
	
	// Soup Drop Handler
	
	@EventHandler
	public void drop(PlayerDropItemEvent e){
		
		if(e.getItemDrop().getType().equals(Material.BOWL)){
			e.getItemDrop().remove();
		}
		
	}
	
	// OITC Handler
	
	 @EventHandler
	  public void onShoot(EntityDamageByEntityEvent event)
	  {
		if (((event.getDamager() instanceof Projectile))){
	      Projectile p = (Projectile)event.getDamager();
	      if (p.getType() == EntityType.ARROW)
	      {
	        Player player = (Player)event.getEntity();
	        if(player.getWorld().getName().equals("OITC")){
	        player.setHealth(0.0D);
	        }
	      }
	    }
	  }

}
