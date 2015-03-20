package com.StravitZone.Core.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;

import com.StravitZone.Core.Main;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerOptions;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;

public class PCMessage {
	
	public static void enable(){
		
		 final List<WrappedGameProfile> names = new ArrayList<WrappedGameProfile>();
	        names.add(new WrappedGameProfile("1", "§c§l>> §6§lStravitZone §c§l<<"));
	        names.add(new WrappedGameProfile("2", "§4------------------------------"));
	        names.add(new WrappedGameProfile("3", "§c§l>> §a§lVersion 3.0 §c§l<<"));
	        names.add(new WrappedGameProfile("4", "§4------------------------------"));
	        names.add(new WrappedGameProfile("5", "§c§l>> §9§l1.7.9/1.7.10 §c§l<<"));
	        names.add(new WrappedGameProfile("6", "§4------------------------------"));
	        names.add(new WrappedGameProfile("7", "§c§l>> §bwww.StravitZone.enjin.com §c§l<<"));
	        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(Main.getInstance(), ListenerPriority.NORMAL,
	                Arrays.asList(PacketType.Status.Server.OUT_SERVER_INFO), ListenerOptions.ASYNC) {
	                @Override
	                public void onPacketSending(PacketEvent event) {
	                    event.getPacket().getServerPings().read(0).setPlayers(names);
	                }
	            });
		
	}

}