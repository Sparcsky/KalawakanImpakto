package com.sparcsky.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import com.sparcsky.game.Assets;
import com.sparcsky.game.BulletFactory;
import com.sparcsky.game.core.KalawakanImpakto;
import com.sparcsky.game.objects.Bullet;
import com.sparcsky.game.objects.BulletType;
import com.sparcsky.game.objects.Entity;
import com.sparcsky.game.objects.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IAN on 2/10/2018.
 */

public class PlayScreen extends ScreenState {

    private Entity background;
    private Player player;
    private List<Entity> entities = new ArrayList<Entity>();

    PlayScreen(KalawakanImpakto game) {
        super(game);

        TextureAtlas entityAtlas = Assets.getInstance().get(Assets.ENTITY_ATLAS);
        TextureAtlas mapAtlas = Assets.getInstance().get(Assets.MAP_ATLAS);

        cursor.setAnimation(entityAtlas.findRegions("bullets"));
        cursor.setSize(32, 32);
        cursor.setRotation(90);

        background = new Entity(0, 0, screenWidth, screenHeight);
        background.setRegion(mapAtlas.findRegion("stage", 1));

        player = new Player(screenWidth / 2, screenHeight / 2, 64, 64);
        player.setAnimation(entityAtlas.findRegions("player_walk"));

        entities.add(background);
        entities.add(player);
        entities.add(cursor);
    }

    @Override
    public void show() {

    }

    @Override
    public void update(float delta) {
        Vector3 mouse = camera.unproject(new Vector3(Gdx.input.getX() - player.getWidth() / 2, Gdx.input.getY() + player.getHeight() / 2, 0));
        cursor.setPosition(mouse.x, mouse.y);

        player.followTarget(cursor, 0);

        if (Gdx.input.isTouched()) {
            Bullet bullet = BulletFactory.createBullet(BulletType.NORMAL, player.getX(), player.getY());
            player.fire(bullet, mouse.x, mouse.y);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        game.batch.setProjectionMatrix(camera.combined);

        for (Entity entity : entities) {
            entity.update(delta);
            entity.render(game.batch);
        }
    }
}
