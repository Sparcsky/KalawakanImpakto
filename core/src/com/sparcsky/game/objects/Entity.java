package com.sparcsky.game.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

/**
 * Created by IAN on 2/11/2018.
 */

public class Entity extends GameObject {

    protected Animation<TextureRegion> animation;

    private static final float ANIM_SPEED = .05f;
    private float stateTime;
    private float speed = 1;

    public void follow(float x, float y) {
        float dx = (x - getWidth() / 2) - sprite.getX();
        float dy = (y - getHeight() / 2) - sprite.getY();

        float angle = MathUtils.atan2(dy, dx);

        sprite.setRotation(MathUtils.radDeg * angle);

        position.x += MathUtils.cos(angle) * speed;
        position.y += MathUtils.sin(angle) * speed;
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        TextureRegion frame = animation.getKeyFrame(stateTime += delta, true);
        sprite.setRegion(frame);
    }

    public void attack() {

    }

    public void setAnimation(TextureAtlas atlas, String name) {
        Array<TextureAtlas.AtlasRegion> regions = atlas.findRegions(name);

        animation = new Animation<TextureRegion>(ANIM_SPEED, regions);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
