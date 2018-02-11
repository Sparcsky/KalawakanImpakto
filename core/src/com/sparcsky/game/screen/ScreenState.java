package com.sparcsky.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.sparcsky.game.Assets;
import com.sparcsky.game.core.KalawakanImpakto;

/**
 * Created by IAN on 2/10/2018.
 */

public abstract class ScreenState implements Screen {

    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();
    float mouseX = Gdx.input.getX();
    float mouseY = Gdx.input.getY();

    protected KalawakanImpakto game;
    Assets assets;

    public ScreenState(KalawakanImpakto game) {
        this.game = game;
        this.assets = Assets.getInstance();
    }

    public abstract void update(float delta);


    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        assets.dispose();
    }
}
