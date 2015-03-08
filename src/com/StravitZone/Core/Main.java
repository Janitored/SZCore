package com.StravitZone.Core;



import org.bukkit.plugin.PluginManager;

import com.StravitZone.Core.API.MOTD;
import com.StravitZone.Core.API.MuteHandlers;
import com.StravitZone.Core.API.RankChat;
import com.StravitZone.Core.API.RankHandlers;
import com.StravitZone.Core.API.Stravit;
import com.StravitZone.Core.Commands.Commandban;
import com.StravitZone.Core.Commands.Commandrank;
import com.StravitZone.Core.Commands.Kick;
import com.StravitZone.Core.Commands.Mute;
import com.StravitZone.Core.Commands.Restore;
import com.StravitZone.Core.Commands.State;
import com.StravitZone.Core.Commands.Unban;
import com.StravitZone.Core.Commands.Unmute;
import com.StravitZone.Core.Listeners.BanJoin;
import com.StravitZone.Core.Listeners.BowGamesInvClick;
import com.StravitZone.Core.Listeners.ItemClick;
import com.StravitZone.Core.Listeners.Join;
import com.StravitZone.Core.Listeners.OCNInvClick;
import com.StravitZone.Core.Listeners.Quit;



public class Main extends Stravit {

	
	public void onEnable() {
	
		PluginManager listeners = getServer().getPluginManager();
		
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
		
		// Commands
		
		getCommand("rank").setExecutor(new Commandrank());
		getCommand("ban").setExecutor(new Commandban());
		getCommand("kick").setExecutor(new Kick());
		getCommand("mute").setExecutor(new Mute());
		getCommand("unmute").setExecutor(new Unmute());
		getCommand("unban").setExecutor(new Unban());
		getCommand("restore").setExecutor(new Restore());
		getCommand("about").setExecutor(new State());
		getCommand("setstate").setExecutor(new State());
	}


	public void onDisable() {

	}

}
