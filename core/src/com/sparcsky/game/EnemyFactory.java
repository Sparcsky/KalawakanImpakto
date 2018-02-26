package com.sparcsky.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.sparcsky.game.objects.Enemy;

/**
 * Created by IAN
 * on 2/26/2018.
 */

public class EnemyFactory {


    public static Enemy createEnemy(EnemySpawner.EnemyType type, float x, float y) {
        Enemy enemy = null;
        switch (type) {
            case SQUID:
                enemy = new Enemy(x, y, 32, 32);
        }

        return enemy;
    }
}
