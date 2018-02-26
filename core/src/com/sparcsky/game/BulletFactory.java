package com.sparcsky.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.sparcsky.game.objects.Bullet;
import com.sparcsky.game.objects.BulletType;
import com.sparcsky.game.objects.Entity;
import com.sparcsky.game.objects.NormalBullet;

/**
 * Created by IAN
 * on 2/25/2018.
 */

public class BulletFactory {


    public static Bullet createBullet(BulletType type, float x, float y) {
        TextureAtlas atlas = Assets.getInstance().get(Assets.ENTITY_ATLAS);
        Entity bullet = null;
        switch (type) {
            case NORMAL:
                bullet = new NormalBullet(x, y, 32, 32);
                bullet.setAnimation(atlas.findRegions("bullets"));
        }

        bullet.setSpeed(5);
        return (Bullet) bullet;
    }
}
