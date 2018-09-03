package com.sparcsky.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;
import com.sparcsky.game.core.KalawakanImpakto;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Kalawakan Impakto";
     /*   config.width = 200;
        config.height = 200;
        config.posY = 500;
        config.posX = 800;*/
        new LwjglApplication(new KalawakanImpakto(), config);
    }
}
