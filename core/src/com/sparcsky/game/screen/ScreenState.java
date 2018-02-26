package com.sparcsky.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.sparcsky.game.Assets;
import com.sparcsky.game.core.KalawakanImpakto;
import com.sparcsky.game.objects.Entity;

/**
 * Created by IAN on 2/10/2018.
 */

public abstract class ScreenState implements Screen {

    protected KalawakanImpakto game;
    OrthographicCamera camera;
    Entity cursor;

    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();

    public ScreenState(KalawakanImpakto game) {
        this.game = game;

        cursor = new Entity(0, 0, 32, 32);

        camera = new OrthographicCamera(screenWidth, screenHeight);
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
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

        game.batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
        camera.setToOrtho(false, width, height);
        camera.update();
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
        Assets.getInstance().dispose();
    }
}
