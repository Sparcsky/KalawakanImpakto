package com.sparcsky.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sparcsky.game.core.KalawakanImpakto;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Kalawakan Impakto";
		new LwjglApplication(new KalawakanImpakto(), config);
	}
}
