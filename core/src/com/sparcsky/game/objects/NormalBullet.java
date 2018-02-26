package com.sparcsky.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by IAN
 * on 2/11/2018.
 */

public class NormalBullet extends Entity implements Bullet {

    private float angle;
    private float fireDelay;

    public NormalBullet(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void move(float x, float y) {
        float dx = x - this.posX;
        float dy = y - this.posY;
        angle = MathUtils.atan2(dy, dx);

        setRotation(angle * MathUtils.radDeg);
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        posX += (MathUtils.cos(angle) * speed);
        posY += (MathUtils.sin(angle) * speed);
    }

    @Override
    public boolean isOutOfBounds() {
        return getX() > Gdx.graphics.getWidth() || getX() < 0 || getY() > Gdx.graphics.getHeight() || getY() < 0;
    }
}
