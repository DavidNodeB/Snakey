package com.mygdx.snakey;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;


public class Player {
    private Direction currentDirection;
    Texture textureHead;
    Texture textureBody;
    Texture textureTail;
    ArrayList<Sprite> snake;
    ArrayList<Vector2> pastPositions;
    private final int tileSize = 40;
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
    public Player() {
        textureHead = new Texture(Snakey.get().assetHandler.loadHead.getTextureData());
        textureBody = new Texture(Snakey.get().assetHandler.loadBody.getTextureData());
        textureTail = new Texture(Snakey.get().assetHandler.loadTail.getTextureData());
        snake = new ArrayList<>();
        pastPositions = new ArrayList<>();
        float x = 0;
        float y = 0;

        Sprite spriteHead = new Sprite(textureHead, tileSize, tileSize);
        spriteHead.setPosition(x, y);
        pastPositions.add(new Vector2(x, y));

        Sprite spriteBody = new Sprite(textureBody, tileSize, tileSize);
        x+=tileSize;
        spriteBody.setPosition(x, y);
        pastPositions.add(new Vector2(x, y));

        Sprite spriteTail = new Sprite(textureTail, tileSize, tileSize);
        x+=tileSize;
        spriteTail.setPosition(x, y);
        pastPositions.add(new Vector2(x, y));

        setCurrentDirection(Direction.RIGHT);

        snake.add(spriteTail);
        snake.add(spriteBody);
        snake.add(spriteHead);
    }

    public void render(SpriteBatch batch) {
        for (Sprite sprite : snake) {
            sprite.draw(batch);
        }
    }
    public void moveSnake(float xAmount, float yAmount) {
        // body and tail
        for(int i = 0; i < pastPositions.size() - 1; i++) {
            pastPositions.get(i).x = pastPositions.get(i + 1).x;
            pastPositions.get(i).y = pastPositions.get(i + 1).y;
        }
        // head
        pastPositions.get(pastPositions.size() - 1).x += xAmount;
        pastPositions.get(pastPositions.size() - 1).y += yAmount;
        for (int i = 0; i < pastPositions.size(); i++) {
            snake.get(i).setX(pastPositions.get(i).x);
            snake.get(i).setY(pastPositions.get(i).y);
        }
    }
    public void movePlayer() {
        switch (currentDirection) {
            case UP:
                moveSnake(0f, tileSize);
                break;
            case DOWN:
                moveSnake(0f, -tileSize);
                break;
            case LEFT:
                moveSnake(-tileSize, 0f);
                break;
            case RIGHT:
                moveSnake(tileSize, 0f);
                break;
        }
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
}
