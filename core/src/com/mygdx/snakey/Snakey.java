package com.mygdx.snakey;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.snakey.screens.MainScreen;

public class Snakey extends Game {

	private static Snakey snakey;
	public SpriteBatch batch;
	Map map;

	Player player;
	public AssetLoader assetHandler = new AssetLoader();

	@Override
	public void create () {
		assetHandler.LoadAssets();
		batch = new SpriteBatch();
		map = new Map();
		player = new Player();

		Gdx.graphics.setWindowedMode(800, 800);
		setScreen(new MainScreen(map, player));
	}

	
	@Override
	public void dispose () {
		batch.dispose();
		assetHandler.manager.dispose();
	}

	public static Snakey get() {
		if (snakey == null) {
			snakey = new Snakey();
		}
		return snakey;
	}
}
