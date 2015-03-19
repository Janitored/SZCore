package com.StravitZone.Core.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class PlayerDamageByPlayerEvent implements Cancellable{
	
	  private final Player damager;
	  private final Player damagee;
	  private boolean cancelled;
	  
	  public PlayerDamageByPlayerEvent(Player damager, Player damagee, PlayerDamageEvent.DamageCause cause, double damage)
	  {
	    this.damager = damager;
	    this.damagee = damagee;
	  }
	  
	  public Player getDamager()
	  {
	    return this.damager;
	  }
	  
	  public Player getDamaged(){
		  return this.damagee;
	  }

	public void setCancelled(boolean cancel) {
		
		this.cancelled = cancel;
		
	}

	
	public boolean isCancelled() {
		return this.cancelled;
	}

}
