package com.mygdx.snakey;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetLoader {
    public AssetManager manager;
    public TextureAtlas atlas;
    public Sprite apple;
    public Sprite body_bottomleft;
    public Sprite body_bottomright;
    public Sprite body_horizontal;
    public Sprite body_topleft;
    public Sprite body_topright;
    public Sprite body_vertical;
    public Sprite head_down;
    public Sprite head_left;
    public Sprite head_right;
    public Sprite head_up;
    public Sprite tail_down;
    public Sprite tail_left;
    public Sprite tail_right;
    public Sprite tail_up;
    public Texture loadLight;
    public Texture loadDark;


    public AssetLoader() {
        manager = new AssetManager();
    }

    public void LoadAssets() {
        LoadTiles();
        manager.finishLoading();
        getTiles();
        atlas = new TextureAtlas(Gdx.files.internal("snakegame/snakegame.atlas"));
        CreateSprite();
    }

    public void CreateSprite() {
        apple = atlas.createSprite("apple");
        body_bottomleft = atlas.createSprite("body_bottomleft");
        body_bottomright = atlas.createSprite("body_bottomright");
        body_horizontal = atlas.createSprite("body_horizontal");
        body_topleft = atlas.createSprite("body_topleft");
        body_topright = atlas.createSprite("body_topright");
        body_vertical = atlas.createSprite("body_vertical");
        head_down = atlas.createSprite("head_down");
        head_left = atlas.createSprite("head_left");
        head_right = atlas.createSprite("head_right");
        head_up = atlas.createSprite("head_up");
        tail_down = atlas.createSprite("tail_down");
        tail_left = atlas.createSprite("tail_left");
        tail_right = atlas.createSprite("tail_right");
        tail_up = atlas.createSprite("tail_up");
    }

    public void LoadTiles() {
        manager.load("tiles/light.png", Texture.class);
        manager.load("tiles/dark.png", Texture.class);
    }

    public void getTiles() {
        loadLight = manager.get("tiles/light.png", Texture.class);
        loadDark = manager.get("tiles/dark.png", Texture.class);
    }

    public void dispose() {
        manager.dispose();
        atlas.dispose();
    }
}
