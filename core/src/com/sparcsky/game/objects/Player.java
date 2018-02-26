package com.sparcsky.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IAN
 * on 2/13/2018.
 */

public class Player extends Entity {

    private List<Bullet> bullets;
    private BulletType bulletType;

    private float fireDelay;

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
        bullets = new ArrayList<Bullet>();
        health = 100;
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            if (bullet.isOutOfBounds()) {
                iterator.remove();
            }
            bullet.update(delta);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);

        for (Bullet bullet : bullets) {
            bullet.render(batch);
        }
    }

    public void fire(Bullet bullet, float x, float y) {
        bullet.move(x, y);
        fireDelay = fireDelay * Gdx.graphics.getDeltaTime();
        if (fireDelay <= 0) {
            bullets.add(bullet);
            fireDelay += 0.2f;
        }
    }
}
