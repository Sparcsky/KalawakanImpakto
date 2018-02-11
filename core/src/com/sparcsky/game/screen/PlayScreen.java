package com.sparcsky.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.sparcsky.game.Assets;
import com.sparcsky.game.core.KalawakanImpakto;
import com.sparcsky.game.objects.Entity;
import com.sparcsky.game.objects.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IAN on 2/10/2018.
 */

public class PlayScreen extends ScreenState {

    private List<GameObject> bullets;
    private GameObject background;
    private Entity player;

    PlayScreen(KalawakanImpakto game) {
        super(game);
        bullets = new ArrayList<GameObject>();

        TextureAtlas entityAtlas = assets.get(Assets.ENTITY_ATLAS);
        TextureAtlas mapAtlas = assets.get(Assets.MAP_ATLAS);

        background = new GameObject();
        background.setRegion(mapAtlas.findRegion("stage", 1));
        background.setSize(screenWidth, screenHeight);

        player = new Entity();
        player.setAnimation(entityAtlas, "player_walk");
        player.setSize(50, 50);
    }

    @Override
    public void show() {

    }

    @Override
    public void update(float delta) {
        this.mouseX = Gdx.input.getX();
        this.mouseY = (screenHeight - Gdx.input.getY());

        player.follow(mouseX, mouseY, 5);

        background.update(delta);
        player.update(delta);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        background.render(game.batch);
        player.render(game.batch);
    }

}
