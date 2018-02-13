package com.sparcsky.game.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by IAN on 2/11/2018.
 */

public class Entity extends GameObject {

    private Animation<TextureRegion> animation;
     float speed = 520;

    private static final float ANIM_SPEED = .05f;
    private float stateTime;

    public Entity(Vector2 position) {
        this.position = position;
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        TextureRegion frame = animation.getKeyFrame(stateTime += delta, true);
        sprite.setRegion(frame);
    }

    public void setAnimation(Array<TextureAtlas.AtlasRegion> regions) {
        animation = new Animation<TextureRegion>(ANIM_SPEED, regions);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


}
