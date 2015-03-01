package com.StravitZone.Core.Commands;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;


public class Rank {

	public enum RankType {

		OWNER("§4§lOWNER §f"), DEVELOPER("§e§lDEV §f"), ADMIN("§c§lADMIN §f"), MODERATOR(
				"§9§lMOD §f"), VIP("§6§lVIP §f"), BUILDER("§a§lBUILDER §f");

		private String s;

		RankType(String s) {
			this.s = s;
		}

		public static String getPrefix(RankType type) {
			return type.s;
		}
		
		public static Map<UUID, RankType> rank = new HashMap<UUID, RankType>();
		
		public static boolean setRank(UUID uuid, RankType rank){
			return false;
		}
		
		public static Map<UUID, RankType> getRank(UUID uuid){
			return rank;
		}

	}

}