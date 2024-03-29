package com.mygdx.snakey.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.snakey.AssetLoader;
import com.mygdx.snakey.Map;
import com.mygdx.snakey.Player;
import com.mygdx.snakey.Snakey;

import java.util.Vector;

public class MainScreen implements Screen {

    Map map;

    Player player;

    OrthographicCamera camera;

    ScreenViewport viewport;

    Stage stage;

    public static float width;

    public static float height;

    public MainScreen(Map map, Player player) {

        this.map = map;

        this.player = player;

        width = Gdx.graphics.getWidth();

        height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(width, height);

        viewport = new ScreenViewport(camera);

        camera.setToOrtho(false, width, height);

        stage = new Stage();

        stage.setViewport(viewport);

        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.graphics.getDeltaTime();
        Snakey.get().batch.setProjectionMatrix(camera.combined);
        Snakey.get().batch.begin();
        map.render(Snakey.get().batch);
        player.render(Snakey.get().batch);
        Snakey.get().batch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.position.set(width / 2f, height / 2f, 0);
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
