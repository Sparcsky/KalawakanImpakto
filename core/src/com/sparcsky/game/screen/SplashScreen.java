package com.sparcsky.game.screen;

import com.badlogic.gdx.Game;
import com.sparcsky.game.Assets;
import com.sparcsky.game.core.KalawakanImpakto;

/**
 * Created by IAN on 2/10/2018.
 */

public class SplashScreen extends ScreenState {

    public SplashScreen(KalawakanImpakto game) {
        super(game);
        Assets.getInstance().loads();
    }

    @Override
    public void show() {
    }

    @Override
    public void update(float delta) {
        if (Assets.getInstance().update()) {
            game.screens.pop();
            game.screens.push(new PlayScreen(game));
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

}
