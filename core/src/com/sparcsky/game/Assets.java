package com.sparcsky.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by IAN on 2/10/2018.
 */

public class Assets {

    public static final String ENTITY_ATLAS = "spritesheets/entities.pack";
    public static final String MAP_ATLAS = "spritesheets/maps.pack";

    private AssetManager assetManager = new AssetManager();
    private static Assets instance = new Assets();

    private Assets() {
        assetManager.finishLoading();
    }

    public static Assets getInstance() {
        return instance;
    }

    public void loads() {
        assetManager.load(ENTITY_ATLAS, TextureAtlas.class);
        assetManager.load(MAP_ATLAS, TextureAtlas.class);
    }

    public <T> T get(String file) {
        return assetManager.get(file);
    }

    public boolean update() {
        return assetManager.update();
    }

    public void dispose() {
        assetManager.dispose();
    }

    public float getProgress() {
        return assetManager.getProgress();
    }
}
