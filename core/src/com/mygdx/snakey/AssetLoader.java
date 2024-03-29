package com.mygdx.snakey;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class AssetLoader {
    public AssetManager manager;
    public AssetLoader() {
        manager = new AssetManager();
    }
    public Texture loadLight;
    public Texture loadDark;
    public Texture loadHead;
    public Texture loadBody;
    public Texture loadTail;

    public void LoadAssets() {
        LoadTextures();
        manager.finishLoading();
        getTextures();
    }

    public void LoadTextures() {
        manager.load("head/head_up.png", Texture.class);
        manager.load("head/head_down.png", Texture.class);
        manager.load("head/head_left.png", Texture.class);
        manager.load("head/head_right.png", Texture.class);
        manager.load("body/body_bottomleft.png", Texture.class);
        manager.load("body/body_bottomright.png", Texture.class);
        manager.load("body/body_horizontal.png", Texture.class);
        manager.load("body/body_topleft.png", Texture.class);
        manager.load("body/body_topright.png", Texture.class);
        manager.load("body/body_vertical.png", Texture.class);
        manager.load("tail/tail_down.png", Texture.class);
        manager.load("tail/tail_left.png", Texture.class);
        manager.load("tail/tail_right.png", Texture.class);
        manager.load("tail/tail_up.png", Texture.class);
        manager.load("tiles/light.png", Texture.class);
        manager.load("tiles/dark.png", Texture.class);
    }

    public void getTextures() {
        loadLight = manager.get("tiles/light.png");
        loadDark = manager.get("tiles/dark.png");
        loadHead = manager.get("head/head_right.png");
        loadBody = manager.get("body/body_horizontal.png");
        loadTail = manager.get("tail/tail_left.png");
    }

    public void dispose() {
        manager.dispose();
    }
}
