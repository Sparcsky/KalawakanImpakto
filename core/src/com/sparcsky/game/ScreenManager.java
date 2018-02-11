package com.sparcsky.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.sparcsky.game.core.KalawakanImpakto;
import com.sparcsky.game.screen.ScreenState;
import com.sparcsky.game.screen.SplashScreen;

import java.util.Stack;

/**
 * Created by IAN on 2/11/2018.
 */

public class ScreenManager {

    private Stack<ScreenState> screens;
    private KalawakanImpakto game;

    public ScreenManager(KalawakanImpakto game) {
        this.game = game;
        screens = new Stack<ScreenState>();
    }

    public void push(ScreenState screen) {
        screens.push(screen);
        game.setScreen(new SplashScreen(game));
    }

    public void pop() {
        if (screens.size() > 0) {
            screens.pop();
        }
    }

    public void render(float delta) {
        game.batch.begin();
        screens.peek().render(delta);
        game.batch.end();
    }

}
