package com.sparcsky.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by IAN
 * on 2/25/2018.
 */

public interface Bullet {

    void move(float x, float y);

    void render(SpriteBatch batch);

    void update(float delta);

    boolean isOutOfBounds();
}
