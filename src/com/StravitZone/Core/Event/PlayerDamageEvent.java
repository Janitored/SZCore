package com.StravitZone.Core.Event;


import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.util.NumberConversions;

public class PlayerDamageEvent extends EntityEvent implements Cancellable{
	
	 private static final HandlerList handlers = new HandlerList();
	 
	  private double damage;
	  private boolean cancelled;
	  private final DamageCause cause;
	  private Player damagee;
	  
	  @Deprecated
	  public PlayerDamageEvent(Player damagee, DamageCause cause, double damage)
	  {
	    super(damagee);
	    this.cause = cause;
	    this.damage = damage;
	    this.damagee = damagee;
	  }
	  
	  public boolean isCancelled()
	  {
	    return this.cancelled;
	  }
	  
	  public void setCancelled(boolean cancel)
	  {
	    this.cancelled = cancel;
	  }
	  
	  public double getDamage()
	  {
	    return this.damage;
	  }
	  
	  @Deprecated
	  public int _INVALID_getDamage()
	  {
	    return NumberConversions.ceil(getDamage());
	  }
	  
	  public void setDamage(double damage)
	  {
	    this.damage = damage;
	  }
	  
	  @Deprecated
	  public void _INVALID_setDamage(int damage)
	  {
	    setDamage(damage);
	  }
	  
	  public DamageCause getCause()
	  {
	    return this.cause;
	  }
	  
	  public HandlerList getHandlers()
	  {
	    return handlers;
	  }
	  
	  public Player getPlayer(){
		  return this.damagee = damagee;
	  }
	  
	  public static HandlerList getHandlerList()
	  {
	    return handlers;
	  }
	  
	  public static enum DamageCause
	  {
	    CONTACT,  ENTITY_ATTACK,  PROJECTILE,  SUFFOCATION,  FALL,  FIRE,  FIRE_TICK,  MELTING,  LAVA,  DROWNING,  BLOCK_EXPLOSION,  ENTITY_EXPLOSION,  VOID,  LIGHTNING,  SUICIDE,  STARVATION,  POISON,  MAGIC,  WITHER,  FALLING_BLOCK,  THORNS,  CUSTOM;
	    
	    private DamageCause() {}
	  }

}
