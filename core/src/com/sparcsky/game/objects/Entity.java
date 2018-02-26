package com.sparcsky.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

/**
 * Created by IAN
 * on 2/11/2018.
 */

public class Entity {

    private Animation<TextureRegion> animation;
    private static final float ANIM_SPEED = .05f;
    private float stateTime;

    protected Sprite sprite;
    float posX, posY, speed, health;

    public Entity(float x, float y, float width, float height) {
        this.posX = x;
        this.posY = y;
        sprite = new Sprite();
        sprite.setSize(width, height);
        sprite.setPosition(x, y);
    }

    public void followTarget(Entity target, float radius) {
        float dx = target.getX() - sprite.getX();
        float dy = target.getY() - sprite.getY();
        float angle = MathUtils.atan2(dy, dx);
        double len = Math.sqrt(dx * dx + dy * dy);

        if (radius < len) {
            dx = MathUtils.cos(angle);
            dy = MathUtils.sin(angle);

            speed = 100 * Gdx.graphics.getDeltaTime();
            posX += dx * speed;
            posY += dy * speed;
        }
        //     sprite.setRotation(angle * MathUtils.radDeg);
    }

    public void setRegion(TextureAtlas.AtlasRegion region) {
        sprite.setRegion(region);
    }

    public void update(float delta) {
        sprite.setPosition(posX, posY);
        if (animation != null) {
            updateAnimation(delta);
        }
    }

    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    private void updateAnimation(float delta) {
        stateTime = stateTime + delta;
        sprite.setRegion(animation.getKeyFrame(stateTime, true));
    }

    public void setAnimation(Array<TextureAtlas.AtlasRegion> regions) {
        animation = new Animation<TextureRegion>(ANIM_SPEED, regions);
    }

    public void setSize(float width, float height) {
        sprite.setSize(width, height);
    }

    public void setRotation(float rotation) {
        sprite.setRotation(rotation);
    }

    public void setPosition(float x, float y) {
        this.posX = x;
        this.posY = y;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getRotation() {
        return sprite.getRotation();
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public float getHeight() {
        return sprite.getHeight();
    }
}
