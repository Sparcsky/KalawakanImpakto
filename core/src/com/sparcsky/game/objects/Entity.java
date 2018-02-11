package com.sparcsky.game.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by IAN on 2/11/2018.
 */

public class Entity extends GameObject {

    private static final float ANIM_SPEED = .05f;
    private float stateTime;

    private Animation<TextureRegion> animation;

    private float speed = 1;

    public void follow(float x, float y, float distance) {
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

    public void setAnimation(TextureAtlas atlas, String name) {
        animation = new Animation<TextureRegion>(ANIM_SPEED, atlas.findRegions(name), Animation.PlayMode.LOOP);
    }
}
