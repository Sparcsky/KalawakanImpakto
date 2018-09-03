package com.sparcsky.game;

import com.sparcsky.game.objects.Enemy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IAN
 * on 2/26/2018.
 */

public class EnemySpawner {

    public enum EnemyType {
        SQUID
    }

    private List<Enemy> enemies;

    public EnemySpawner() {
        enemies = new ArrayList<Enemy>();
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void spawnFourEnemy(EnemyType type) {
        switch (type) {
            case SQUID:
        }
    }
}
