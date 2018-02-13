package com.sparcsky.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.sparcsky.game.Assets;
import com.sparcsky.game.core.KalawakanImpakto;
import com.sparcsky.game.objects.Bullet;
import com.sparcsky.game.objects.GameObject;
import com.sparcsky.game.objects.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IAN on 2/10/2018.
 */

public class PlayScreen extends ScreenState {

    private List<Bullet> bullets;
    private GameObject background;
    private Player player;

    PlayScreen(KalawakanImpakto game) {
        super(game);
        bullets = new ArrayList<Bullet>();

        TextureAtlas entityAtlas = assets.get(Assets.ENTITY_ATLAS);
        TextureAtlas mapAtlas = assets.get(Assets.MAP_ATLAS);

        cursor.setRegion(entityAtlas.findRegion("bullets"));
        cursor.setSize(50, 50);

        background = new GameObject();
        background.setRegion(mapAtlas.findRegion("stage", 1));
        background.setSize(screenWidth, screenHeight);

        player = new Player(new Vector2(screenWidth / 2, screenHeight / 2));
        player.setSpeed(5.5f);
        player.setAnimation(entityAtlas.findRegions("player_walk"));
        player.setSize(64, 64);
    }

    @Override
    public void show() {

    }

    @Override
    public void update(float delta) {
        Vector3 mousePos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

        cursor.setPosition(mousePos.x, mousePos.y);
        player.follow(mousePos.x,mousePos.y);

        if (Gdx.input.isTouched()) {

        }

        cursor.update(delta);
        background.update(delta);
        player.update(delta);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        game.batch.setProjectionMatrix(camera.combined);

        background.render(game.batch);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).render(game.batch);
        }
        player.render(game.batch);
        cursor.render(game.batch);
    }

}
