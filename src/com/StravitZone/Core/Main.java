package com.StravitZone.Core;



import org.bukkit.plugin.PluginManager;

import com.StravitZone.Core.API.AutoBroadcaster;
import com.StravitZone.Core.API.LockedChatHandler;
import com.StravitZone.Core.API.MOTD;
import com.StravitZone.Core.API.MuteHandlers;
import com.StravitZone.Core.API.RankChat;
import com.StravitZone.Core.API.RankHandlers;
import com.StravitZone.Core.API.Stravit;
import com.StravitZone.Core.Commands.Addworld;
import com.StravitZone.Core.Commands.Broadcast;
import com.StravitZone.Core.Commands.Chat;
import com.StravitZone.Core.Commands.Commandban;
import com.StravitZone.Core.Commands.Commandrank;
import com.StravitZone.Core.Commands.Game;
import com.StravitZone.Core.Commands.Giveaway;
import com.StravitZone.Core.Commands.Kick;
import com.StravitZone.Core.Commands.Mute;
import com.StravitZone.Core.Commands.Restore;
import com.StravitZone.Core.Commands.Tpworld;
import com.StravitZone.Core.Commands.Tut;
import com.StravitZone.Core.Commands.Unban;
import com.StravitZone.Core.Commands.Unmute;
import com.StravitZone.Core.Listeners.BanJoin;
import com.StravitZone.Core.Listeners.BowGamesInvClick;
import com.StravitZone.Core.Listeners.Death;
import com.StravitZone.Core.Listeners.ItemClick;
import com.StravitZone.Core.Listeners.Join;
import com.StravitZone.Core.Listeners.OCNInvClick;
import com.StravitZone.Core.Listeners.Quit;
import com.StravitZone.Core.Listeners.StaffChat;
import com.StravitZone.Core.Listeners.TutorialHandler;



public class Main extends Stravit {

	
	public void onEnable() {
	
		PluginManager listeners = getServer().getPluginManager();
		
		AutoBroadcaster.enable();
		
		// Listeners
		
		listeners.registerEvents(new RankChat(), this);
		listeners.registerEvents(new MOTD(), this);
		listeners.registerEvents(new Join(), this);
		listeners.registerEvents(new Quit(), this);
		listeners.registerEvents(new OCNInvClick(), this);
		listeners.registerEvents(new BowGamesInvClick(), this);
		listeners.registerEvents(new ItemClick(), this);
		listeners.registerEvents(new RankHandlers(), this);
		listeners.registerEvents(new MuteHandlers(), this);
		listeners.registerEvents(new BanJoin(), this);
		listeners.registerEvents(new Death(), this);
		listeners.registerEvents(new LockedChatHandler(), this);
		listeners.registerEvents(new StaffChat(), this);
		listeners.registerEvents(new TutorialHandler(), this);
		
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
	}


	public void onDisable() {

	}

}
