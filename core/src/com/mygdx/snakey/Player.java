package com.mygdx.snakey;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Player {

    Texture snakeHead;
    private final int rectSize = 32;

    private int snakeX = 0;
    private int snakeY = 0;
    public Player() {
        snakeHead = new Texture(Snakey.get().assetHandler.loadHead.getTextureData());
    }

    public void render(SpriteBatch batch) {
        batch.draw(snakeHead, snakeX, snakeY);
    }
}
