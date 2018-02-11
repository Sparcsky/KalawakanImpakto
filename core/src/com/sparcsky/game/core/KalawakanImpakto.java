package com.sparcsky.game.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sparcsky.game.Assets;
import com.sparcsky.game.ScreenManager;
import com.sparcsky.game.screen.SplashScreen;

public class KalawakanImpakto extends Game {

    public SpriteBatch batch;
    public ScreenManager screens;

    @Override
    public void create() {
        batch = new SpriteBatch();

        screens = new ScreenManager(this);
        screens.push(new SplashScreen(this));
    }

    @Override
    public void render() {
        screens.render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        batch.dispose();
        Assets.getInstance().dispose();
    }
}
