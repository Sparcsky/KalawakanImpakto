package com.sparcsky.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by IAN on 2/11/2018.
 */

public class GameObject {

    public Vector2 position;
    Sprite sprite;

    float rotation;

    public GameObject() {
        sprite = new Sprite();
        position = new Vector2();
    }

    public void update(float delta) {
        sprite.setPosition(position.x, position.y);
    }

    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void setPosition(float x, float y) {
        this.position.x = x - getWidth() / 2;
        this.position.y = y - getHeight() / 2;
    }

    public void setSize(float width, float height) {
        sprite.setSize(width, height);
        sprite.setOriginCenter();
    }

    public void setRegion(TextureRegion region) {
        sprite.setRegion(region);
    }

    public float getHeight() {
        return sprite.getHeight();
    }

    public float getWidth() {
        return sprite.getWidth();
    }

    public float getX() {
        return sprite.getX();
    }

    public float getY() {
        return sprite.getY();
    }

    public Vector2 getPosition() {
        return position;
    }
}
