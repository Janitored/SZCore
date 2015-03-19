package com.StravitZone.Core.API;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.StravitZone.Core.Utils.Day;
import com.StravitZone.Core.Utils.Month;

public class MOTD implements Listener {

	@EventHandler
	public void motd(ServerListPingEvent e) {

		int i = new Random().nextInt(10);

		e.setMaxPlayers(Bukkit.getOnlinePlayers().length + 1);

		if (ServerManager.isLocked()) {
			e.setMotd("§6§lStravitZone§7: §b§l#3.0Hype! \n §cWe are currently in §4§lLOCKDOWN §cmode!");
		}
		
		else if (!ServerManager.isLocked()) {

			if (i == 10) {
				e.setMotd("§6§lStravitZone§7: §b§l#3.0Hype! \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}

			if (i == 9) {
				e.setMotd("§6§lStravitZone§7: §b§lAre you ready?! \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}

			if (i == 8) {
				e.setMotd("§6§lStravitZone§7: §b§lI'm not peppery! \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}

			if (i == 7) {
				e.setMotd("§6§lStravitZone§7: §b§lAll about that bass. \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}

			if (i == 6) {
				e.setMotd("§6§lStravitZone§7: §b§l360noscopedezpzm8getrekt \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}
			
			if(i == 5){
				e.setMotd("§6§lStravitZone§7: §b§lPshht, who needs coffee? \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}
			
			if(i == 4){
				e.setMotd("§6§lStravitZone§7: §b§lJan is a turd \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}
			
			if(i == 3){
				e.setMotd("§6§lStravitZone§7: §b§lJoe stinks \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}
			
			if(i == 2){
				e.setMotd("§6§lStravitZone§7: §b§lKam can swim! \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}
			
			if(i == 1){
				e.setMotd("§6§lStravitZone§7: §b§lSTOP REFRESHING! \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}
			
			if(i == 0){
				i = 10;
			}
			
			if(Month.isDecember()){
				e.setMotd("§6§lStravitZone§7: §a§lHave you been §4§lnice? \n §a§l5X CHRISTMAS CREDIT BOOSTER ACTIVE!");
			}
			
			if(Day.isFriday()){
				e.setMotd("§6§lStravitZone§7: §a§lHappy Friday! \n §c§lWe are currently under §4§lDEVELOPMENT§c.");
			}
			
		}

	}
}
