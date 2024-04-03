package com.mygdx.snakey;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;


public class Player {
    private Direction currentDirection;
    Sprite head, body, curvedBody, tail;
    ArrayList<Vector2> snake;
    private final int tileSize = 40;
    public enum Direction {
        UP, RIGHT, DOWN, LEFT
    }
    public Player() {
        snake = new ArrayList<>();

        head = Snakey.get().assetHandler.head_right;
        body = Snakey.get().assetHandler.body_vertical;
        curvedBody = Snakey.get().assetHandler.body_topleft;
        tail = Snakey.get().assetHandler.tail_left;

        setCurrentDirection(Direction.RIGHT);

        snake.add(new Vector2(tileSize * 1, tileSize * 1));
        snake.add(new Vector2(tileSize * 1, tileSize * 2));
        snake.add(new Vector2(tileSize * 2, tileSize * 2));
        snake.add(new Vector2(tileSize * 3, tileSize * 2));
        snake.add(new Vector2(tileSize * 3, tileSize * 1));
        snake.add(new Vector2(tileSize * 4, tileSize * 1));

    }

    public void render(SpriteBatch batch) {
        // head
        if (currentDirection == Direction.RIGHT) {
            batch.draw(head, snake.get(0).x, snake.get(0).y, tileSize / 2f, tileSize / 2f, tileSize, tileSize, 1f, 1f, 0);
        } else if (currentDirection == Direction.LEFT) {
            batch.draw(head, snake.get(0).x, snake.get(0).y, tileSize / 2f, tileSize / 2f, tileSize, tileSize, 1f, 1f, 180);
        } else {
            batch.draw(head, snake.get(0).x, snake.get(0).y, tileSize / 2f, tileSize / 2f, tileSize, tileSize, 1f, 1f, currentDirection.ordinal() * 90f + 90f );
        }
        // body
        for (int i = 1; i < snake.size() - 1; i++) {
            Vector2 prev = snake.get(i - 1);
            Vector2 next = snake.get(i + 1);
            Vector2 cur = snake.get(i);

            Sprite sprite = null;
            float rotation = 0;
            if(prev.x == next.x) { // if x is straight
                sprite = body;
            } else if(prev.y == next.y) { // if y is straight
                sprite = body;
                rotation = 90; // correct
            } else { // if x and y are not straight
                sprite = curvedBody;
                if (cur.x > prev.x) {
                    if (next.y > cur.y) rotation = 0;
                    if (next.y < cur.y) rotation = 90; // correct
                }
                if (cur.x < prev.x) {
                    if (next.y > cur.y) rotation = 0;
                    if (next.y < cur.y) rotation = 0;
                }
                if (cur.y < prev.y) {
                    if (next.x > cur.x) rotation = 270; // correct
                    if (next.x < cur.x) rotation = 0;
                }
                if (cur.y > prev.y) {
                    if (next.x > cur.x) rotation = 180; // correct
                    if (next.x < cur.x) rotation = 0;
                }
            }
            batch.draw(sprite, snake.get(i).x, snake.get(i).y, tileSize / 2f, tileSize / 2f, tileSize, tileSize, 1f, 1f, rotation);
        }
        // tail
        batch.draw(tail, snake.get(snake.size() - 1).x, snake.get(snake.size() - 1).y);
    }
    public void moveSnake(float xAmount, float yAmount) {
        snake.remove(snake.size() - 1); // remove tail
        snake.add(0, new Vector2(snake.get(0).x + xAmount, snake.get(0).y + yAmount));

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
