package com.StravitZone.Core.API;

import com.StravitZone.Core.Main;

public enum PluginState {

	BETA("§cBeta"), ALPHA("§2Alpha"), RELEASE("§aRelease");

	PluginState(String s) {
	}

	public static String getState() {
		return Main.getInstance().getConfig().get("State").toString();
	}
	
	public static PluginState setState(PluginState state){
		Main.getInstance().getConfig().set("State", state);
		return state;
	}
}