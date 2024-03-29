package com.mygdx.snakey;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
    Texture lightTile;
    Texture darkTitle;
    public final int tileSize = 32;
    public Map() {
        lightTile = Snakey.get().assetHandler.loadLight;
        darkTitle = Snakey.get().assetHandler.loadDark;
    }

    public void render(SpriteBatch batch) {
        for (int x = 0; x < Gdx.graphics.getWidth(); x += tileSize) {
            for (int y = 0; y < Gdx.graphics.getHeight(); y += tileSize) {
                if ((x / tileSize + y / tileSize) % 2 == 0) {
                    batch.draw(lightTile, x, y, tileSize, tileSize);
                } else {
                    batch.draw(darkTitle, x, y, tileSize, tileSize);
                }
            }
        }
    }
}
