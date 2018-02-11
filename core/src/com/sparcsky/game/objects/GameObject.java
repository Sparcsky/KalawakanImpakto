package com.sparcsky.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by IAN on 2/11/2018.
 */

public class GameObject {

    Vector2 position;
    Sprite sprite;

    float rotation;
    float width;
    float height;

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
        this.position.x = x;
        this.position.y = y;
    }

    public void setSize(int width, int height) {
        sprite.setSize(width, height);
        sprite.setOriginCenter();
    }

    public void setRegion(TextureRegion region) {
        this.width = region.getRegionWidth();
        this.height = region.getRegionHeight();
        sprite.setRegion(region);
    }

    public void setBounds(float x, float y, float width, float height) {
        this.width = width;
        this.height = height;
        this.position.x = x;
        this.position.y = y;
        sprite.setBounds(x, y, width, height);
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
}
