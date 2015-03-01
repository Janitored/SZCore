package com.StravitZone.Core.API;

import org.bukkit.entity.Player;

public class RankManager {

	private Player p;

	public RankManager() {

		if (p.getDisplayName().startsWith("§4[OWNER]")) {
			p.addAttachment(Stravit.getInstance(), "sz.owner", true);
			p.addAttachment(Stravit.getInstance(), "sz.admin", false);
			p.addAttachment(Stravit.getInstance(), "sz.vip", false);
			p.addAttachment(Stravit.getInstance(), "sz.builder", false);
			p.addAttachment(Stravit.getInstance(), "sz.all", false);
			p.addAttachment(Stravit.getInstance(), "sz.developer", false);
			p.addAttachment(Stravit.getInstance(), "sz.moderator", false);
			p.setOp(true);
		}

		if (p.getDisplayName().startsWith("§c[ADMIN]")) {
			p.addAttachment(Stravit.getInstance(), "sz.owner", false);
			p.addAttachment(Stravit.getInstance(), "sz.admin", true);
			p.addAttachment(Stravit.getInstance(), "sz.vip", false);
			p.addAttachment(Stravit.getInstance(), "sz.builder", false);
			p.addAttachment(Stravit.getInstance(), "sz.all", false);
			p.addAttachment(Stravit.getInstance(), "sz.developer", false);
			p.addAttachment(Stravit.getInstance(), "sz.moderator", false);
			p.setOp(true);
		}

		if (p.getDisplayName().startsWith("§9[MOD]")) {
			p.addAttachment(Stravit.getInstance(), "sz.owner", false);
			p.addAttachment(Stravit.getInstance(), "sz.admin", false);
			p.addAttachment(Stravit.getInstance(), "sz.vip", false);
			p.addAttachment(Stravit.getInstance(), "sz.builder", false);
			p.addAttachment(Stravit.getInstance(), "sz.all", false);
			p.addAttachment(Stravit.getInstance(), "sz.developer", false);
			p.addAttachment(Stravit.getInstance(), "sz.moderator", true);
		}

		if (p.getDisplayName().startsWith("§a[BUILDER]")) {
			p.addAttachment(Stravit.getInstance(), "sz.owner", false);
			p.addAttachment(Stravit.getInstance(), "sz.admin", false);
			p.addAttachment(Stravit.getInstance(), "sz.vip", false);
			p.addAttachment(Stravit.getInstance(), "sz.builder", true);
			p.addAttachment(Stravit.getInstance(), "sz.all", false);
			p.addAttachment(Stravit.getInstance(), "sz.developer", false);
			p.addAttachment(Stravit.getInstance(), "sz.moderator", false);
		}

		if (p.getDisplayName().startsWith("§6[VIP]")) {
			p.addAttachment(Stravit.getInstance(), "sz.owner", false);
			p.addAttachment(Stravit.getInstance(), "sz.admin", false);
			p.addAttachment(Stravit.getInstance(), "sz.vip", true);
			p.addAttachment(Stravit.getInstance(), "sz.builder", false);
			p.addAttachment(Stravit.getInstance(), "sz.all", false);
			p.addAttachment(Stravit.getInstance(), "sz.developer", false);
			p.addAttachment(Stravit.getInstance(), "sz.moderator", false);
		}

		if (p.getDisplayName().startsWith("§7")) {
			p.addAttachment(Stravit.getInstance(), "sz.owner", false);
			p.addAttachment(Stravit.getInstance(), "sz.admin", false);
			p.addAttachment(Stravit.getInstance(), "sz.vip", false);
			p.addAttachment(Stravit.getInstance(), "sz.builder", false);
			p.addAttachment(Stravit.getInstance(), "sz.all", true);
			p.addAttachment(Stravit.getInstance(), "sz.developer", false);
			p.addAttachment(Stravit.getInstance(), "sz.moderator", false);
		}

	}

}
